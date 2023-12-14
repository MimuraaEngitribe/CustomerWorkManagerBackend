// package com.customer_worker_manager_group.customer_worker_manager_artifact;

// import com.coxautodev.graphql.tools.GraphQLQueryResolver;
// import org.springframework.stereotype.Component;

// @Component
// public class Query implements GraphQLQueryResolver {
//     private final CompanyRepository companyRepository;

//     public Query(CompanyRepository companyRepository) {
//         this.companyRepository = companyRepository;
//     }

//     public Iterable<Company> getCompanies() {
//         return companyRepository.findAll();
//     }

//     public Company getCompanyById(String id) {
//         return companyRepository.findById(id);
//     }
// }