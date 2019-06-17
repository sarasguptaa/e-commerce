package com.javatechie.es.api.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "subcat",type="subcat",shards = 2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubCategory {
    @Id
    private String tempId;
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
