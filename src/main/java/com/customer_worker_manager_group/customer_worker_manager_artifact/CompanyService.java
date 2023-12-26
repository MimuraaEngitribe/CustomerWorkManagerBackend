package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Transactional
@Service
public class CompanyService {

    private final CompanyMapper mapper;  // UserMapperをCompanyMapperに変更
    
    // 全件取得
    public List<Company> selectAll() {
        return mapper.selectAll();
    }

    // １件取得
    public Company selectCompanyByName(String Name) {
        return mapper.selectCompanyByName(Name);
    }

    // 保存（更新）
    public void save(Company company) {
        if (company.getId() == null) {
            mapper.insert(company);
        } else {
            mapper.updateByPrimaryKey(company);
        }
    }

    // 削除
    public void deleteByPrimaryKey(Long id) {
        mapper.deleteByPrimaryKey(id);
    }
}