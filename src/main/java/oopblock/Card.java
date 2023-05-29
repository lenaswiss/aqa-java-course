package oopblock;

import java.util.Date;

/**
 * Card objects, contains next private fields:
 * id; number; expireDate; cvv; cardType.
 * id must be generated, like user id.
 * All values except of id must be added in process of creation Card object.
 * Also, card class must have getters and setters for all fields except of setter for id.
 */
public class Card {

    private int id;
    private String number;
    private String expireDate;
    private int cvv;
    private String cardType;
    private static int numberOfInstance = 1;
    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getExpireDate() {
        return expireDate;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardType() {
        return cardType;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }


    public Card(String number, String expireDate, int cvv, CardTypes type) {
        this.id = numberOfInstance;
        numberOfInstance++;
        this.number = number;
        this.expireDate = expireDate;
        this.cvv = cvv;
        this.cardType = type.toString();
    }

    @Override
    public String toString() {
        return "Card{" +
                "number=" + number +
                ", expireDate=" + expireDate +
                ", cvv=" + cvv +
                ", cardType='" + cardType + '\'' +
                '}';
    }
}
