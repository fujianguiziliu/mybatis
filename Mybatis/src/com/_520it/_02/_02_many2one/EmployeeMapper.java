package com._520it._02._02_many2one;

import java.util.List;

public interface EmployeeMapper {

	void save(Employee e);
	Employee get(Long id);
	List<Employee> list();
}
