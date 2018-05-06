package com._520it._02._03_one2many;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface EmployeeMapper {

	void save(Employee e);
	Employee get(Long id);
	List<Employee> list();
	void updateRelation(@Param("did")Long id,@Param("eid")Long id2);
}
