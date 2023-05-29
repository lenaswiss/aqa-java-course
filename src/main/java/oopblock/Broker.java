package oopblock;

import interfaces.PrintInfo;

import java.util.ArrayList;

public class Broker implements PrintInfo {
    /**
     * Also create a class Broker, that has name, email, phoneNumber and list of clients(User).
     * The Broker class must implement the PrintInfo interface also.
     * Broker objects must be created with all fields values, except of clientsList.
     */

    private String name;
    private String email;
    private String phoneNumber;
    private ArrayList<User> clientsList;

    Broker(String name, String email, String phoneNumber){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ArrayList<User> getClientsList() {
        return clientsList;
    }

    public void setClientsList(ArrayList<User> clientsList) {
        this.clientsList = clientsList;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", clientsList=" + clientsList.toString() +
                '}';
    }

    @Override
    public void printInfo() {
        System.out.println("Broker{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}');
    }
}
