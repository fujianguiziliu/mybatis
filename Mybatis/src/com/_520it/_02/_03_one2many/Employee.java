package com._520it._02._03_one2many;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Employee {
	private Long id;
	private String name;
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	
	
	
}
