<%@ page import="java.util.List" %>
<%@ page import="com.zb.zerobase_mission1.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">
</head>
<p>
<%
        BookmarkGroupService bgs = new BookmarkGroupService();
        List<BookmarkGroup> bgl = bgs.bookmarkGroupListSelect();
%>
<h1>북마크 그룹</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="bookmark-list.jsp">북마크 보기</a> | <a href="bookmark-group.jsp">북마크 그룹 관리</a> </div>
<form><button type="button" onclick="location.href = 'bookmark-group-add.jsp'">북마크 그룹 이름 추가</button></form>
<table id="wifi-table">
    <tr>
        <th style="text-align:center">ID</th>
        <th style="text-align:center">북마크 이름</th>
        <th style="text-align:center">순서</th>
        <th style="text-align:center">등록일자</th>
        <th style="text-align:center">수정일자</th>
        <th style="text-align:center">비고</th>
    </tr>
<%
    for (BookmarkGroup bg:bgl) {
%>
    <tr>
        <td><%=bg.getBookmarkGroupId()%></td>
        <td><%=bg.getBookmarkGroupName()%></td>
        <td><%=bg.getOrder()%></td>
        <td><%=bg.getBookmarkGroupMakeDay()%></td>
        <td><%=bg.getBookmarkGroupCorrectionDay()%></td>
        <td><a href="bookmark-group-edit.jsp?id=<%=bg.getBookmarkGroupId()%>">수정</a> <a href="bookmarkgroupdeleteback.jsp?id=<%=bg.getBookmarkGroupId()%>">삭제</a></td>
    </tr>
<%
    }
%>

</table>

</body>
</html>