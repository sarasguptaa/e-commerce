package com.javatechie.es.api.dto;

public class SubCategoryDto {


    private String subcid;
    private String subname;
    private String pid[];

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


}
