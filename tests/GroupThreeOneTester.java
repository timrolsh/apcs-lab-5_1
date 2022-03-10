package tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import vehicle.ChevroletBird;
import vehicle.HondaAccordian;

/**
 * Period 3, group 1 tester.
 * Designed for the following classes:
 * vehicle.HondaAccordian
 * vehicle.ChevroletBird
 * Written by Tim, Sara, Christopher, Krish
 **/
public class GroupThreeOneTester {
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
            hondaAccordian = new HondaAccordian(1885);
        } catch (IllegalArgumentException exception) {
            caughtException = true;
            System.out.println("Testcase 1: Passed");
        }
        if (!caughtException) {
            System.out.println(
                    "Testcase 1: Failed\nAttempted to create a new Honda Accordian in the year 1885, but cars were invented in 1886! An exception should have been thrown.");
        }

        // Testcase 2
        caughtException = false;
        try {
            hondaAccordian = new HondaAccordian(-1.0, 1999);
        } catch (IllegalArgumentException exception) {
            caughtException = true;
            System.out.println("Testcase 2: Passed");
        }
        if (!caughtException) {
            System.out.println(
                    "Testcase 2: Failed\nAttempted to create a new Honda Accordian with a starting mileage of -1.0, and no exception was thrown.");
        }

        // Testcase 3
        try {
            hondaAccordian = new HondaAccordian(0, 2000);
            System.out.println("Testcase 3: Passed");
        } catch (Exception exception) {
            System.out.println(
                    "Testcase 3: Failed. Attempted to create a new Honda Accordian with no mileage and in the year 2000 (valid agrs), but an exception was thrown.");
            return;
        }

        // Testcase 4
        if (hondaAccordian.toString().equals("2000 Honda Accordian (0.0 mi)")) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out
                    .println(
                            "Testcase 4: Failed\nTesting the toString(), expected '2000 Honda Accordian (0.0 mi)', got '"
                                    + hondaAccordian.toString() + "'");
        }

        // Testcase 5
        if (hondaAccordian.getMPG() == 33.2) {
            System.out.println("Testcase 5: Passed");
        } else {
            System.out.println(String.format("Testcase 5: Failed%nExpecting mpg to be %.1f, got %.1f", 33.2,
                    hondaAccordian.getMPG()));
        }

        // Testcase 6
        if (hondaAccordian.getFuelLevel() == 14.5) {
            System.out.println("Testcase 6: Passed");
        } else {
            System.out.println(String.format("Testcase 6: Failed%nExpecting mpg to be %.1f, got %.1f", 14.5,
                    hondaAccordian.getFuelLevel()));
        }

        // Testcase 7
        if (hondaAccordian.getRemainingRange() == 481.4) {
            System.out.println("Testcase 7: Passed");
        } else {
            System.out.println(String.format("Testcase 7: Failed%nExpecting mileage to be %.1f, got %.1f", 481.4,
                    hondaAccordian.getRemainingRange()));
        }

        // Testcase 8
        if (hondaAccordian.getMake().equals("Honda")) {
            System.out.println("Testcase 8: Passed");
        } else {
            System.out.println(
                    String.format("Testcase 8: Failed%nExpecting make to be Honda, got %s", hondaAccordian.getMake()));
        }

        // Testcase 9
        if (hondaAccordian.getModel().equals("Accordian")) {
            System.out.println("Testcase 9: Passed");
        } else {
            System.out.println(String.format("Testcase 9: Failed%nExpecting model to be Accordian, got %s",
                    hondaAccordian.getModel()));
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
            System.out
                    .println(String.format("Testcase 2: Failed%nDrove 0 miles, but distance changed from %.1f to %.1f",
                            tempMiles, hondaAccordian.getMileage()));
        }

        // Testcase 3
        double rightMile = hondaAccordian.getMileage() + 33.2, rightGallon = hondaAccordian.getFuelLevel() - 1;
        hondaAccordian.drive(33.2);
        if (hondaAccordian.getMileage() == rightMile && hondaAccordian.getFuelLevel() == rightGallon) {
            System.out.println("Testcase 3: Passed");
        } else {
            System.out.println(String.format(
                    "Testcase 3: Failed%nExpecting mileage to be %.1f and gallons to be %.1f, but mileage is at %.1f and gallons are at %.1f",
                    rightMile, rightGallon, hondaAccordian.getMileage(), hondaAccordian.getFuelLevel()));
        }
        // Testcase 4
        try {
            hondaAccordian.refillTank(-1);
            System.out.println(
                    "Testcase 4: Failed\nAttempted to fill the tank with -1 gallons, but no exception was thrown. ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Testcase 4: Passed");
        }

        // Testcase 5
        try {
            hondaAccordian.refillTank(2);
            System.out.println(
                    "Testcase 5: Failed\nAttempted to fill the tank with 2 gallons which would overflow it, but no exception was thrown. ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Testcase 5: Passed");
        }

        // Testcase 6
        hondaAccordian.refillTank();
        if (hondaAccordian.getFuelCapacity() == hondaAccordian.getFuelLevel()) {
            System.out.println("Testcase 6: Passed");
        } else {
            System.out.println(
                    "Testcase 6: Failed\nAttempted to refill the tank but fuel level is not at the capacity of the car.");
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
            System.out.println(
                    "Testcase 7: Failed\nAttemped to go on a road trip [1,2,3,4,5,-4] and no exception was thrown for -4 being negative mile range.");
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
            System.out.println(String.format(
                    "Testcase 8: Failed%nWent on road trip [1,2,3,99999], car traveled for %d stops when it was supposed to travel for 3 and car mileage is %.1f when it is supposed to be %.1f.",
                    stops, hondaAccordian.getMileage(), rightMile));
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
            System.out.println(String.format(
                    "Testcase 2: Failed%nAttemped to fly 0 miles, expecting wings extended to be true and remaining range to be 250 but the remaining range was %.1f",
                    chevroletBird.getRemainingRange()));
        }

        // Testcase 3
        // TODO
        // Testcase 4
        // TODO
        // Testcase 5
        // TODO
        // Testcase 6
        // TODO
        // Testcase 7
        // TODO
        // Testcase 8
        // TODO
        // Testcase 9
        // TODO
        // Testcase 10
        // TODO
        // Testcase 11
        // TODO
        // Testcase 12
        // TODO
        // Testcase 13
        // TODO
        // Testcase 14
        // TODO
        // Testcase 15
        // TODO
    }

    private static void testBirdConstructor() {
        System.out.println("\nTesting Chevrolet Bird Constructor: ");

        // Testcase 1
        ChevroletBird chevroletBird = new ChevroletBird(50);
        if (chevroletBird.getMileage() == 50) {
            System.out.println("Testcase 1: Passed");
        } else {
            System.out.println(String.format(
                    "Testcase 1: Failed%nAttemped to create bird with mileage 50, but bird's mileage is %.1f",
                    chevroletBird.getMileage()));
        }

        // Testcase 2
        if (!chevroletBird.checkWingsExtended()) {
            System.out.println("Testcase 2: Passed");
        } else {
            System.out.println(
                    "Testcase 2: Failed%nNewly created bird should have wings retracted, but this one has its wings extended");
        }

        // Testcase 3
        if (chevroletBird.toString().equals("Chevrolet Bird (50.0 mi)")) {
            System.out.println("Testcase 3: Passed");
        } else {
            System.out.println(String.format(
                    "Testcase 3: Failed%nExpecting toString to be 'Chevrolet Bird (50.0 mi)' but it is %s",
                    chevroletBird.toString()));
        }

        // Testcase 4
        if (chevroletBird.getMaxRange() == 250) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out.println(String.format("Testcase 4: Failed%nExpecting maxRange to be 250, but max range is %.1f",
                    chevroletBird.getMaxRange()));
        }

        // Testcase 5
        if (chevroletBird.getRemainingRange() == 250) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out.println(String.format(
                    "Testcase 4: Failed%nExpecting range to be 250 since the car has not gone anywhere yet, but range is %.1f",
                    chevroletBird.getRemainingRange()));
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
