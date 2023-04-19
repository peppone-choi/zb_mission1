<%@ page import="com.zb.zerobase_mission1.HistoryService" %>
<%@ page import="com.zb.zerobase_mission1.History" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zb.zerobase_mission1.BookmarkService" %>
<%@ page import="com.zb.zerobase_mission1.Bookmark" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">
</head>
<p>
<%
        BookmarkService bs = new BookmarkService();
        List<Bookmark> bml = bs.bookmarkList();
%>
<h1>북마크 목록</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="bookmark-list.jsp">북마크 보기</a> | <a href="bookmark-group.jsp">북마크 그룹 관리</a> </div>
<table id="wifi-table">
    <tr>
        <th style="text-align:center">ID</th>
        <th style="text-align:center">북마크 이름</th>
        <th style="text-align:center">와이파이명</th>
        <th style="text-align:center">등록일자</th>
        <th style="text-align:center">비고</th>
    </tr>
<%
    for (Bookmark bookmark:bml) {
%>
    <tr>
        <td><%=bookmark.getBookmarkId()%></td>
        <td><%=bookmark.getBookmarkGroupName()%></td>
        <td><%=bookmark.getBookmarkWifiName()%></td>
        <td><%=bookmark.getBookmarkDay()%></td>
        <td><a href="bookmark-delete.jsp?bookmark_id=<%=bookmark.getBookmarkId()%>">삭제</a></td>
    </tr>
<%
    }
%>

</table>

</body>
</html>