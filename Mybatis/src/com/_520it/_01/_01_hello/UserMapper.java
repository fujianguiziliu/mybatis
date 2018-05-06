package com._520it._01._01_hello;

import java.util.List;

public interface UserMapper {

	//定义CRUD方法
	void save(User u);
	
	void dalete(Long id);
	
	void update(User u);
	
	User get(Long id);
	
	List<User> list();
	
	//获取结果集数据
	List<User> getListData(QueryObject qo);
	
	//获取总条数
	Long getTotalCount(QueryObject qo);

	
}
