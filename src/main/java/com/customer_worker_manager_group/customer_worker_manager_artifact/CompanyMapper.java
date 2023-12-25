package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CompanyMapper {
	EntityManagerFactory emf;
	EntityManager entityManager;
	
	public CompanyMapper(){
		// EntityManagerFactory のインスタンスを取得
		emf = Persistence.createEntityManagerFactory("webapp");
		// EntityManager のインスタンスを生成
		entityManager = emf.createEntityManager();
	}
    	
	//全件取得
	public List<Company> selectAll(){
		String query = "select i from Company i";
		List<Company> companies = entityManager.createQuery(query, Company.class).getResultList();
		return companies;
	}

	//1件取得
	public Company selectCompanyByName(String name){
		String query = "select i from Company i where name = #{name}";
		Company company = entityManager.createQuery(query, Company.class).getSingleResult();
		return company;
	}

	
	// //登録
	// @Insert({
	// 	"INSERT INTO company(user_name, email)",
	// 	"VALUES(#{userName}, #{email})"
	// })
	// int insert(Company record);
	
	
	// //更新
	// @Update({
	// 	"UPDATE user",
	// 	"SET user_name = #{userName}, email = #{email}",
	// 	"WHERE id = #{id}"
	// })
	// int updateByPrimaryKey(Company record);
	
	
	// //削除
	// @Delete({
	// 	"DELETE FROM user",
	// 	"WHERE id = #{id}"
	// })
	// int deleteByPrimaryKey(Long id);
}
