package basicsyntax;

public class JavaVariables {
    /**
     * Task 1:
     * create new class StepFirst in com.course.syntax package, in this class initialize all
     * types of variables and print them to the console in one row with concatenation.
     * *Try to assign values that are not valid to the type and print them.
     */

    static byte b = 127;
    static short s = -32_768;
    // default value have instance and class variables
    static char chDefault; //default value 0000
    static char ch = 'c';
    static int i = Integer.MAX_VALUE;
    static long l = Long.MIN_VALUE;
    static long lDefault; //default value 0

    public static void main(String[] args) {
        boolean bl = (s < b);
        float f = 12f;
        double dbl = Double.MAX_VALUE;

        System.out.println("result row: " + b + ch + i + l + bl + f + dbl);

        //Reference types refers to an Object, store the address where the object is located
        // As many classes are existed as many types can be created. Example - String.
        String s = "print from new fow: ";
        System.out.println(s + "\n byte: " + b + "\n char: " + ch + "\n char second: " + chDefault + "\n int MAX: " + i
                + "\n long MIN: " + l + "\n long Default: " + lDefault + "\n boolean : " + bl + "\n float: " + f + "\n double MAX: " + dbl);

        // char is stored as int, can be only positive number
        int number = 's';
        short sh1 = 'b';
        char number2 = (short) 83;
        System.out.println(number + sh1 + number2);              //sum of digits
        System.out.println(number + " " + sh1 + " " + number2);  //string

        /**
         * Try to assign values that are not valid to the type and print them.
         */

        //  String str = Integer.MAX_VALUE;    // explicit casting is required
        //   byte b = 5*500;                   // 5*500 > then byte max

        /*
        Final make the variable
         */
        final double e = 2.71;
    }

}


