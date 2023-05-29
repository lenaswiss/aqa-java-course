package oopblock;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("Lena", "Test", "email@g.com", RoleTypes.MAIN_CUSTOMER);
        user.add();
        user.setCardList(new Card("1234 5656 6723 2323", "11/23", 456, CardTypes.MASTER_CARDS));
        user.setCardList(new Card("4953 5656 6723 2323", "109/25", 896, CardTypes.VISA));
        user.printCardsNumber(user.getCardList());
        user.setPhoneNumber("123 323 33 33");
        System.out.println(user.getPhoneNumber());
        user.setPhoneNumber("+123 323 33 33");
        System.out.println(user.getPhoneNumber());
        String name;
        String email;
        String roleId;
        System.out.println("Please select action add | find | remove | exit");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            switch (scanner.nextLine()) {
                case "add" -> {
                    do {
                        System.out.println("enter name");
                        name = scanner.nextLine();
                    } while (name.isEmpty());
                    do {
                        System.out.println("enter email");
                        email = scanner.nextLine();
                        if (!email.contains("@")){
                            System.out.println("Email format is invalid, should contain @ symbol.");//TODO add an error message
                        }
                    } while (!email.contains("@"));

                    List<String> roleIds = Arrays.asList("admin","main customer","customer","viewer");
                    do {
                        System.out.println("enter role user role: admin; main customer; customer; viewer. ");
                        roleId = scanner.nextLine();
                    } while (!roleIds.contains(roleId));
                    User userNew = new User(name, email, Role.generateRole(roleId.toString()));
                    userNew.add();
                    System.out.println("Please select action add | find | remove | exit");

                }
                case "find" -> {
                    System.out.println("Enter user id");
                    System.out.println(User.searchById(scanner.nextInt()));
                    System.out.println("Please select action add | find | remove | exit");
                }
                case "remove" -> {
                    System.out.println("Please enter user id");
                    user.remove(scanner.nextInt());
                    System.out.println("Please select action add | find | remove | exit");
                }
                case "exit" -> {
                    return;
                }
            }
        }
    }
}
