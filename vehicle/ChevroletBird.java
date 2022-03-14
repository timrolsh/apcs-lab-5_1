package vehicle;

public class ChevroletBird extends ElectricCar implements Flying {
    private boolean wingsExtended;

    /**
     * Chevrolet Birds have a 250 mile range on a full charge. They start with their
     * wings retracted.
     */
    public ChevroletBird(double startingMileage) {
        super("Chevrolet", "Bird", startingMileage, 250);
        wingsExtended = false;
    }

    /**
     * Defaults mileage to 0.
     */
    public ChevroletBird() {
        super("Chevrolet", "Bird", 250);
        wingsExtended = false;
    }

    /**
     * Returns whether the wings are currently extended.
     */
    public boolean checkWingsExtended() {
        return wingsExtended;
    }

    /**
     * Drives just like all other Electric Cars, except make sure that you retract
     * your wings first (duh).
     * Coding tip: Write this method to re-use the behavior of the superclass drive.
     * Don’t copy-and-paste the same code here.
     */
    @Override
    public void drive(double miles) {
        wingsExtended = false;
        super.drive(miles);
    }

    /**
     * returns true if wings are retracted and the car has enough charge to go that
     * amount of miles
     * //TODO ask if this method is doing what its supposed to and if not update testcase 7 in bird driving
     */
    @Override
    public boolean canFly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("miles %.1f must be at least 0.", miles));
        }
        return wingsExtended && canDrive(miles);
    }

    @Override
    public void fly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("miles %.1f must be at least 0.", miles));
        } else if (!canDrive(miles)) {

            throw new IllegalArgumentException(String.format("cannot fly %.1f miles, max you can go with current " +
                    "charge is %.1f miles", miles, getRemainingRange()));
        }
        wingsExtended = true;
        decreaseCharge(miles);
    }
}
