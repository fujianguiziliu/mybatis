package com._520it._01._01_hello;

import java.math.BigDecimal;
import java.util.Date;

import java.util.List;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class UserMapperTest {
	@Test
	public void testSave() throws Exception {
		User u = new User();
		u.setName("paul");
		u.setHireDate(new Date());
		u.setSalary(new BigDecimal(10000));
		
		// 第一种：加载db.properties
//		Properties p = new Properties();
//		p.load(Resources.getResourceAsStream("db.properties"));
//		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(Resources
//				.getResourceAsStream("mybatis-config.xml"),p);
		//创建SqlSession的工厂对象--datasource
		SqlSessionFactory fac = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis-config.xml"));
		//创建SqlSession对象--connection
		SqlSession session = fac.openSession();
		/*//创建SqlSession对象--connection
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		SqlSession session = factory.openSession();
		session.insert("com._520it._01_hello.UserMapper.save", u);
		*/
		session.insert("com._520it._01_hello.UserMapper.save", u);
		
		session.commit();
		session.close();
		System.out.println(u);
	
	}
	@Test
	public void testSaveMapper() throws Exception {
		User u = new User();
		u.setName("paul");
		u.setHireDate(new Date());
		u.setSalary(new BigDecimal(10000));
		
		SqlSession session = MyBatisUtil.openSession();
		//session.insert("com._520it._01_hello.UserMapper.save", u);
		
		//获取到mapper对象
		UserMapper mapper = session.getMapper(UserMapper.class);
		mapper.save(u);
		session.commit();
		session.close();
		System.err.println(u);
	
	}
	@Test
	public void testUpdate() throws Exception {
		User u = new User();
		u.setId(1L);
		u.setName("paul");
		u.setHireDate(new Date());
		u.setSalary(new BigDecimal(10000));
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		SqlSession session = factory.openSession();
		session.update("com._520it._01_hello.UserMapper.update", u);
		session.commit();
		session.close();
			
		
	}
	
	@Test
	public void testDelete() throws Exception {

		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		SqlSession session = factory.openSession();
		session.update("com._520it._01_hello.UserMapper.delete", 2L);
		session.commit();
		
		session.close();
	}
	@Test
	public void testGet() throws Exception {
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		SqlSession session = factory.openSession();
		User u = session.selectOne("com._520it._01_hello.UserMapper.get",3L);
		System.out.println(u);
		session.commit();
		session.close();
		
		
	}
	@Test
	public void testlist() throws Exception {
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
		SqlSession session = factory.openSession();
		 List<User> us = session.selectList("com._520it._01_hello.UserMapper.list");
		 //User us = session.selectOne("com._520it._01_hello.UserMapper.list");不管几条数据，都是查询到一条
		for (User user : us) {
			System.out.println(user);
		}
		session.commit();
		session.close();
		
		
	}
	
	
	
}
