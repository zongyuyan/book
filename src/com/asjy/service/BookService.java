package com.asjy.service;

import com.asjy.dao.BookDao;

public class BookService {
	//�����巽�������������ݵĲ���
	public boolean insertBook(String name,String author,String price) {
		//���ͼ������
		//1����дSQl���
		String sql = "insert into book values(default,?,?,?)";
		//2���������ݿ⣬������ݵ���ӡ����ó־ò���룬����������ݿ�Ĳ���
		//�JDBC����
		//��1������jar�����ŵ�webcontent��WEB-INF����
		//(2)����util��
		//��3���½�dao��(�־ò㣬�����������ݿ⣩
		boolean result = BookDao.update(sql, name,author,price);
		return result;
	}
}
