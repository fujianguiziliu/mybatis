package com._520it._01._01_hello;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageResult {

	private List<?> listData;
	private Integer totalCount;
	private Integer currentPage;
	private Integer pageSize;
	private Integer totalPage;
	private Integer prePage;
	private Integer nextPage;
	//定义一个空的分页对象，在查询的共条数为0的时候使用
	public static PageResult emptyResult = new PageResult(new ArrayList<>(), 0,1,3);
	public PageResult(List<?> listDate, Integer totalCount,
			Integer currentPage, Integer pageSize) {
		super();
		this.listData = listDate;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		//计算得来的数据
		totalPage = totalCount % pageSize == 0 ? totalCount / pageSize : totalCount /pageSize+1;
		prePage = currentPage - 1 >= 1 ? currentPage -1 : 1 ;
		nextPage = currentPage + 1 <= totalPage ? currentPage +1 : totalPage;
	}
	
}
