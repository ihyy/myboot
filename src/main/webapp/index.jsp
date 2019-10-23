<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<body>
<h2>Hello World!</h2>
<h2><a href="test">test</a></h2>
<h2><a href="login.jsp">login</a></h2>
</body>
</html>
