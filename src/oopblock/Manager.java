package oopblock;

import javax.swing.*;

/**
 * manager is an user that contains additional private fields:
 * position; responsibilityDistrict; workPhoneNumber.
 * Manager object can be created, like user object,
 * but additionally must have position value in process of creation.
 * All additional fields must have getters and setters.
 * Also, manager has the same method printUserInfo,
 * like a user, but this method additionally print all additional fields of manager.
 */
public class Manager extends User {

    private String position;
    private String responsibilityDistrict;
    private String workPhoneNumber;

    public Manager(String fullName, String email, Role role, String position) {
        super(fullName, email, role);
        this.position = position;
    }

    public Manager(String firstName, String lastName, String email, Role role, String position) {
        super(firstName, lastName, email, role);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getResponsibilityDistrict() {
        return responsibilityDistrict;
    }

    public void setResponsibilityDistrict(String responsibilityDistrict) {
        this.responsibilityDistrict = responsibilityDistrict;
    }

    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }

    public void setWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
    }

    @Override
    public void printUserInfo(){
        System.out.println(super.toString() + toString());
    }

    @Override
    public String toString() {
        return "Manager{" +
                "position='" + position + '\'' +
                ", responsibilityDistrict='" + responsibilityDistrict + '\'' +
                ", workPhoneNumber='" + workPhoneNumber + '\'' +
                '}';
    }
}
