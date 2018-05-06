package com._520it._01._01_hello;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class QueryObject {

	private Integer currentPage = 1;
	private Integer pageSize = 2;

	public Integer getBeginIndex(){
		return (this.currentPage-1) * this.pageSize;
	}
}
