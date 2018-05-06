package com._520it._02._01_param;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com._520it._01._01_hello.MyBatisUtil;


public class UserMapperTest {
	
	@Test
	public void testCheckLogin() throws Exception {
		
		SqlSession session = MyBatisUtil.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		Map<String, Object> map =new HashMap<String,Object>();
		
		map.put("name", "pao");
		map.put("password", "1234");
		User u = mapper.checkLogin(map);
		System.out.println(u);
		session.close();
		
		
	}
	
	@Test
	public void testCheckLoginByParam() throws Exception {
		
		SqlSession session = MyBatisUtil.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		
		
		User u = mapper.checkLogin("pao","1234");
		System.out.println(u);
		session.close();
		
		
	}
	
	
	
}
