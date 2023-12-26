package com.customer_worker_manager_group.customer_worker_manager_artifact;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CompanyMapper {

	//全件取得
	@Select("SELECT * FROM Company")
	public List<Company> selectAll();

	//1件取得
	@Select("SELECT * FROM Company WHERE name = #{name}")
	public Company selectCompanyByName(String name);

	
	//登録
	@Insert({
		"INSERT INTO company(user_name, email)",
		"VALUES(#{userName}, #{email})"
	})
	int insert(Company record);
	
	
	//更新
	@Update({
		"UPDATE user",
		"SET user_name = #{userName}, email = #{email}",
		"WHERE id = #{id}"
	})
	int updateByPrimaryKey(Company record);
	
	
	//削除
	@Delete({
		"DELETE FROM user",
		"WHERE id = #{id}"
	})
	int deleteByPrimaryKey(Long id);
}
