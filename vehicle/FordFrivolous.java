package vehicle;
class FordFrivolous extends GasPoweredCar implements SelfDriving, Flying{
    private boolean wingsExtended;
    /** FordFrivolous has a gas tank of 20 gallons and an MPG of 23.6. */
    public FordFrivolous(double startingMileage) {
        super("Ford", "Frivolous", startingMileage, 23.6, 20);
    }

    /** Defaults mileage to 0. */
    public FordFrivolous() {
        super("Ford", "Frivolous", 23.6, 20);
    }

    //TODO duplicate code in here and chevrolet bird fix maybe
    /**
     * returns true if wings are retracted and the car has enough charge to go that
     * amount of miles
     */
    @Override
    public boolean canFly(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("miles %.1f must be at least 0.", miles));
        }
        return !wingsExtended && canDrive(miles);
    }

    @Override
    public void fly(double miles) {
        wingsExtended = true;
        super.drive(miles);
    }

    @Override
    public void driveAutonomously(double miles) {
        super.drive(miles);
        
    }
}