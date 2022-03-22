package tests;

import java.util.List;
import java.util.ArrayList;

import bcatest.BCATestScenario;
import vehicle.HondaAccordian;

public class Group3_1AccordianDriveTester extends BCATestScenario{

    @Override
    public int runTest() {
        HondaAccordian h = new HondaAccordian(0, 2018);

        assertThrows(IllegalArgumentException.class, () -> {h.drive(-1);}, "Driving beyond empty should fail.");
        h.drive(0);
        assertEquals(h.getMileage(), 0, 0.1, "Mileage should not increase when driving 0");
        h.drive(33.2);
        assertEquals(h.getMileage(), 33.2, 0.1, "Mileage should be equal to 33.2");
        assertEquals(h.getFuelLevel(), h.getFuelCapacity()-1, 0.01, "Should have lost one mile");
        assertThrows(IllegalArgumentException.class, () -> {h.refillTank(-1);}, "Can not fill up with negative amount");
        assertThrows(IllegalArgumentException.class, () -> {h.refillTank(2);}, "2 should go beyond maximum of the tank");
        h.refillTank();
        assertEquals(h.getFuelLevel(), h.getFuelCapacity(), 0.1, "Fuel should be at max level");
        h.drive(66.4);
        h.refillTank(2);
        assertEquals(h.getFuelLevel(), h.getFuelCapacity(), 0.1, "Fuel should be at max");
        ArrayList<Double> dl = new ArrayList<>();
        dl.add(1.0);
        dl.add(2.0);
        dl.add(3.0);
        dl.add(4.0);
        dl.add(5.0);
        dl.add(-4.0);

        assertThrows(IllegalArgumentException.class, () -> {h.roadTrip(dl);}, "2 should go beyond maximum of the tank");

        ArrayList<Double> d2 = new ArrayList<>();
        d2.add(1.0);
        d2.add(2.0);
        d2.add(3.0);
        d2.add(99999.0);
        double x = h.getMileage();

        assertEquals(h.roadTrip(d2), 3, 0.1, "Should return three");
        assertEquals(h.getMileage(), x+6, 0.1, "Should have traveled Six miles");

        return getFailedCount();
    }

}
