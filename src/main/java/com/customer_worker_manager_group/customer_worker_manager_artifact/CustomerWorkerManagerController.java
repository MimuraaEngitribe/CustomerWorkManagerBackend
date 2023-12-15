package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CustomerWorkerManagerController implements GraphQLQueryResolver{

    @Autowired
    private CompanyRepository companyRepository;
    
    @RequestMapping("/getEmploee")  // ルートへこのメソッドをマップする
    public String getEmploee() {
        try {
            String jsonData = new String(Files.readAllBytes(Paths.get("src/main/resources/employees.json")), StandardCharsets.UTF_8);
            return jsonData;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @QueryMapping
    public String getCompanies(@Argument final String id) throws IOException{
        String jsonData = new String(Files.readAllBytes(Paths.get("src/main/resources/company.json")), StandardCharsets.UTF_8);
        return jsonData;
    }

}


