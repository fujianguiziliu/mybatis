package com._520it._02._03_one2many;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Department {
	private Long id;
	private String name;
	private List<Employee> empl = new ArrayList<>();
	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + "]";
	}
	
	
}
