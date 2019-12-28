package com.asjy.service;

import com.asjy.dao.BookDao;

public class BookService {
	//负责定义方法，完成添加数据的操作
	public boolean insertBook(String name,String author,String price) {
		//完成图书的添加
		//1、编写SQl语句
		String sql = "insert into book values(default,?,?,?)";
		//2、连接数据库，完成数据的添加。调用持久层代码，完成连接数据库的操作
		//搭建JDBC环境
		//（1）导入jar包，放到webcontent的WEB-INF里面
		//(2)建立util包
		//（3）新建dao包(持久层，负责连接数据库）
		boolean result = BookDao.update(sql, name,author,price);
		return result;
	}
}
