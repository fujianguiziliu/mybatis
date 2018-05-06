package com._520it._02._01_param;


import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com._520it._01._01_hello.UserQueryObject;

public interface UserMapper {

	User checkLogin(Map<String, Object> map);

	
	User checkLogin(@Param("name")String name,
			@Param("password")String password);

//	User checkLoginto(@Param("qo")UserQueryObject qo,
//			@Param("password")String password);
}
