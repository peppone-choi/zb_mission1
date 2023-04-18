<%@ page import="com.zb.zerobase_mission1.WifiInfoDbService" %>
<%@ page import="com.zb.zerobase_mission1.OpenApi" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Set" %>
<%@ page import="com.zb.zerobase_mission1.BookmarkService" %>
<%@ page import="com.zb.zerobase_mission1.Bookmark" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">

</head>
<p>

<h1>북마크 삭제</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="bookmark-list.jsp">북마크 보기</a> | <a href="#">북마크 그룹 관리</a> </div>
<div style="padding: 2px 0px 10px 0px">


</div>
<table id="wifi-table">
<%
    BookmarkService bs = new BookmarkService();
    Bookmark bookmark = bs.bookmarkDetail(Integer.parseInt(request.getParameter("bookmark_id")));
%>
    <tr><th>북마크 이름</th><td><%=bookmark.getBookmarkGroupName()%></td></tr>
    <tr><th>와이파이명</th><td><%=bookmark.getBookmarkWifiName()%></td></tr>
    <tr><th>등록일자</th><td><%=bookmark.getBookmarkDay()%></td></tr>
    <tr><td colspan="2" style="text-align: center"><form><a href="bookmark-list.jsp">돌아가기</a> | <button type="button" onclick="location.href='bookmarkdeleteback.jsp?bookmark_id=<%=bookmark.getBookmarkId()%>'">삭제</button></form></td></tr>

</table>

</body>
</html>