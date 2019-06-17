package com.example.userauthenticationapi.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="userauth")
public class EntityClass {
    final static public String TABLE_NAME="userauth";

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    @Column(name = "user_id")
    private String userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email_add")
    private String emailAdd;
    @Column(name = "password")
    private String password;
    @Column(name="phone_number")
    private long phoneNumber;
    @Column(name="saved_addresses")
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
