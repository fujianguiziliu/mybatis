package com._520it._02._02_many2one;



import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com._520it._01._01_hello.MyBatisUtil;



public class Many2OneTest {
	
	@Test
	public void testSave() throws Exception {
		Department dept = new Department();
		dept.setName("研发部");
		Employee e = new Employee();
		e.setName("pao");
		//设置关联关系
		e.setDept(dept);
		
		
		//保存操作：只能先保存部门，再保存员工
		SqlSession session = MyBatisUtil.openSession();
		DepartmentMapper dMapper = session.getMapper(DepartmentMapper.class);
		EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
		
		
		dMapper.save(dept);
		eMapper.save(e);
		
		session.commit();
		session.close();
		
		
	}
	@Test
	public void testGet() throws Exception {
		SqlSession session = MyBatisUtil.openSession();
		EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
		Employee e = eMapper.get(1L);
		//Department dept = e.getDept();
	//	session.clearCache();// 清理一级缓存中的数据
//		System.out.println(dept);
		//System.out.println(e.getDept().getId());
		//System.out.println(e.getDept());
		System.out.println(e.toString());
		session.close();
		
		
	}
	@Test
	public void testList() throws Exception {
		
		SqlSession session = MyBatisUtil.openSession();
		EmployeeMapper eMapper = session.getMapper(EmployeeMapper.class);
		List<Employee> list = eMapper.list();
		for (Employee e : list) {
			System.out.println(e.getName() + "  " + e.getDept().getName());
		}
		
		session.close();
	}
	
}
