package oopblock;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        User user = new User("Lena", "Test", "email@g.com", RoleTypes.ADMIN);
        user.add();
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
                    } while (!email.contains("@"));

                    List<String> roleIds = Arrays.asList("1","2","3","4");
                    do {
                        System.out.println("enter role id: 1 = Admin; 2 = main customer; 3 = customer; 4 = viewer. ");
                        roleId = scanner.nextLine();
                    } while (!roleIds.contains(roleId));
                    User userNew = new User(name, email, new Role(Integer.valueOf(roleId)));
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
