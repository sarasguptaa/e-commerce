package com.example.mongodbexample.entityDto;

public class SubcategoryDtoClass {


    private String id;

    private String subcid;
    private String subname;
    private String pid[];

    public String getSubcid() {
        return subcid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
