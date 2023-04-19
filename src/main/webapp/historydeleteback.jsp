<%@ page import="com.zb.zerobase_mission1.BookmarkService" %>
<%@ page import="com.zb.zerobase_mission1.BookmarkGroupService" %>
<%@ page import="com.zb.zerobase_mission1.HistoryService" %><%--
  Created by IntelliJ IDEA.
  User: 최병호
  Date: 2023-04-18
  Time: 오후 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    int historyId = Integer.parseInt(request.getParameter("id"));
    HistoryService hs = new HistoryService();
    hs.bookmarkDelete(historyId);
    response.sendRedirect("history.jsp");
%>

</body>
</html>
