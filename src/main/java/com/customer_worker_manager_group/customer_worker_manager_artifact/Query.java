package com.customer_worker_manager_group.customer_worker_manager_artifact;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class Query implements GraphQLQueryResolver {
    private static final String JSON_FILE_PATH = "company.json";

	private final CompanyService companyService;

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

    @QueryMapping
    public List<Company> selectAllCompanyOnDatabase() {
        return companyService.selectAll();
    }
}