package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.util.List;

import org.springframework.stereotype.Repository;

import java.util.Arrays;

@Repository
public class CompanyRepository {
    public List<Company> getCompanies() {
        return Arrays.asList(
            new Company("1", "Company A"),
            new Company("2", "Company B")
            // 省略: 他のデータ
        );
    }
}