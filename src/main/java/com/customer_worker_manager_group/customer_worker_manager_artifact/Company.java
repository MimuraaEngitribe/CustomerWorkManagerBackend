package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.io.Serializable;

import jakarta.persistence.Id;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Company implements Serializable{
    @Id
    private String id;
    private String name;
}
