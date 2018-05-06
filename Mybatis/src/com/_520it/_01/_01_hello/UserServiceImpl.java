package com._520it._01._01_hello;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements IUserService {

	@Override
	public PageResult pageQuery(QueryObject qo) {
		SqlSession session = MyBatisUtil.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		List<User> listData = mapper.getListData(qo);
		Long totalCount = mapper.getTotalCount(qo);
		return new PageResult(listData, totalCount.intValue(), 
				qo.getCurrentPage(), qo.getPageSize());
	}

	
}
