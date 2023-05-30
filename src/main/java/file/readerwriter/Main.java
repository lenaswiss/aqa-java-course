package file.readerwriter;

import java.io.FileReader;
import java.util.Scanner;

public class Main {
    /**
     * After start console program, I can choose one option from two avaliable add user or print users
     * (I've added one more option EXIT to be abele add more than one user ).
     * When I choose option add user, I can add User object by required fields.
     * When last field is filled, I see message “User was successfully added!”
     * and return to start menu with two options. When I choose option print users all previously added
     * users are printing to the console and return to start menu proceeding.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Select option: ADD | PRINT | EXIT");
            switch (scanner.nextLine().toLowerCase()) {
                case "add" -> {
                    System.out.println("Enter user name.");
                    String name = scanner.nextLine();
                    System.out.println("Enter user email");
                    String email = scanner.nextLine();
                    System.out.println("password");
                    String password = scanner.nextLine();
                    User user = new User(name, email, password);
                    user.add();
                }
                case "print" -> {
                    User.print();
                }
                case "exit" -> {
                    return;
                }
            }
        }
    }

}
