<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: Arkxd
  Date: 2023/4/13
  Time: 10:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
    <form name="reg" action="LoginServlet" method="post">
        用户名: <input name="username" type="text"/><br/>
        密码：  <input name="password" type="password"/><br/>
        <input type="submit" value="提交" id="bt"/>
    </form>
    <%
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String today = dateFormat.format(date);
    %>
    当前时间：<%=today%>
</body>
</html>
