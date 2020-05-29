package com.forum.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.forum.entity.LoginTicket;
import com.forum.entity.User;

public interface LoginTicketDao {

	String TABEL_NAME = "loginTicket";	
	String INSERT_FILDS = " tel, ticket, status, expired ";
	String SELECT_FILDS = " id,"+ INSERT_FILDS;

	@Select({"select", SELECT_FILDS, "from ", TABEL_NAME, "where tel=#{tel}"})
	User getUserByTel(String tel);

	@Insert({"insert into ", TABEL_NAME, "(", INSERT_FILDS,") values (#{tel}, #{ticket}, #{status}, #{expired})"})
	void addLoginTicket(LoginTicket loginTicket);
}
