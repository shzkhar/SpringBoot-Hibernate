package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bean.UserBean;
import com.dao.UserDao;

@RestController
public class SessionController {
	@Autowired
	UserDao userDao;
	
@RequestMapping(method=RequestMethod.POST, value = "/signUp")

	public UserBean signUp(@RequestBody UserBean userBean)
	{ 
	    userDao.addUser(userBean);
		return userBean;
	}
}
  