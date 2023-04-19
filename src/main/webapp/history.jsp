<%@ page import="com.zb.zerobase_mission1.HistoryService" %>
<%@ page import="com.zb.zerobase_mission1.History" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">
</head>
<p>
<%
HistoryService historyService = new HistoryService();
List<History> userHistroyList = historyService.userHistroyList();
%>
<h1>위치 히스토리 목록</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="bookmark-list.jsp">북마크 보기</a> | <a href="bookmark-group.jsp">북마크 그룹 관리</a> </div>
<table id="wifi-table">
    <tr>
        <th style="text-align:center">X좌표</th>
        <th style="text-align:center">Y좌표</th>
        <th style="text-align:center">조회일자</th>
        <th style="text-align:center">비고</th>
    </tr>
<%
    for (History history:userHistroyList) {
%>
    <tr>
        <td><%=history.getLat()%></td>
        <td><%=history.getLnt()%></td>
        <td><%=history.getLocalTime()%></td>
        <td><form><input type="button" value="삭제" onclick="document.location.href='historydeleteback.jsp?id=<%=history.getId()%>'"></form></td>
    </tr>
<%    }

%>

</table>

</body>
</html>