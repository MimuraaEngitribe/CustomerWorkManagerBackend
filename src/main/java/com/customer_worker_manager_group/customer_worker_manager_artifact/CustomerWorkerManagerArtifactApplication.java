package com.customer_worker_manager_group.customer_worker_manager_artifact;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.customer_worker_manager_group.customer_worker_manager_artifact")
public class CustomerWorkerManagerArtifactApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerWorkerManagerArtifactApplication.class, args);
	}

}
