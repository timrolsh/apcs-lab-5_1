package tests;

import bcatest.BCATestScenario;
import vehicle.HondaAccordian;

public class Group3_1AccordianConstructor extends BCATestScenario {


    public int runTest() {

        assertThrows(IllegalArgumentException.class, () -> {
            HondaAccordian h = new HondaAccordian(1885);
        }, "Year must be at least 1886");

        assertThrows(IllegalArgumentException.class, () -> {
            HondaAccordian h = new HondaAccordian(-1.0, 1999);
        }, "Can't have a negative starting mileage");

        HondaAccordian c1 = new HondaAccordian(0, 2000);
        assertEquals(c1.getMileage(), 0, .1, "Mileage should be zero");
        assertEquals(c1.getMPG(), 33.2, 0.1, "The MPG should be 33.2");
        assertEquals(c1.getFuelLevel(), 14.5, 0.1, "The fuel level should be 14.5");
        assertEquals(c1.toString(), "2000 Honda Accordian (0.0 mi)", "These should be equal");
        assertEquals(c1.getRemainingRange(), 481.4, 0.1, "Remaining range should be 481.4");
        assertEquals(c1.getMake(), "Honda", "The make should be Honda");
        assertEquals(c1.getModel(), "Accordian", "the model should be Accordian");

        // assertTrue(c1.canDrive(30), "canDrive should be true");
        // c1.drive(30);
        // assertEquals(c1.getMileage(), 30, .1, "Mileage should be 30 after first drive.");

        // c1.drive(200);
        // assertEquals(c1.getMileage(), 230, .1, "Mileage should be 230 after second drive.");

        // assertEquals(c1.getRemainingRange(), c1.getFuelCapacity() * c1.getMPG() - 230, .1, "Remaining range of car not correct after driving twice.");

        // assertFalse(c1.canDrive(252), "Driving 252 should fail.");
        // assertTrue(c1.canDrive(251), "Driving 251 should succeed.");

        // c1.drive(251);
        // assertEquals(c1.getMileage(), 481, .1, "Mileage should be 481 after third drive.");

        // assertThrows(IllegalArgumentException.class, () -> {c1.drive(5);}, "Driving beyond empty should fail.");


        return getFailedCount();
    }
}