package com.sky.mybatis.dao;

import com.sky.mybatis.pojo.User;

public interface UserDao {

	//ͨ���û�ID��ѯһ���û�
		public User selectUserById(Integer id);
	
}