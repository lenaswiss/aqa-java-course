package basicsyntax;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

//        printNumbers();
//        calculateFactorial();
        maxIntegerDivisorOfNumber();
        //   ageValidation();
    }

    /**
     * Task 1(Special):
     * create a program that will print values from 0 to a given number in the console.
     * If the number is negative, an error must be displayed. If the value that will be
     * printed is even - ‘The number is even’ additional message must be printed. If the
     * value that will be printed multiple to 3, only message ‘The number multiple to 3’
     * must be printed in the console.
     */
    public static void printNumbers() {
        System.out.println("Task 1");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print any integer ");
        int a = scanner.nextInt();
        if (a < 0) {
            System.out.println(" error: number is negative");
        } else if (a % 3 == 0 && a != 0) {
            System.out.println("The number multiple to 3");
        } else if (a >= 0 && a % 2 == 0) {
            System.out.println(" The number is even ");
            for (int i = 0; i < a + 1; i++) {
                System.out.print(i + ", ");
            }
        } else {
            int counter = 0;
            do {
                System.out.print(counter + ", ");
                counter++;
                a--;
            } while (a > 0);
        }
        System.out.println();
    }

    /**
     * Task 2:
     * create a program that will calculate and print the factorial value of a given
     * number from the console.
     */
    public static void calculateFactorial() {
        System.out.println("Task 2");
        System.out.println("Enter number to calculate Factorial ");
        Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            long result = 1;
            for (int i = 1; i <= a; i++) {
                result *= i;
            }
            System.out.printf("Factorial of %d = %d", a, result);
        } catch (Exception e) {
            System.out.println(" Error: invalid data type");
        }
        System.out.println();
    }

    /**
     * Task 3:
     * create a program that will find and print the largest integer divisor for
     * a given number in the console. It must not be the given number.
     */
    public static void maxIntegerDivisorOfNumber() {
        System.out.println("Task 3");
        System.out.println(" Enter number ");
        int result = 1;
        Scanner scanner = new Scanner(System.in);
        try {
            int a = scanner.nextInt();
            int b = (a < 0) ? a * -1 : a * 1;
            if (b == 0) {
                System.out.println(" 0 can be divided by any integer, the result will be 0");
            }
            if (b == 1 || a == -1) {
                System.out.printf(" The only one integer divider for %d is 1", a);
            }
            int counter = 2;
            while (counter < b - 1) {
                if (b % counter == 0) {
                    if (b / counter > result) {
                        result = b / counter;
                    }
                }
                counter++;
            }
            System.out.printf("Max divisor for %d is %d ", a, result);
        } catch (Exception e) {
            System.out.println(" Error: invalid data type");
        }
        System.out.println();
    }

    /**
     * Task 4:
     * create a program that will request age value through the console.
     * If the value will be =< 0 or > 140 error must be displayed in the console
     * and age request must be displayed again. The program should stop only if
     * age is typed correctly. Success message must be
     * displayed in that case.
     */
    public static void ageValidation() {
        System.out.println("Task 4");
        Scanner scanner = new Scanner(System.in);
        int age;
        System.out.println("Please enter your age");
        try {
            do {
                age = scanner.nextInt();
                if (age <= 0 || age > 140) {
                    System.out.println("ERROR: incorrect value, try again");
                    System.out.println("Age can be only positive integer between 0 and 140");
                } else {
                    System.out.println("Thank you, your information was successfully saved.");
                }
            } while (age <= 0 || age > 140);

        } catch (Exception e) {
            System.out.println("Invalid data type");
        }
    }
}

