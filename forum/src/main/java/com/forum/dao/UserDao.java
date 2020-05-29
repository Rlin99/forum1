package com.forum.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.forum.entity.User;

@Mapper
public interface UserDao {
	
	String TABEL_NAME = "user";	
	String INSERT_FILDS = " tel, password, salt, name, headLink ";
	String SELECT_FILDS = " id,"+ INSERT_FILDS;

	@Select({"select", SELECT_FILDS, "from ", TABEL_NAME, "where tel=#{tel}"})
	User getUserByTel(String tel);

	@Insert({"insert into ", TABEL_NAME, "(", INSERT_FILDS,") values (#{tel}, #{password}, #{salt}, #{name},#{headLink})"})
	void addUser(User user);
}
