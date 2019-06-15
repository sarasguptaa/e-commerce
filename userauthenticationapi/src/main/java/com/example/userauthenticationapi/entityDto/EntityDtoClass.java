package com.example.userauthenticationapi.entityDto;

public class EntityDtoClass {
    final static public String TABLE_NAME="user";
    private String userId;
    private String firstName;
    private String lastName;
    private String emailAdd;
    private String password;
    private long phoneNumber;
    private String savedAddresses[];

    public static String getTableName() {
        return TABLE_NAME;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAdd() {
        return emailAdd;
    }

    public void setEmailAdd(String emailAdd) {
        this.emailAdd = emailAdd;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String[] getSavedAddresses() {
        return savedAddresses;
    }

    public void setSavedAddresses(String[] savedAddresses) {
        this.savedAddresses = savedAddresses;
    }
}
