package oopblock;

/**
 * Both addresses contains the same fields:
 * id; country; city; street; building; room; zip code.
 * id must be generated, like user id.
 * Address object must be created only with mentioning next required fields values:
 * country; city; street; building; zip code.
 * All fields must have getters and setters except of setter for id fie
 */
public class Address {

    private int id;
    private String country;
    private String city;
    private String street;
    private String building;
    private String room;
    private int zipCode;

    public Address(String country, String city, String street, String building, int zipCode) {
        this.id = numberOfInstance;
        numberOfInstance++;
        this.country = country;
        this.city = city;
        this.street = street;
        this.building = building;
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    private static int numberOfInstance = 1;

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", building='" + building + '\'' +
                ", room='" + room + '\'' +
                ", zipCode=" + zipCode +
                '}';
    }
}

