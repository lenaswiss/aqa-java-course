package basicsyntax;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Strings {
    public static void main(String[] args) throws IOException {
        stringFormatPrintAscColumn();                   //task 1 test
        stringFormatPrintEvenWordUppercase();           //task 2 test
        countNumberOfSymbolInString();                  //task 3 test
        separateStringAndPrint();                       //task 4 test
        sortStringBubble("11baABc3frRF");            //task 5 test result in console
        System.out.println(sortStringBubble());         //task 5 test result as new String, trim all spaces

    }

    /**
     * Task 1:
     * for given string sentence from the console delete all spaces
     * and bring it to uppercase, after print result word by letters
     * in column to the console.
     */
    public static void stringFormatPrintAscColumn() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bufferedReader.readLine();
            char[] a = str.replace(" ", "").toUpperCase().toCharArray();
            for (char c : a) {
                System.out.println(c);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Task 2:
     * for given string sentence, check, that sentence contains word java,
     * if yes
     * - reverse the string and print it,
     * if no
     * - print the sentence (each even word must be uppercase).
     */
    public static void stringFormatPrintEvenWordUppercase() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = bufferedReader.readLine();
            StringBuilder sb = new StringBuilder(str);
            if (str.contains("java")) {//looks for any place ignoring prefixes and ending of the word, using spaces it can be changed
                System.out.println(sb.reverse());
            } else {
                ArrayList<String> list = new ArrayList<>();
                if (!str.contains(" ")) {
                    System.out.println(str);
                    return;
                }
                while (str.contains(" ")) {
                    int index = str.indexOf(" ");
                    String temp = str.substring(0, index);
                    list.add(temp);
                    str = str.substring(index + 1);
                }
                for (int i = 0; i < list.size(); i++) {
                    if (i % 2 == 0) {
                        System.out.print(list.get(i).toUpperCase() + " ");
                    } else {
                        System.out.print(list.get(i) + " ");
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Task 3:
     * create a program, that will count number of certain letters
     * in the sentence. Program must read from the console sentence
     * and after read a symbol, number of which must be count.
     * Program must print count of certain letters to the console.
     */
    public static void countNumberOfSymbolInString() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int counter = 0;
        System.out.println("****** Enter the sentence, please. *******");
        String str = null;
        str = reader.readLine();
        System.out.println("****** Enter a single symbol, please. ******");
        String symbol = reader.readLine();
        if (symbol.isEmpty()) {
            return;
        }
        if (!str.contains(symbol)) {
            System.out.println(symbol + " was not found in given sentence.");
        } else {
            char[] charArray = str.toCharArray();
            char c = symbol.charAt(0);
            for (int i = 0; i < charArray.length; i++) {
                if (charArray[i] == c) {
                    counter++;
                }
            }
        }
        switch (counter) {
            case 0:
                break;
            case 1:
                System.out.println("Only one symbol" + " \"" + symbol + "\" " + "was found in the entered sentence.");
                break;
            default:
                System.out.println(counter + " \"" + symbol + "\" " + "symbols were found in the entered sentence.");
        }
    }

    /**
     * Task 4*:
     * for a given string from the console in PascalCase separate the
     * words by “ ” symbol, before each uppercase letter, like in a sentence.
     * Print the new sentence to the console.
     */
    public static void separateStringAndPrint() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter string in PascalCase.");
        String str = reader.readLine();
        if (str.isEmpty()) {
            System.out.println("Empty string was entered.");
        } else if (str.contains(" ")) {
            System.out.println("Wrong string format, expected PascalCase.");
        } else if (!str.contains(" ") && !str.isEmpty()) {
            int counter = 0;
            char[] charArray = str.toCharArray();
            for (int i = 0; i < charArray.length; i++) {
                if (Character.isUpperCase(charArray[i])) {
                    if (!Character.isUpperCase(charArray[0])) {
                        counter = -1;
                        break;
                    }
                    counter++;
                }
            }
            switch (counter) {
                case -1:
                    System.out.println("Wrong format string.");
                    break;
                case 0:
                    System.out.println("The string does not contains symbols in Uppercase.");
                    break;
                case 1:
                    System.out.println("The string contains only one word starts from Uppercase, cannot be parsed.");
                    break;
                default:
                    ArrayList<String> wordsArray = new ArrayList<>();
                    int index = 0;
                    for (int i = 0; i < charArray.length; i++) {
                        if (Character.isUpperCase(charArray[i])) {
                            wordsArray.add(str.substring(index, i));
                            index = i;
                        }
                        if (i == (charArray.length - 1)) {
                            wordsArray.add(str.substring(index));
                        }
                    }
                    for (String s : wordsArray) {
                        System.out.print(s + " ");
                    }

            }

        }

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
}
