package com.sky.mybatis.junit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sky.mybatis.mapper.UserMapper;
import com.sky.mybatis.pojo.User;

public class JunitTest {

	@Test
	public void testMapper() throws Exception{
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserMapper mapper = ac.getBean(UserMapper.class);
	//	UserMapper mapper = (UserMapper) ac.getBean("userMapper");
		User user = mapper.findUserById(10);
		System.out.println(user);
	}
	
}
