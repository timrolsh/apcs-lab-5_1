package vehicle;

public abstract class GasPoweredCar extends Car {

    private final double mpg;
    private final double fuelCapacity;
    private double fuelLevel;

    /**
     * Note: Start with a full tank of gas
     *
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    protected GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons) {
        super(make, model, startingMileage);
        if (mpg <= 0) {
            throw new IllegalArgumentException(String.format("mpg %.1f has to be greater than 0", mpg));
        } else if (fuelCapacityGallons <= 0) {
            throw new IllegalArgumentException(
                    String.format("fuel capacity %.1f has to be greater than 0", fuelCapacityGallons));
        }
        this.mpg = mpg;
        this.fuelCapacity = fuelCapacityGallons;
        // start with a full tank of gas
        this.fuelLevel = fuelCapacityGallons;
    }

    /**
     * Defaults mileage to 0.
     *
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    protected GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons) {
        super(make, model);
        if (mpg <= 0) {
            throw new IllegalArgumentException(String.format("mpg %.1f has to be greater than 0", mpg));
        } else if (fuelCapacityGallons <= 0) {
            throw new IllegalArgumentException(
                    String.format("fuel capacity %.1f has to be greater than 0", fuelCapacityGallons));
        }
        this.mpg = mpg;
        this.fuelCapacity = fuelCapacityGallons;
        // start with a full tank of gas
        this.fuelLevel = fuelCapacityGallons;
    }

    /**
     * Drives the full given number of miles.
     *
     * @throws IllegalArgumentException if miles is negative.
     * @throws IllegalArgumentException if miles is too high given the current fuel.
     */
    public void drive(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("Miles %.1f must be at least 0. ", miles));
        }
        if (!canDrive(miles)) {
            throw new IllegalArgumentException(
                    String.format("Cannot drive %.1f miles, max you can drive with your " + "fuel is %.1f miles", miles,
                            getRemainingRange()));
        }
        addMileage(miles);
        decreaseFuelLevel(miles);
    }

    /**
     * Returns how many miles can be driven on one gallon of gas.
     */
    public double getMPG() {
        return this.mpg;

    }

    /**
     * Returns how many gallons of fuel are currently in the car.
     */
    public double getFuelLevel() {
        return this.fuelLevel;

    }

    /**
     * Returns how many gallons of fuel the car can hold at max.
     */
    public double getFuelCapacity() {
        return this.fuelCapacity;

    }

    /**
     * Refuels the car to max fuel capacity.
     */
    public void refillTank() {
        this.fuelLevel = this.fuelCapacity;

    }

    /**
     * Returns how many more miles the car can currently go without refueling.
     */
    public double getRemainingRange() {
        return Double.parseDouble(String.format("%.1f", this.fuelLevel * this.mpg));
    }

    /**
     * Attempt to refuel the car with additional gallons.
     *
     * @throws IllegalArgumentException if gallons is negative OR gallons would
     *                                  overfill the tank.
     */
    public void refillTank(double gallons) {
        // adding 0.1 as a delta
        if (this.fuelLevel + gallons > this.fuelCapacity + 0.1) {
            throw new IllegalArgumentException(String.format(
                    "Adding %.1f gallons to the tank while it's fuel level "
                            + "is %.1f gallons would cause it to overflow (%.1f > %.1f)",
                    gallons, getFuelLevel(), (gallons + getFuelCapacity()), getFuelCapacity()));
        } else if (gallons < 0) {
            throw new IllegalArgumentException(String.format("Gallons %.1f must be a positive value.", gallons));
        }
        this.fuelLevel += gallons;
    }

    /**
     * Decreases the amount of fuel in the gas tank based upon
     * mpg and the number of miles passed as an argument.
     */
    protected void decreaseFuelLevel(double miles) {
        if (miles < 0) {
            throw new IllegalArgumentException(String.format("miles %.1f must be at least 0.", miles));
        } else if (miles / mpg > fuelLevel) {
            throw new IllegalArgumentException(String.format(
                    "decreasing fuel level by %.1f miles (%.1f gallons) "
                            + "would cause you to have a negative number of gallons in the tank",
                    miles, (miles / mpg)));
        }
        fuelLevel -= (miles / mpg);
    }
}
