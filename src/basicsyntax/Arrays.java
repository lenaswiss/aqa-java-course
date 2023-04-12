package basicsyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class Arrays {

    public static int[] emptyIntArray; // to check null pointer exception, array with default value null.

    public static void main(String[] args) throws IOException {
        // test data
        int[] arrayFirstInt = {1, 10};
        int[] arraySecondInt = {-1, 4, 66, 105, 0, 13};
        double[] arrayFirstDbl = {-15.5, 5, 103.55, 17, 0.1, 0};
        double[] arraySecondDbl = {0.5, 15, 10, 1, 23, -9};
        int[] testArray = {100};
        double[] emptyArray = new double[0];

        avgValueArray(arrayFirstDbl);
        avgValueArray(arrayFirstInt);
        printArray(joinArray(arrayFirstInt, arraySecondInt));

        sortStringBubble("11baABc3frRF");    //task 5 test result in console
        System.out.println(sortStringBubble()); // read string from console, trim spaces


    }

    /**
     * Task 1:
     * calculate average value of given array with numbers and print
     * this value to the console. Program must calculate average value
     * for array with any number of elements.
     */
    public static void avgValueArray(double[] array) {
        try {
            double sum = 0;
            for (double d : array) {
                sum += d;
            }
            System.out.println("AVG of array = " + sum / array.length);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    //checks math exception without try/catch
    public static void avgValueArray(int[] array) {
        if (array == null) {
            System.out.println("Array is empty");
        } else if (array.length == 0 || array == null) {
            System.out.println("The array length 0 ");
        } else {
            int sum = 0;
            for (int i : array) {
                sum += i;
            }
            System.out.println("AVG of array = " + sum / array.length);
        }
    }

    /**
     * Task 2:
     * merge 2 given arrays. Result must be an array, that contains all
     * elements from first and second arrays. Value must be calculated
     * for arrays with any length.
     */
    public static int[] joinArray(int[] a, int[] b) {
        int[] array = new int[a.length + b.length];
        for (int i = 0; i < a.length; ) {
            array[i] = a[i];
            i++;
        }
        for (int i = a.length, j = 0; i < array.length; i++, j++) {
            array[i] = b[j];
        }
        return array;
    }

    public static int[] joinArrayNew(int[] a, int[] b) {
        return IntStream.concat(IntStream.of(a), IntStream.of(b))
                .toArray();
    }

    public static double[] joinArrayNew(double[] a, double[] b) {
        return DoubleStream.concat(DoubleStream.of(a), DoubleStream.of(b))
                .toArray();
    }

    /**
     * Task 3:
     * for exist array with numbers find the biggest
     * number and print it to the console.
     */
    public static void printMaxValue(int[] a) {
        int max = 0;
        for (int i = 0; i < a.length; i++) {
            if (max < a[i]) {
                max = a[i];
            }
        }
        System.out.println("The biggest number in array is " + max);
        System.out.println();
    }

    //for loop replaced by enhanced 'for'
    public static void printMaxValue(double[] a) {
        double max = 0;
        for (double i : a) {
            if (max < i) {
                max = i;
            }
        }
        System.out.println("The biggest number in array is " + max);
        System.out.println();
    }

    /**
     * Task 4:
     * create a program, that will sort by asc given array with
     * numbers and print result array to the console.
     */
    public static int[] bubbleSortArrayASC(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        return a;
    }

    public static void sortArrayASCAndPrint(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
        printArray(a);
    }

    /**
     * Task 5*:
     * bubble sorting realization.
     */
    //using array of chars?
    public static void sortStringBubble(String s) {
        char[] charArray = s.toCharArray();
        char temp;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (Character.toString(charArray[j]).compareTo(Character.toString(charArray[i])) < 0) {
                    temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        for (char c : charArray) {
            System.out.print(c);
        }
    }

    public static String sortStringBubble() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        char[] charArray = str.toCharArray();
        char temp;
        for (int i = 0; i < charArray.length; i++) {
            for (int j = i + 1; j < charArray.length; j++) {
                if (Character.toString(charArray[j]).compareTo(Character.toString(charArray[i])) < 0) {
                    temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        return String.valueOf(charArray).trim();
    }

    //additional methods to print arrays
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(a[i]);
        }
    }

    public static void printArray(double[] a) {
        for (int i = 0; i < a.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(a[i]);
        }
    }
}


