package com.example.mongodbexample.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;

@Document(collection = EntityClass.COLLECTION_NAME)
public class EntityClass {
    public static final String COLLECTION_NAME="Categories";

    @Id
    private String id;
    @Field(value = "cid")
    private String cid;
    private String cname;
    private String subid[];

    @Override
    public String toString() {
        return "EntityClass{" +
                "id='" + id + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", subid=" + Arrays.toString(subid) +
                '}';
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String[] getSubid() {
        return subid;
    }

    public void setSubid(String[] subid) {
        this.subid = subid;
    }

    /*    public static final String COLLECTION_NAME="employee";

    @Id
    private String employeeId;
    @Field(value = "first_name")
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String dateOfJoining;
    private boolean isActive;

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    @Override
    public String toString() {
        return "EntityClass{" +
                "employeeId='" + employeeId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfJoining='" + dateOfJoining + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    */

}
