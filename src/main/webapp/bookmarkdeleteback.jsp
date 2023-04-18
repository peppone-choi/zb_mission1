<%@ page import="com.zb.zerobase_mission1.BookmarkService" %><%--
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
    int bookmarkId = Integer.parseInt(request.getParameter("bookmark_id"));
    BookmarkService bs = new BookmarkService();
    bs.bookmarkDelete(bookmarkId);
    response.sendRedirect("bookmark-list.jsp");
%>

</body>
</html>
