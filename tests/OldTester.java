package tests;

import vehicle.ChevroletBird;
import vehicle.HondaAccordian;

import java.util.ArrayList;
import java.util.List;

/**
 * Period 3, group 1 tester.
 * Designed for the following classes:
 * vehicle.HondaAccordian
 * vehicle.ChevroletBird
 * Written by Tim, Sara, Christopher, Krish
 **/
public class OldTester {
    public static void main(String[] args) {
        testAccordianConstructor();
        testAccordianDrive();
        testBirdConstructor();
        testBirdDrive();
    }

    private static void testAccordianConstructor() {
        System.out.println("Testing Honda Accordian Constructor: ");
        HondaAccordian hondaAccordian;
        // Testcase 1
        boolean caughtException = false;
        try {
            new HondaAccordian(1885);
        } catch (IllegalArgumentException exception) {
            caughtException = true;
            System.out.println("Testcase 1: Passed");
        }
        if (!caughtException) {
            System.out.println("Testcase 1: Failed\nAttempted to create a new Honda Accordian in the year 1885, but" +
                    " cars were invented in 1886! An exception should have been thrown.");
        }

        // Testcase 2
        caughtException = false;
        try {
            new HondaAccordian(-1.0, 1999);
        } catch (IllegalArgumentException exception) {
            caughtException = true;
            System.out.println("Testcase 2: Passed");
        }
        if (!caughtException) {
            System.out.println("Testcase 2: Failed\nAttempted to create a new Honda Accordian with a starting mileage " +
                    "of -1.0, and no exception was thrown.");
        }

        // Testcase 3
        try {
            hondaAccordian = new HondaAccordian(0, 2000);
            System.out.println("Testcase 3: Passed");
        } catch (Exception exception) {
            System.out.println("Testcase 3: Failed. Attempted to create a new Honda Accordian with no mileage and in " +
                    "the year 2000 (valid agrs), but an exception was thrown.");
            return;
        }

        // Testcase 4
        if (hondaAccordian.toString().equals("2000 Honda Accordian (0.0 mi)")) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out.println("Testcase 4: Failed\nTesting the toString(), expected '2000 Honda Accordian (0.0 mi)'" +
                    ", got '" + hondaAccordian + "'");
        }

        // Testcase 5
        if (hondaAccordian.getMPG() == 33.2) {
            System.out.println("Testcase 5: Passed");
        } else {
            System.out.printf("Testcase 5: Failed%nExpecting mpg to be %.1f, got %.1f%n", 33.2,
                    hondaAccordian.getMPG());
        }

        // Testcase 6
        if (hondaAccordian.getFuelLevel() == 14.5) {
            System.out.println("Testcase 6: Passed");
        } else {
            System.out.printf("Testcase 6: Failed%nExpecting mpg to be %.1f, got %.1f%n", 14.5,
                    hondaAccordian.getFuelLevel());
        }

        // Testcase 7
        if (hondaAccordian.getRemainingRange() == 481.4) {
            System.out.println("Testcase 7: Passed");
        } else {
            System.out.printf("Testcase 7: Failed%nExpecting mileage to be %.1f, got %.1f%n", 481.4,
                    hondaAccordian.getRemainingRange());
        }

        // Testcase 8
        if (hondaAccordian.getMake().equals("Honda")) {
            System.out.println("Testcase 8: Passed");
        } else {
            System.out.printf("Testcase 8: Failed%nExpecting make to be Honda, got %s%n", hondaAccordian.getMake());
        }

