package com._520it._02._01_param;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
public class User {

	private Long id;
	private String name;
	private String password; 
	private BigDecimal salary;
	private Date hireDate;
}
