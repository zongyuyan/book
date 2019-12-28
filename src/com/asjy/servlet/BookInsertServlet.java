package com.asjy.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.asjy.service.BookService;

/**
 * Servlet implementation class BookInsertServlet
 */
@WebServlet("/BookInsertServlet")
public class BookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//1、取值
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
        //2、调用业务层方法完成添加数据的操作
		BookService b1 = new BookService();
		boolean result = b1.insertBook(name, author, price);
		if(result==true) {
			//添加成功.跳转到添加成功画面
			request.setAttribute("name", name);
			request.setAttribute("author", author);
			request.setAttribute("price", price);
			request.getRequestDispatcher("book_insertok.jsp").forward(request,response);
		}else {
			//添加失败。重新跳转回添加画面
			request.getRequestDispatcher("book_insert.jsp").forward(request,response);
		}
	}

}
