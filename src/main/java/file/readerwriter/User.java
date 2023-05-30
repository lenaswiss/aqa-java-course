package file.readerwriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User implements Action {
    /**
     * Task 1: create a program, that will accept User(For the Task 1 in chapter OOP paradigms)
     * object from console and save it to .csv file.
     * Program details: After start console program, I can choose one option from two avaliable
     * add user or print users. When I choose option add user, I can add User object by required
     * fields. When last field is filled, I see message “User was successfully added!” and return
     * to start menu with two options. When I choose option print users all previously added users
     * are printing to the console and return to start menu proceeding.
     */
    private static int id;
    private String name;
    private String email;
    private String password;
    public static final String FILE_NAME = "userdata.txt";

    User(String name, String email, String password) {
        this.id = getId();
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void userData() {
        System.out.println("User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}');
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public void add() {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME, true)) {
            fileWriter.write(this.toString() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void print() {
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            Scanner scanner = new Scanner(fileReader);
            if (!(scanner.hasNext())) {
                System.out.println("File is empty.");
                return;
            }
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine().replaceAll(", password='.*?'", ""));
            }
            fileReader.close();
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *An additional task from the video.
     * Set id for newly created user consequent,
     * taking into account already existing records in the file.
     */
    public static int getId() {
        try {
            FileReader reader = new FileReader(FILE_NAME);
            Scanner scanner = new Scanner(reader);
            ArrayList<String> list = new ArrayList<>();
            int id = 0;
            while (scanner.hasNext()) {
                String str = scanner.nextLine();
                if (!(str == "")) {
                    list.add(str);
                }
            }
            reader.close();
            scanner.close();
            for (String s : list) {
                int index = s.indexOf(',');
                int temp = Integer.parseInt(s.substring(8, index));
                if (id < temp) {
                    id = temp;
                }
            }
            return ++id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ++id;
    }

}
