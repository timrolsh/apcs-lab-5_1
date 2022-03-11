package vehicle;

public interface Flying {
    /**
     * @throws IllegalArgumentException if miles is negative.
     */
    boolean canFly(double miles);

    /**
     * @throws IllegalArgumentException if miles is negative.
     * @throws IllegalArgumentException if miles exceeds the remaining range of the
     *                                  car.
     */
    void fly(double miles);
}