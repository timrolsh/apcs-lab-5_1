package tests;

import bcatest.BCATestScenario;
import vehicle.ChevroletBird;
public class Group3_1BirdConstructor extends BCATestScenario {
    public int runTest() {
        ChevroletBird c1 = new ChevroletBird(50);
        assertFalse(c1.checkWingsExtended(), "Wings should be retracted");
        assertEquals(c1.toString(), "Chevrolet Bird (50.0 mi)", "Should have 50 miles on constructing");
        assertEquals(String.valueOf(c1.getMaxRange()), "250.0", "Max range should be 250.0");
        assertEquals(String.valueOf(c1.getRemainingRange()), "250.0",
                "Car has never been driven so remainingRange should be maxRange");
        return getFailedCount();
    }
}
