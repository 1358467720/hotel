<%@ page import="org.springframework.jdbc.core.JdbcTemplate" %>
<%@ page import="cn.hotal.utils.JDBCUtils" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: songHat
  Date: 2020/1/2
  Time: 16:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String account = request.getParameter("account");
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSouce());

    String sql = "select * from Huser where account = ?";
    Map<String, Object> map = jdbcTemplate.queryForMap(sql,account);
%>

<P>account:<%=map.get("account")%></P>
<P>password:<%=map.get("password")%></P>
<P>name:<%=map.get("name")%></P>
</body>
</html>
