package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
@AllArgsConstructor
public class Company implements Serializable{
    @Id
    private String id;
    private String name;
}