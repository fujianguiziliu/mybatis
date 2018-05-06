package com._520it._02._03_one2many;



import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com._520it._01._01_hello.MyBatisUtil;



public class One2ManyTest {
	
	@Test
	public void testSave() throws Exception {
		Employee e1 = new Employee();
		e1.setName("e1");
		Employee e2 = new Employee();
		e2.setName("e2");
		Department dept = new Department();
		dept.setName("市场部");
		
		dept.getEmpl().add(e1);
		dept.getEmpl().add(e2);
		
		SqlSession session = MyBatisUtil.openSession();
		EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
		DepartmentMapper dMapper = session.getMapper(DepartmentMapper.class);
	
	
		eMapper.save(e1);
		eMapper.save(e2);
		dMapper.save(dept);
		
	
		for (Employee e : dept.getEmpl()) {
			eMapper.updateRelation(dept.getId(), e.getId());
		}
		session.commit();
		session.close();
	}
	@Test
	public void testGet() throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		DepartmentMapper dMapper = session.getMapper(DepartmentMapper.class);
		Department dept = dMapper.get(9L);
		System.out.println(dept);
		System.out.println(dept.getEmpl());
	}
	@Test
	public void testList() throws Exception {
		
		
	}
	
}
