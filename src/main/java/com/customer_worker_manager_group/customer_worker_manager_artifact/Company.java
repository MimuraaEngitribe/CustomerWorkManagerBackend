package com.customer_worker_manager_group.customer_worker_manager_artifact;

import org.springframework.data.annotation.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Company {
    @Id
    private String id;
    private String name;
}
