package tests;

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
        if (hondaAccordian.toString().equals("2000 Honda Accordian (0 mi)")) {
            System.out.println("Testcase 4: Passed");
        } else {
            System.out
                    .println("Testcase 4: Failed\nTesting the toString(), expected '2000 Honda Accordian (0 mi)', got '"
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
        if (hondaAccordian.getModel().equals("2000 Honda Accordian (15 mi)")) {
            System.out.println("Testcase 8: Passed");
        } else {
            System.out.println(String.format(
                    "Testcase 8: Failed%nExpecting toString to be '2000 Honda Accordian (15 mi)', got' %s'",
                    hondaAccordian.toString()));
        }

        // Testcase 9
        if (hondaAccordian.getMake().equals("Honda")) {
            System.out.println("Testcase 9: Passed");
        } else {
            System.out.println(
                    String.format("Testcase 9: Failed%nExpecting make to be Honda, got %s", hondaAccordian.getMake()));
        }

        // Testcase 10
        if (hondaAccordian.getModel().equals("Accordian")) {
            System.out.println("Testcase 10: Passed");
        } else {
            System.out.println(String.format("Testcase 10: Failed%nExpecting model to be Accordian, got %s",
                    hondaAccordian.getModel()));
        }

        // Testcase 11
        if (hondaAccordian.getMileage() == 15) {
            System.out.println("Testcase 11: Passed");
        } else {
            System.out.println(String.format("Testcase 11: Failed%nExpecting mileage to be %.1f, got %.1f", 15,
                    hondaAccordian.getMileage()));
        }
    }

    private static void testAccordianDrive() {
        System.out.println("Testing Honda Accordian Driving: ");
        HondaAccordian hondaAccordian = new HondaAccordian(2000);

        // Testcase 1
        System.out.println("Testcase 1: ");
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
    }

    private static void testBirdDrive() {
        System.out.println("Testing Chevrolet Bird Driving: ");
        // Testcase 1
        // TODO
        // Testcase 2
        // TODO
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
        System.out.println("Testing Chevrolet Bird Constructor: ");
        // Testcase 1
        // TODO
        // Testcase 2
        // TODO
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

    }

}


