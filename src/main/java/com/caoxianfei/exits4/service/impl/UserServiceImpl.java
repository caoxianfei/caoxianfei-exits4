package com.caoxianfei.exits4.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caoxianfei.exits4.bean.Coupon;
import com.caoxianfei.exits4.bean.User;
import com.caoxianfei.exits4.dao.UserDao;
import com.caoxianfei.exits4.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao dao;

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return dao.list();
	}

	@Override
	public User selectOne(Integer id) {
		// TODO Auto-generated method stub
		return dao.selectOne(id);
	}

	@Override
	public List<Coupon> selectCoupon() {
		// TODO Auto-generated method stub
		return dao.selectCoupon();
	}

	@Override
	public Integer update(User user, Integer[] ids) {
		// TODO Auto-generated method stub
		dao.dels(user.getId());
		for (int i = 0; i < ids.length; i++) {
			dao.addCenter(user.getId(), ids[i]);
		}
		return dao.update(user,ids);
	}

	@Override
	public void dels(Integer id) {
		// TODO Auto-generated method stub
		dao.dels(id);
	}

	@Override
	public Integer addCenter(Integer id, Integer cid) {
		// TODO Auto-generated method stub
		return dao.addCenter(id, cid);
	}

	@Override
	public Integer addUser(User user, Integer[] ids) {
		// TODO Auto-generated method stub
		Integer i = dao.addUser(user, ids);
		for (int j = 0; j < ids.length; j++) {
			dao.addCenter(user.getId(), ids[j]);
		}
		return i;
	}

	
	
}
