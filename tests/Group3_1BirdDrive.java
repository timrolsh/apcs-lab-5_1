package tests;

import bcatest.BCATestScenario;
import vehicle.ChevroletBird;

public class Group3_1BirdDrive extends BCATestScenario {


    public int runTest() {
        ChevroletBird c1 = new ChevroletBird(2018);

        assertThrows(IllegalArgumentException.class, () -> c1.drive(-1), "Driving mileage cannot be " + "negative.");

        assertTrue(c1.canDrive(30), "canDrive should be true");
        c1.drive(30);
        assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after first drive.");

        assertThrows(IllegalArgumentException.class, () -> c1.drive(221), "Goes of the max charge.");


        assertEquals(c1.getRemainingRange(), 220, .1, "Remaining range should be 220.");

        assertThrows(IllegalArgumentException.class, () -> c1.canDrive(252), "Goes over max range.");

        assertFalse(c1.canFly(1), "Flying should fail, wings are retracted");
        c1.fly(50);
        assertTrue(c1.canFly(10), "Flying should pass, wings work.");

        assertEquals(c1.getMileage(), 30, 0.1, "Mileage has not changed");

        return getFailedCount();

    }
}
