package oopblock;

import exeptions.PhoneNumberException;
import exeptions.UserNotFoundException;
import interfaces.Actions;
import interfaces.PrintInfo;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * User class that will contains next private fields:
 * id; fullName; firstName; lastName; role;
 * email; deliveryAddress; billingAddress; manager;
 * phoneNumber; cards;
 * <p>
 * and methods:
 * setters for phoneNumber, billingAddress, deliveryAddress, a card and manager.
 * Setter for cards field must add one card to the list;
 * getters for all fields;
 * toString(this method must be created for all classes);
 * printUserInfo(this method must print all user info except of id, cards and manager);
 */
public class User implements Actions, PrintInfo {

    public final static String USERS_FILE = "users.txt";
    private int id;
    private String fullName;
    private String firstName;
    private String lastName;
    private Role role;
    private String email;
    private Address deliveryAddress;
    private Address billingAddress;
    private String manager;
    private String phoneNumber;
    private ArrayList<Card> cardList = new ArrayList<>();
    private static int numberOfInstance;

    /**
     * A User object must be created with values of
     * fullName, email and role type
     * or
     * firstName, lastName, email and role type.
     * fullName value is a firstName and lastName combination separated with space.
     */
    public User(String fullName, String email, Role role) {
        numberOfInstance++;
        this.id = numberOfInstance;
        this.fullName = fullName;
        String[] listOfNames = fullName.split(" ");
        firstName = listOfNames[0];
        for (int i = 1; i < listOfNames.length; i++) {
            if (i == listOfNames.length - 1) {
                lastName = listOfNames[i];
            } else {
                firstName = firstName + " " + listOfNames[i];
            }
        }
        this.email = email;
        this.role = role;
    }

    public User(String firstName, String lastName, String email, Role role) {
        numberOfInstance++;
        this.id = numberOfInstance;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.email = email;
        this.role = role;
    }

    public User(String firstName, String lastName, String email, RoleTypes type) {
        this.id = numberOfInstance;
        numberOfInstance++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fullName = firstName + " " + lastName;
        this.email = email;
        this.role = Role.generateRole(type);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Role getRole() {
        return role;
    }

    public String getEmail() {
        return email;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public String getManager() {
        return manager;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<Card> getCardList() {
        return cardList;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    /**
     * Java additional syntax
     * Step 1. Exceptions:
     *  throw your exception in your previous code.
     */
    public void setPhoneNumber(String phoneNumber) throws PhoneNumberException {
        try {
        if (phoneNumber.startsWith("+")) {
            this.phoneNumber = phoneNumber;
        }else {
           throw new PhoneNumberException("Incorrect phone format, should starts from '+' symbol.");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setCardList(Card card) {
        this.cardList.add(card);
    }

    /**
     *  For the Task 1 in chapter OOP paradigms, create new method
     *  for User class,
     *  that will print all Cards number(use method .forEach(), from ArrayList).
     */
    public void  printCardsNumber(ArrayList<Card> cardList){
        for(Card card : cardList){
            System.out.println(card.getNumber());
        }
    }

    public void printUserInfo() {
        System.out.println("User{" +
                ", fullName='" + fullName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role.toString() +
                ", email='" + email + '\'' +
                ", deliveryAddress=" + deliveryAddress +
                ", billingAddress=" + billingAddress +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardList=" + cardList +
                '}');
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role.toString() +
                ", email='" + email + '\'' +
                ", deliveryAddress=" + deliveryAddress +
                ", billingAddress=" + billingAddress +
                ", manager='" + manager + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cardList=" + cardList +
                '}';
    }

    public String userData() {
        return "User{" +
                ", id = " + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                ", deliveryAddress=" + deliveryAddress +
                ", billingAddress=" + billingAddress +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public void add() {
        try {
            FileWriter writer = new FileWriter(USERS_FILE, true);
            writer.append(this.userData() + "\n");
            System.out.println("User was saved");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static String searchByName(String name) throws UserNotFoundException {
        try {
            FileReader reader = new FileReader(USERS_FILE);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains(name)) {
                    return line;
                }
            }
            scanner.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UserNotFoundException("User " + name + " is not found.");
    }

    public static String searchById(int id) throws UserNotFoundException {
        try {
            FileReader reader = new FileReader(USERS_FILE);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains("id = " + id)) {
                    return line;
                }
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        throw new UserNotFoundException("User with id: " + id + " is not found.");
    }

    @Override
    public void remove(int userId) {
        try (FileReader reader = new FileReader(USERS_FILE);
             Scanner scanner = new Scanner(reader)) {
            StringBuilder st = new StringBuilder();
            String line;
            do {
                line = scanner.nextLine();
                if (!line.contains(String.valueOf(userId))) {
                    st.append(line + "\n");
                }
            } while (scanner.hasNext());
            FileWriter writer = new FileWriter(USERS_FILE);
            writer.write(String.valueOf(st));
            System.out.println("User with id " + userId + " was removed.");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void printInfo() {
        System.out.println(userData());
    }
}
