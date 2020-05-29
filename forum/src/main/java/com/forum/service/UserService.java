package com.forum.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.forum.dao.LoginTicketDao;
import com.forum.dao.UserDao;
import com.forum.entity.LoginTicket;
import com.forum.entity.User;
import com.forum.utils.ForumUtils;

@Service
public class UserService {

	@Autowired 
	UserDao userDao;
	
	@Autowired
	LoginTicketDao loginTicketDao;
	
	public Map<String, Object> register(String tel, String password) {
		 Map<String, Object> map = new HashMap<String, Object>();
		 //判断手机号是否为空
		if(tel==null || "".equals(tel)){
			map.put("tel", "手机号不能为空！");
			return map;
		}
		//判断手机号长度是否是11位
		if(tel.length()!=11) {
			map.put("tel", "手机号不正确！");
			return map;
		}
		//判断密码是否为空
		if(password==null || "".equals(password)){
			map.put("password", "密码不能为空！");
			return map;
		}
		//判断密码是否小于6位数
		if(password.length() < 6) {
			map.put("password", "密码至少需要6位！");
			return map;
		}
		User user = userDao.getUserByTel(tel);
		//判断手机号是否被注册
		if(user != null) {
			map.put("tel", "手机号已经被注册！");
			return map;
		}
		user = new User();
		String salt = ForumUtils.getRandomUUID().substring(0, 6);//取6位
		user.setSalt(salt);
		user.setTel(tel);
		user.setPassword(ForumUtils.MD5(password + salt));
		userDao.addUser(user);
		String ticket = addTicket(tel);
		map.put("ticket", ticket);		
		return map;
	}

	private String addTicket(String tel) {
		String ticket = ForumUtils.getRandomUUID();
		long expired = new Date().getTime() + 1000 * 3600 * 24 * 10;//
		LoginTicket loginTicket=new LoginTicket();
		loginTicket.setTel(tel);
		loginTicket.setTicket(ticket);
		loginTicket.setExpired(new java.sql.Date(expired));
		loginTicketDao.addLoginTicket(loginTicket);
		return ticket;
	}
	
}
