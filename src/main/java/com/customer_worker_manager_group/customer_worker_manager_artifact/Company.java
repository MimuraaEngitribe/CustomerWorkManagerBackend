package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Company implements Serializable{
    private String name;
    private String id;

    public Company(){
        this.name = "";
        this.id = "";
    }

    public Company(String name, String id){
        this.name = name;
        this.id = id;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}