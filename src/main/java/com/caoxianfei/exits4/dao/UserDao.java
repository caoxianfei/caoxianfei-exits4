package com.caoxianfei.exits4.dao;

import java.util.List;

import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.caoxianfei.exits4.bean.Coupon;
import com.caoxianfei.exits4.bean.User;

public interface UserDao {

	List<User> list();
	
	User selectOne(Integer id);
	@Select("select * from coupon")
	List<Coupon> selectCoupon();

	void dels(Integer id);
	
	Integer update(@Param("u")User user, Integer[] ids);
	
	Integer addCenter(@Param("id")Integer id ,@Param("cid") Integer cid);
	
	Integer addUser(@Param("u")User user,Integer[] ids);
}
