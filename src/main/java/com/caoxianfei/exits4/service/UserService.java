package com.caoxianfei.exits4.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.caoxianfei.exits4.bean.Coupon;
import com.caoxianfei.exits4.bean.User;

public interface UserService {

	List<User> list();
	
	User selectOne(Integer id);

	List<Coupon> selectCoupon();

	void dels(Integer id);
	
	Integer update(User user, Integer[] ids);
	
	Integer addCenter(Integer id , Integer cid);
	
	Integer addUser(User user,Integer[] ids);
}
