package com.caoxianfei.exits4.bean;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class User {

	private Integer id;
	
	private String name;
	 @DateTimeFormat(pattern = "yyyy-MM-dd")
	 /**
	  * 可能这种时间时间格式 是因为  通过ajax 回显 所以导致时间 转换成 秒数    
	  */
	//利用这种转换格式  能避免 报400错误  且 能让回显的时间变成要求格式的时间	 可能与 ajax 有关。这是转换成 json格式的一种时间方式										
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
	private Date time;

	private String names;
	
	private List<Coupon> list;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public List<Coupon> getList() {
		return list;
	}

	public void setList(List<Coupon> list) {
		this.list = list;
	}

	public User(Integer id, String name, Date time, String names, List<Coupon> list) {
		super();
		this.id = id;
		this.name = name;
		this.time = time;
		this.names = names;
		this.list = list;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", time=" + time + ", names=" + names + ", list=" + list + "]";
	}

	
	
	
}
