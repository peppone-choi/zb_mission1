<%@ page import="com.zb.zerobase_mission1.WifiInfoDbService" %>
<%@ page import="com.zb.zerobase_mission1.OpenApi" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.zb.zerobase_mission1.BookmarkGroupService" %>
<%@ page import="com.zb.zerobase_mission1.BookmarkGroup" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">

</head>
<p>

<h1>북마크 그룹 수정</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="bookmark-list.jsp">북마크 보기</a> | <a href="#">북마크 그룹 관리</a> </div>
<div style="padding: 2px 0px 10px 0px">


</div>
<table id="wifi-table">
<%
    BookmarkGroupService bgs = new BookmarkGroupService();
    int id = Integer.parseInt(request.getParameter("id"));
    BookmarkGroup bg = bgs.bookmarkGroupSelect(id);
%>
    <form action="bookmarkgroupupdateback.jsp" method="post">
    <tr><th>북마크 이름</th><td><input type="text" name="name" value="<%=bg.getBookmarkGroupName()%>"></td></tr>
    <tr><th>순서</th><td><input type="text" name="order" value="<%=bg.getOrder()%>"><input hidden="hidden" name="no" value="<%=bg.getBookmarkGroupId()%>"></td></tr>
        <tr><td colspan="2" style="text-align: center"><a href="bookmark-group.jsp">돌아가기</a> | <input type="submit" value="수정"></td></tr>
    </form>
</table>

</body>
</html>