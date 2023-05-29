package classblocks;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;

public class Parent {
    /**
     * Task 1:  create a class Parent that contains: constructor, static initialization block,
     * initialization block and Child class with the same elements. Each element must have
     * print message with unique text.
     * After, in main method initialize object of child class and analyze sequence of print messages.
     * Pay attention in which order blocks of code will be executed?
     * Add to the task Pull Request a Readme.md file, in which will be sequence of the printed messages
     * and a small text near each line that describes place of code execution.
     */

    public static int counter;
    public String parentName;
    public int parentAge;
    public String gender;

    public static Logger logger = LogManager.getLogger(Parent.class);

    static {
        System.out.println("Static block of parent class is executed. \n " +
                " The static block allows initializing static variables of the class");
        counter++;
        logger.info("Static block of parent class.");
    }

    {
        System.out.println("The block of initialization of parent class is executed. ");
        parentName = "unknown";
        parentAge = 0;
        System.out.println(this.toString());
        logger.info("The block of initialization of parent class.");

    }

    public Parent(String parentName, int parentAge, Gender gender) {
        System.out.println("Parent class constructor is executed");
        this.parentName = parentName;
        this.parentAge = parentAge;
        this.gender = gender.name();
        System.out.println(this.toString());
        logger.info("Parent class constructor is executed.");
    }

    public static void main(String[] args) {
        Parent parent = new Parent("Parent 1", 35, Gender.MAIL);
        Child child = new Child("Child 1", 11, Gender.FEMALE);
    }

    @Override
    public String toString() {
        return "Parent{" +
                "parentName='" + parentName + '\'' +
                ", parentAge=" + parentAge +
                ", gender='" + gender + '\'' +
                '}';
    }
}

class Child extends Parent {

    static {
        System.out.println("Static block of child class is executed. ");
        Parent.counter = 2;
        logger.info("Static block of child class.");
    }

    public Child(String parentName, int parentAge, Gender gender) {
        super(parentName, parentAge, gender);
        System.out.println("Child class constructor is executed");
        System.out.println(this.toString());
        logger.info("Child class constructor is executed");
    }

    {
        System.out.println("The block of initialization of child class is executed. ");
        logger.info("The block of initialization of child class.");
    }
    @Override
    public String toString() {
        return "Child{" +
                "parentName='" + parentName + '\'' +
                ", parentAge=" + parentAge +
                ", gender='" + gender + '\'' +
                '}';
    }
}
