<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>用户成功注册信息</h1>
	<hr>
	<%
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	%>
	编号：<%=id %><br>
	用户名：<%=username %><br>
	密码：<%=password %><br>
	<a href="<%=request.getContextPath() %>login.jsp">请登录</a>
</body>
</html>