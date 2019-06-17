package com.javatechie.es.api.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(indexName="category",type="category",shards=2)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	private String tempId;
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
