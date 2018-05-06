package com._520it._01._01_hello;

import org.junit.Test;

public class UserServiceTest {

	private IUserService service = new UserServiceImpl();
	@Test
	public void testPageQuery() throws Exception {
		UserQueryObject qo = new  UserQueryObject();
		qo.setName("W");
		PageResult pageQuery = service.pageQuery(qo);
		System.out.println(pageQuery);
	}
}
