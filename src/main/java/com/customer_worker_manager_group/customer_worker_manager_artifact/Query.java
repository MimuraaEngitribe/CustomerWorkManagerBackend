package com.customer_worker_manager_group.customer_worker_manager_artifact;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Query implements GraphQLQueryResolver {
    private static final String JSON_FILE_PATH = "company.json";

	private CompanyMapper mapper = new CompanyMapper();

    @QueryMapping
    public List<Company> getCompanies() {
        // TODO: 最終的にはリポジトリから取得するように変更する
        //return companyRepository.getCompanies();

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Company> companies = objectMapper.readValue(
                    new ClassPathResource(JSON_FILE_PATH).getInputStream(),
                    new TypeReference<List<Company>>() {}
            );
            return companies;
        } catch (IOException e) {
            throw new RuntimeException("Error reading companies JSON file", e);
        }
    }

    public Company getCompanyByName(String name) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Company> companies = objectMapper.readValue(
                    new ClassPathResource(JSON_FILE_PATH).getInputStream(),
                    new TypeReference<List<Company>>() {}
            );
            return companies.stream()
                            .filter(company -> name.equals(company.getName()))
                            .findFirst()
                            .orElse(null);
        } catch (IOException e) {
            throw new RuntimeException("Error reading companies JSON file", e);
        }
    }

    public List<Company> selectAllCompanyOnDatabase(){
        return mapper.selectAll();
    }

    public Company getCompanyByNameOnDatabase(String name){
        return mapper.selectCompanyByName(name);
    }
}