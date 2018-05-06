package com._520it._01._01_hello;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter@Getter
@ToString
public class UserQueryObject extends QueryObject {

	private String name;
	private BigDecimal minSalary;
	private BigDecimal maxSalary;
	private Long[] ids;
}
