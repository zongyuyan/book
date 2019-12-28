<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("name");
		String author = (String)request.getAttribute("name");
		String price = (String)request.getAttribute("name");
	%>
	添加成功！
	<br />
	添加的数据为：
	<br />
	书名：<%=name %>
	<br />
	作者：<%=author %>
	<br />
	价格：<%=price %>
	<br />
</body>
</html>