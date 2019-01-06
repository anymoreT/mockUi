package com.hdw.MockUi.entity;

public class UserInfo {
    private String psname;
    private String cardno;
    private int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setCardno(String cardno) {
        this.cardno = cardno;
    }

    public void setPsname(String psname) {
        this.psname = psname;
    }

    public String getPsname() {
        return psname;
    }

    public String getCardno() {
        return cardno;
    }

    public int getId() {
        return id;
    }
}
