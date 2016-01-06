package org.rasa.mis.user.registration.beans;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Card")
public class Card {
    private int id;
    private String bank;
    private String cardNo;
    private int validMonth;
    private int validYear;
    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public int getValidMonth() {
        return validMonth;
    }

    public void setValidMonth(int validMonth) {
        this.validMonth = validMonth;
    }

    public int getValidYear() {
        return validYear;
    }

    public void setValidYear(int validYear) {
        this.validYear = validYear;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