        // Testcase 9
        if (hondaAccordian.getModel().equals("Accordian")) {
            System.out.println("Testcase 9: Passed");
        } else {
            System.out.printf("Testcase 9: Failed%nExpecting model to be Accordian, got %s%n",
                    hondaAccordian.getModel());
        }
    }

    private static void testAccordianDrive() {
        System.out.println("\nTesting Honda Accordian Driving: ");
        HondaAccordian hondaAccordian = new HondaAccordian(2000);

        // Testcase 1
        boolean caughtException = false;
        try {
            hondaAccordian.drive(-1);
        } catch (IllegalArgumentException exception) {
            caughtException = true;
            System.out.println("Testcase 1: Passed");
        }
        if (!caughtException) {
            System.out.println("Testcase 1: Failed\nAttempted to drive -1 miles, but no exception was thrown. ");
        }

        // Testcase 2
        double tempMiles = hondaAccordian.getMileage();
        hondaAccordian.drive(0);
        if (tempMiles == hondaAccordian.getMileage()) {
            System.out.println("Testcase 2: Passed");
        } else {
            System.out.printf("Testcase 2: Failed%nDrove 0 miles, but distance changed from %.1f to %.1f%n",
                    tempMiles, hondaAccordian.getMileage());
        }

        // Testcase 3
        double rightMile = hondaAccordian.getMileage() + 33.2, rightGallon = hondaAccordian.getFuelLevel() - 1;
        hondaAccordian.drive(33.2);
        if (hondaAccordian.getMileage() == rightMile && hondaAccordian.getFuelLevel() == rightGallon) {
            System.out.println("Testcase 3: Passed");
        } else {
            System.out.printf("Testcase 3: Failed%nExpecting mileage to be %.1f and gallons to be %.1f, but mileage " +
                    "is at %.1f and gallons are at %.1f%n", rightMile, rightGallon, hondaAccordian.getMileage(),
                    hondaAccordian.getFuelLevel());
        }
        // Testcase 4
        try {
            hondaAccordian.refillTank(-1);
            System.out.println("Testcase 4: Failed\nAttempted to fill the tank with -1 gallons, but no " +
                    "exception was thrown. ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Testcase 4: Passed");
        }

        // Testcase 5
        try {
            hondaAccordian.refillTank(2);
            System.out.println("Testcase 5: Failed\nAttempted to fill the tank with 2 gallons which would overflow " +
                    "it, but no exception was thrown. ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Testcase 5: Passed");
        }

        // Testcase 6
        hondaAccordian.refillTank();
        if (hondaAccordian.getFuelCapacity() == hondaAccordian.getFuelLevel()) {
            System.out.println("Testcase 6: Passed");
        } else {
            System.out.println("Testcase 6: Failed\nAttempted to refill the tank but fuel level is not at the" +
                    " capacity of the car.");
        }

        // Testcase 7
        List<Double> roadTripList = new ArrayList<>();
        roadTripList.add(1.0);
        roadTripList.add(2.0);
        roadTripList.add(3.0);
        roadTripList.add(4.0);
        roadTripList.add(5.0);
        roadTripList.add(-4.0);
        try {
            hondaAccordian.roadTrip(roadTripList);
            System.out.println("Testcase 7: Failed\nAttemped to go on a road trip [1,2,3,4,5,-4] and no exception" +
                    " was thrown for -4 being negative mile range.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Testcase 7: Passed");
        }

        // Testcase 8
        rightMile = hondaAccordian.getMileage() + 6;
        roadTripList.clear();
        roadTripList.add(1.0);
        roadTripList.add(2.0);
        roadTripList.add(3.0);
        roadTripList.add(99999.0);
        int stops = hondaAccordian.roadTrip(roadTripList);
        if (stops == 3 && hondaAccordian.getMileage() == rightMile) {
            System.out.println("Testcase 8: Passed");
        } else {
            System.out.printf("Testcase 8: Failed%nWent on road trip [1,2,3,99999], car traveled for %d stops " +
                    "when it was supposed to travel for 3 and car mileage is %.1f when it is supposed to be %.1f.%n",
                    stops, hondaAccordian.getMileage(), rightMile);
        }
        // TODO we need some more testcases here or we might now ill ask him next class
    }

    private static void testBirdDrive() {
        System.out.println("\nTesting Chevrolet Bird Driving: ");
        ChevroletBird chevroletBird = new ChevroletBird();

        // Testcase 1
        try {
            chevroletBird.drive(-1);
            System.out.println("Testcase 1: Failed\nAttempted to drive -1 miles and no exception was thrown");
        } catch (IllegalArgumentException exception) {
            System.out.println("Testcase 1: Passed");
        }

        // Testcase 2
        chevroletBird.fly(0);
        if (chevroletBird.checkWingsExtended() && chevroletBird.getRemainingRange() == chevroletBird.getMaxRange()) {
            System.out.println("Testcase 2: Passed");
        } else {
            // TODO try to get the boolean condition in here too not just the remaining
            // range idk how to format booleans in java
            System.out.printf("Testcase 2: Failed%nAttemped to fly 0 miles, expecting wings extended to be true " +
                    "and remaining range to be 250 but the remaining range was %.1f%n",
                    chevroletBird.getRemainingRange());
        }

        // Testcase 3
        try {
            chevroletBird.drive(251);
            System.out.println("Testcase 3: Failed\nAttempted to drive 251 miles, whih is more than the max range, " +
                    "but no exception was thrown.");
        } catch (IllegalArgumentException exception) {
            System.out.println("Testcase 3: Passed");

        }
        // Testcase 4
        double goalMile = chevroletBird.getMileage() + 100, goalRange = chevroletBird.getRemainingRange() - 100;
        chevroletBird.drive(100);
        if (chevroletBird.getMileage() == goalMile && chevroletBird.getRemainingRange() == goalRange) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out.printf("Testcase 4: Failed%nTried to drive for 100 miles, expected mileage to be %.1f but " +
                    "mileage was %.1f, and battery range to be %.1f but battery range was %.1f.%n", goalMile,
                    chevroletBird.getMileage(), goalRange, chevroletBird.getRemainingRange());
        }

        // Testcase 5
        if (chevroletBird.getRemainingRange() == 150) {
            System.out.println("Testcase 5: Passed");
        } else {
            System.out.printf("Testcase 5: Failed. After 100 mile drive, expected range to be 150 but it was %.1f.%n",
                    chevroletBird.getRemainingRange());
        }

        // Testcase 6
        chevroletBird.recharge();
        if (chevroletBird.getMaxRange() == chevroletBird.getRemainingRange()) {
            System.out.println("Testcase 6: Passed");
        } else {
            System.out.println("Testcase 6: Failed\nAttempted to recharge the car but the range does not equal to " +
                    "the maximum range of the battery.");
        }

        // Testcase 7
        if (!chevroletBird.canFly(1)) {
            System.out.println("Testcase 7: Passed");
        } else {
            System.out.println("Testcase 7: Failed\nThe car should not be able to fly because the wings are retracted");
        }

        // Testcase 8
        if (chevroletBird.getMileage() == 100) {
            System.out.println("Testcase 8: Passed");
        } else {
            System.out.printf("Testcase 8: Failed%nExpecting mileage to be 100 but mileage is at %.1f.%n",
                    chevroletBird.getMileage());
        }

        // Testcase 9
        goalMile = chevroletBird.getMileage();
        goalRange = chevroletBird.getRemainingRange() - 50;
        boolean goalWings = true;
        chevroletBird.fly(50);
        if (chevroletBird.checkWingsExtended() == goalWings && chevroletBird.getRemainingRange() == goalRange
                && chevroletBird.getMileage() == goalMile) {
            System.out.println("Testcase 9: Passed");
        } else {
            //TODO figure out how to format booleans and also include the info about wings being extended in here
            System.out.printf("Testcase 9: Failed%nAttempted to fly 50 meters, mileage expected to be %.1f but " +
                    "was %.1f, range was expected to be %.1f but was %.1f.%n", goalMile, chevroletBird.getMileage(),
                    goalRange, chevroletBird.getRemainingRange());
        }
        // TODO we need some more testcases here or we might now ill ask him next class
    }

    private static void testBirdConstructor() {
        System.out.println("\nTesting Chevrolet Bird Constructor: ");

        // Testcase 1
        ChevroletBird chevroletBird = new ChevroletBird(50);
        if (chevroletBird.getMileage() == 50) {
            System.out.println("Testcase 1: Passed");
        } else {
            System.out.printf("Testcase 1: Failed%nAttemped to create bird with mileage 50, but bird's mileage " +
                    "is %.1f%n", chevroletBird.getMileage());
        }

        // Testcase 2
        if (!chevroletBird.checkWingsExtended()) {
            System.out.println("Testcase 2: Passed");
        } else {
            System.out.println("Testcase 2: Failed%nNewly created bird should have wings retracted, but this " +
                    "one has its wings extended");
        }

        // Testcase 3
        if (chevroletBird.toString().equals("Chevrolet Bird (50.0 mi)")) {
            System.out.println("Testcase 3: Passed");
        } else {
            System.out.printf("Testcase 3: Failed%nExpecting toString to be 'Chevrolet Bird (50.0 mi)' but it is %s%n",
                    chevroletBird);
        }

        // Testcase 4
        if (chevroletBird.getMaxRange() == 250) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out.printf("Testcase 4: Failed%nExpecting maxRange to be 250, but max range is %.1f%n",
                    chevroletBird.getMaxRange());
        }

        // Testcase 5
        if (chevroletBird.getRemainingRange() == 250) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out.printf("Testcase 4: Failed%nExpecting range to be 250 since the car has not gone anywhere yet," +
                    " but range is %.1f%n", chevroletBird.getRemainingRange());
        }

        // Testcase 6
        chevroletBird = new ChevroletBird();
        if (chevroletBird.getMileage() == 0) {
            System.out.println("Testcase 6: Passed");
        } else {
            System.out.println("Testcase 6: Failed\nCretaed a bird with a no arg Constructor and mileage is not 0. ");
        }
        // TODO we need some more testcases here or we might now ill ask him next class
    }
}
