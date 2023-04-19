<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %>
<%@ page import="com.zb.zerobase_mission1.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">

</head>
<p>

<h1>와이파이 정보 구하기</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="bookmark-list.jsp">북마크 보기</a> | <a href="bookmark-group.jsp">북마크 그룹 관리</a> </div>
<div style="padding: 2px 0px 10px 0px">
    <form action="bookmark-add.jsp">
        <select name="bookmark_group_id">
            <option value="">북마크 그룹 이름 선택</option>
<%
    BookmarkGroupService bgs = new BookmarkGroupService();
    List<BookmarkGroup> bgl = bgs.bookmarkGroupListSelect();
    for (BookmarkGroup bg:bgl) {

    out.write("<option value=\"" + bg.getBookmarkGroupId() + "\">" + bg.getBookmarkGroupName() + "</option>");
    }
%>
        </select>
        <button type="submit" id="addBookmark" onclick = "location.href = 'bookmark-list.jsp'">북마크 추가하기</button>

</div>
<table id="wifi-table">
<%
    WifiInfoDbService wids = new WifiInfoDbService();
    Map<OpenApi, Double> openApiInfo = wids.dbWifiList(Integer.parseInt(request.getParameter("wifi_id")));
    for (Map.Entry<OpenApi, Double> openApi:openApiInfo.entrySet()) {
%>
    <input type="hidden" name="wifi_id" value="<%=Integer.parseInt(request.getParameter("wifi_id"))%>">
    <tr><th>거리</th><td><%=openApi.getValue().toString()%></td></tr>
    <tr><th>관리번호</th><td><%=openApi.getKey().getX_SWIFI_MGR_NO()%></td></tr>
    <tr><th>자치구</th><td><%=openApi.getKey().getX_SWIFI_WRDOFC()%></td></tr>
    <tr><th>와이파이명</th><td><a href="detail.jsp?wifi_id=<%=Integer.parseInt(request.getParameter("wifi_id"))%>"><%=openApi.getKey().getX_SWIFI_MAIN_NM()%></a></td></tr>
    <tr><th>도로명주소</th><td><%=openApi.getKey().getX_SWIFI_ADRES1()%></td></tr>
    <tr><th>상세주소</th><td><%=openApi.getKey().getX_SWIFI_ADRES2()%></td></tr>
    <tr><th>설치위치(층)</th><td><%=openApi.getKey().getX_SWIFI_INSTL_FLOOR()%></td></tr>
    <tr><th>설치유형</th><td><%=openApi.getKey().getX_SWIFI_INSTL_FLOOR()%></td></tr>
    <tr><th>설치기관</th><td><%=openApi.getKey().getX_SWIFI_INSTL_MBY()%></td></tr>
    <tr><th>서비스구분</th><td><%=openApi.getKey().getX_SWIFI_SVC_SE()%></td></tr>
    <tr><th>망종류</th><td><%=openApi.getKey().getX_SWIFI_CMCWR()%></td></tr>
    <tr><th>설치년도</th><td><%=openApi.getKey().getX_SWIFI_CNSTC_YEAR()%></td></tr>
    <tr><th>실내외구분</th><td><%=openApi.getKey().getX_SWIFI_INOUT_DOOR()%></td></tr>
    <tr><th>WIFI접속환경</th><td><%=openApi.getKey().getX_SWIFI_REMARS3()%></td></tr>
    <tr><th>X좌표</th><td><%=openApi.getKey().getLAT()%></td></tr>
    <tr><th>Y좌표</th><td><%=openApi.getKey().getLNT()%></td></tr>
    <tr><th>작업일자</th><td><%=openApi.getKey().getWORK_DTTM()%></td></tr>
<%
    }
%>
    </form>
</table>

</body>
</html>