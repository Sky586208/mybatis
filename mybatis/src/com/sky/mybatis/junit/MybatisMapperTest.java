package com.sky.mybatis.junit;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.sky.mybatis.mapper.OrderMapper;
import com.sky.mybatis.mapper.UserMapper;
import com.sky.mybatis.pojo.Orders;
import com.sky.mybatis.pojo.QueryVo;
import com.sky.mybatis.pojo.User;

public class MybatisMapperTest {

	
	@Test
	public void testMapper() throws Exception{
		
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//SqlSession帮我生成一个实现类 （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		User user = userMapper.findUserById(10);
		System.out.println(user);
		
	}
	
	@Test
	public void testMapperQueryVo() throws Exception{
		
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//SqlSession帮我生成一个实现类 （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		QueryVo vo = new QueryVo();
		User user = new User();
		user.setUsername("五");
		vo.setUser(user);
		
		List<User> us = userMapper.findUserByQueryVo(vo);
		
		for (User u : us) {
		
			System.out.println(u);
		}
	}
	
	@Test
	public void testMapperQueryVoCount() throws Exception{
		
		//加载核心配置文件
		String resource = "sqlMapConfig.xml";
		InputStream in = Resources.getResourceAsStream(resource);
		//创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
		//创建SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		
		//SqlSession帮我生成一个实现类 （给接口）
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		
		  Integer i = userMapper.countUser();
		
			System.out.println(i);
	}
	
	
	//查询订单所有数据
	@Test
	public void testOrderList() throws Exception{
		//加载核心配置文件
				String resource = "sqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(resource);
				//创建SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				//创建SqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				OrderMapper mapper = sqlSession.getMapper(OrderMapper.class);
				
				List<Orders> ordersList = mapper.selectOrderList();
				for(Orders orders : ordersList) {
					System.out.println(orders);
				}
	}
	
	//根据性别和名字查询用户
	@Test
	public void testfindUserBySexAndUsername() throws Exception{
		//加载核心配置文件
				String resource = "sqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(resource);
				//创建SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				//创建SqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				
				User user = new User();
				user.setSex("1");
				user.setUsername("张小明");
				List<User> users = userMapper.selectUserBySexAndUsername(user);
				
				for(User user2 : users) {
					System.out.println(user2);
				}
	}
	//多个ID
	@Test
	public void testfindUserIds() throws Exception{
		//加载核心配置文件
				String resource = "sqlMapConfig.xml";
				InputStream in = Resources.getResourceAsStream(resource);
				//创建SqlSessionFactory
				SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
				//创建SqlSession
				SqlSession sqlSession = sqlSessionFactory.openSession();
				
				UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
				
				List<Integer> ids = new ArrayList<>();
				ids.add(16);
				ids.add(22);
				ids.add(24);
				QueryVo vo = new QueryVo();
				vo.setIdsList(ids);
				
				List<User> users = userMapper.selectUserByIds(vo);
		/*
		 * Integer[] ids =new Integer[3]; ids[0] = 16; ids[1] = 22; ids[2] = 24;
		 * List<User> users = userMapper.selectUserByIds(ids);
		 */
				
				for(User user2 : users) {
					System.out.println(user2);
				}
	}
}
