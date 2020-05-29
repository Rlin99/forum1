package com.forum.entity;

public class User {

	private Integer id;
	
	private String tel;
	
	private String password;
	
	private String salt;
	
	private String name;
	
	private String headLink;
	
	public User() {
		//给所有的属性一个初始值，有的时候注册的时候，他们并没有全部填写，会出错
		this.id=0;
		this.tel="";
		this.password="";
		this.salt="";
		this.name="";
		this.headLink="";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadLink() {
		return headLink;
	}

	public void setHeadLink(String headLink) {
		this.headLink = headLink;
	}
	
}
