<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
      String token = UUID.randomUUID().toString();
             token = token.replace("-","");
             session.setAttribute("token",token);
%>
<input type="hidden" name="token" value="<%=token%>"/>