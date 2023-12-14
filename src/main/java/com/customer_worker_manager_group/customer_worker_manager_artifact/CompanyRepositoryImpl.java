package com.customer_worker_manager_group.customer_worker_manager_artifact;

import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class CompanyRepositoryImpl implements CompanyRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void customMethod() {
        // ここにカスタムメソッドの実装を記述
    }
}