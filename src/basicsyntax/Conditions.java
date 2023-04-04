package basicsyntax;

import java.util.Scanner;

public class Conditions {
    public static void main(String[] args) {

        compareInputtedInt();
        compareInput();
        checkEvenOddDouble();
        checkConditionsForFloat();

    }

    /**
     * Task 1:
     * create a program, that will scan int value from console and print first message if value less than 10,
     * second message if larger, than 10 and if it is equal to 0 - third message.
     */
    public static void compareInputtedInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task 1: ");
        System.out.println("Enter any digest type int");
        try {
            int a = scanner.nextInt();
            if (a == 0) {
                System.out.println("a equal to 0");
            } else if (a < 10) {
                System.out.println("a less than 10");
            } else if (a > 10) {
                System.out.println("a grater than 10");
            } else
                System.out.println("not expected value");
        } catch (Exception e) {
            System.out.println("Unsupported data type");
        }
    }

    public static void compareInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task 2: ");
        System.out.println("Enter any digest type double");
        String a = scanner.nextLine();
        try {
            if (a.contains(".")) {
                double aDouble = Double.valueOf(a);
                if (aDouble == 0l) {
                    System.out.println("a equal to 0");
                } else if (aDouble > 10l) {
                    System.out.println("a grater than 10");
                } else if (aDouble < 10l) {
                    System.out.println("a less than 10");
                } else {
                    System.out.println("not expected value");
                }
            } else {
                int aInt = Integer.valueOf(a);
                if (aInt == 0) {
                    System.out.println("a equal to 0");
                } else if (aInt < 10) {
                    System.out.println("a less than 10");
                } else if (aInt > 10) {
                    System.out.println("a grater than 10");
                } else
                    System.out.println("not expected value");
            }
        } catch (Exception e) {
            System.out.println("Unsupported data type");
        }
    }

    /**
     * Task 2:
     * create a program, that will scan double value from console and if value is odd - first message
     * printing to console, if even - second message printing to console.
     */
    public static void checkEvenOddDouble() {
        System.out.println("Task 3: ");
        Scanner scanner = new Scanner(System.in);
        try {
            double dbl = scanner.nextDouble();
            if (dbl % 2 == 0) {
                System.out.println("Entered number is even"); // 0 is an even number
            } else {
                System.out.println("Entered number is odd");
            }
        } catch (Exception e) {
            System.out.println("Unsupported data type");
        }
    }


    /**
     * Task 3:
     * create a program, that will scan float value from console and if this value is divisible without
     * remainder by 2 and larger than 10 or if value equals 15 - first message is printing to the console,
     * if not - second message is printing to console.
     */
    public static void checkConditionsForFloat() {
        System.out.println("Task 4: ");
        Scanner scanner = new Scanner(System.in);
        try {
            float floatVar = scanner.nextFloat();
            if ((floatVar % 2 == 0 && floatVar > 10) || floatVar == 15) {
                System.out.println("Entered digit is satisfied required conditions: " +
                        "divisible without remainder by 2 AND grater than 10 OR equal 15");
            } else {
                System.out.println("Entered digit is not satisfied required conditions");
            }
        } catch (Exception e) {
            System.out.println("Unsupported data type");
        }
    }


}

