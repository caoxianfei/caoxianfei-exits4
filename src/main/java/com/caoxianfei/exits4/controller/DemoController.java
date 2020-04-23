package com.caoxianfei.exits4.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.caoxianfei.exits4.bean.Coupon;
import com.caoxianfei.exits4.bean.User;
import com.caoxianfei.exits4.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Controller
public class DemoController {

	@Autowired
	private UserService service;
	
	@RequestMapping("list.do")
	public String list(@RequestParam(defaultValue = "1")int pageNum,HttpServletRequest request) {
		PageHelper.startPage(pageNum, 3);
		List<User> list = service.list();
		PageInfo<User> info = new PageInfo<User>(list);
		request.setAttribute("list", list);
		request.setAttribute("info", info);
		return "list";
	}
	
	@RequestMapping("update.do")
	public String update(Integer id,HttpServletRequest request) {
		/*
		 * User user = service.selectOne(id); request.setAttribute("user",user);
		 */
		request.setAttribute("id", id);
		return "update";
	}
	
	@RequestMapping("selectCoupon")
	@ResponseBody
	public List<Coupon> getCoupon(){
		return service.selectCoupon();
	}
	
	@RequestMapping("updateto.do")
	@ResponseBody
	public User selectOne(Integer id) {
		
		return service.selectOne(id);
	}
	
	@RequestMapping("allUp.do")
	public String update(User user,Integer[] ids) {
		System.out.println("----------------------------");
		Integer i = service.update(user,ids);
		if(i>0) {
			return "redirect:/list.do";
		}else {
			return "redirect:/update.do";
		}	
	}
	
	@RequestMapping("add.do")
	public String addto() {
		return "add";
	}
	
	@RequestMapping("add.doing")
	public String add(User user,Integer[] ids) {
		Integer i = service.addUser(user, ids);
		if(i>0) {
			return "redirect:/list.do";
		}else {
			return "redirect:/update.do";
		}
	}
	
}
