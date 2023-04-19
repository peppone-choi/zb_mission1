<%@ page import="com.zb.zerobase_mission1.BookmarkService" %><%--
  Created by IntelliJ IDEA.
  User: 최병호
  Date: 2023-04-18
  Time: 오후 9:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");
    int bookmarkGroupId = Integer.parseInt(request.getParameter("bookmark_group_id"));
    int wifiId = Integer.parseInt(request.getParameter("wifi_id"));
    BookmarkService bs = new BookmarkService();
    bs.bookmarkUpdate(wifiId, bookmarkGroupId);
    response.sendRedirect("detail.jsp?wifi_id=" + wifiId);
%>
</body>
</html>
