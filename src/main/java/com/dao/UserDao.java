package com.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bean.UserBean;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate stmt;

	public void addUser(UserBean userBean) {
		String insertUser = "insert into SpringBoot(firstname,lastname,email,password)values(?,?,?,?)";
		stmt.update(insertUser, userBean.getFirstname(), userBean.getLastname(), userBean.getEmail(),
				userBean.getPassword());
	}

}
 