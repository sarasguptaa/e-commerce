package com.example.mongodbexample.entity;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;

@Document(collection = SubcategoryClass.COLLECTION_NAME)

public class SubcategoryClass {
    public static final String COLLECTION_NAME="SubCategories";

    @Id
    private String id;
    @Field(value = "subcid")
    private String subcid;
    private String subname;
    private String pid[];

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static String getCollectionName() {
        return COLLECTION_NAME;
    }

    public String getSubcid() {
        return subcid;
    }

    public void setSubcid(String subcid) {
        this.subcid = subcid;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String[] getPid() {
        return pid;
    }

    public void setPid(String[] pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "SubcategoryClass{" +
                "id='" + id + '\'' +
                ", subcid='" + subcid + '\'' +
                ", subname='" + subname + '\'' +
                ", pid=" + Arrays.toString(pid) +
                '}';
    }
}
