package com._520it._01._01_hello;

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
	private BigDecimal salary;
	private Date hireDate;
}
