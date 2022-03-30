package vehicle;

public class TeslaModelZ extends ElectricCar implements SelfDriving {
    protected int modelNum;

    /**
     * modelNum specifies the model number. Tesla cares about that stuff. Tesla
     * Model Z’s have a 340 mile range on a full charge.
     * For a Tesla, the make is Tesla. The model is Z. The model number is an
     * additional value.
     */
    public TeslaModelZ(double startingMileage, int modelNumber) {
        super("Tesla", "Z", startingMileage, 340);
        this.modelNum = modelNumber;
    }

    /**
     * Defaults mileage to 0.
     */
    public TeslaModelZ(int modelNumber) {
        super("Tesla", "Z", 340);
        this.modelNum = modelNumber;
    }

    /**
     * Returns the model number.
     */
    public int getModelNum() {
        return modelNum;

    }

    /**
     * Returns the model and model number concatenated together. For example,
     * returns "Z70" for modelNum 70.
     */
    @Override
    public String getModel() {
        return String.format("%s%d", super.getModel(), modelNum);
    }

    /**
     * Prints out the make, model, model number, and mileage. Ex: "Tesla Z70 (30.0
     * mi)"
     * You may not need to implement this method depending on how you implement
     * Car.toString()
     */
    @Override
    public String toString() {
        return String.format("%s %s (%.1f mi)", getMake(), getModel(), getMileage());
    }

    @Override
    public void driveAutonomously(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("miles %.1f must be at least 0.", miles));
        }
        if (miles > getRemainingRange()) {
            miles = getRemainingRange();
        }
        super.addMileage(miles);
        decreaseCharge(miles);
    }
}