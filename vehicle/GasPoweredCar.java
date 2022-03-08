package vehicle;
abstract class GasPoweredCar extends Car {
    
    private double mpg;
    private double fuelCapacity;
    private double fuelLevel;
    /**
     * Note: Start with a full tank of gas
     * 
     * @throws IllegalArgumentException if mpg or fuelCapacityGallons are
     *                                  non-positive.
     */
    public GasPoweredCar(String make, String model, double startingMileage, double mpg, double fuelCapacityGallons) {
        super(make, model, startingMileage);
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
    public GasPoweredCar(String make, String model, double mpg, double fuelCapacityGallons) {
        super(make, model);
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

    }

    /** Returns how many miles can be driven on one gallon of gas. */
    public double getMPG() {
        return this.mpg;

    }

    /** Returns how many gallons of fuel are currently in the car. */
    public double getFuelLevel() {
        return this.fuelLevel;

    }

    /** Returns how many gallons of fuel the car can hold at max. */
    public double getFuelCapacity() {
        return this.fuelCapacity;

    }

    /** Refuels the car to max fuel capacity. */
    public void refillTank() {
        this.fuelLevel = this.fuelCapacity;

    }

    /** Returns how many more miles the car can currently go without refueling. */
    public double getRemainingRange() {
        return this.fuelLevel * this.mpg;
    }

    /**
     * Attempt to refuel the car with additional gallons.
     * 
     * @throws IllegalArgumentException if gallons is negative OR gallons would
     *                                  overfill the tank.
     */
    public void refillTank(double gallons) {
        if (this.fuelLevel + gallons > this.fuelCapacity ) {
            throw new IllegalArgumentException(String.format("Adding %.1f gallons to the tank while it's fuel level is %.1f would cause it to overflow (%.1f > %.1f)", gallons, this.fuelLevel, (gallons + this.fuelLevel), this.fuelCapacity));
        }
        else if (gallons < 0) {
            throw new IllegalArgumentException(String.format("Gallons %.1f must be a positive value.", gallons));
        }
        this.fuelLevel += gallons;
    }

    /**
     * Decreases the amount of fuel in the gas tank based upon
     * mpg and the number of miles passed as an argument.
     */
    protected void decreaseFuelLevel(double miles) {

    }

}
