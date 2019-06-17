package com.javatechie.es.api.dto;





public class CategoryDto {

    private String cid;
    private String cname;
    private String subcid[];

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

    public String[] getSubcid() {
        return subcid;
    }

    public void setSubcid(String[] subcid) {
        this.subcid = subcid;
    }
}

