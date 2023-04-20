<%@ page import="com.zb.zerobase_mission1.WifiListDbService" %>
<%@ page import="com.zb.zerobase_mission1.OpenApi" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.time.LocalTime" %>
<%@ page import="com.zb.zerobase_mission1.HistoryService" %>
<%@ page import="com.zb.zerobase_mission1.History" %>
<%@ page import="java.time.LocalDateTime" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="index.js"></script>

</head>
<p>

<h1>와이파이 정보 구하기</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="bookmark-list.jsp">북마크 보기</a> | <a href="bookmark-group.jsp">북마크 그룹 관리</a> </div>
<div style="padding: 2px 0px 10px 0px">
    <form action="index.jsp" method="get">
        LAT : <input class="lat" name="lat" value="<%if(request.getParameter("lat") == null){out.write("0.0");}else{out.write(request.getParameter("lat"));}%>" placeholder="0.0"></input> LNT : <input class="lnt" name="lnt" value="<%if(request.getParameter("lnt") == null){out.write("0.0");}else{out.write(request.getParameter("lnt"));}%>" placeholder="0.0"></input> <button id="getGeo" type="button" onclick = "getPosition()">내 위치 가져오기</button> <input type="submit" value="근처 WIFI 정보 보기">
    </form>
</div>


<table id="wifi-table">
    <tr>
        <th style="text-align:center">거리(Km)</th>
        <th style="text-align:center">관리번호</th>
        <th style="text-align:center">자치구</th>
        <th style="text-align:center">와이파이명</th>
        <th style="text-align:center">도로명주소</th>
        <th style="text-align:center">상세주소</th>
        <th style="text-align:center">설치위치(층)</th>
        <th style="text-align:center">설치유형</th>
        <th style="text-align:center">설치기관</th>
        <th style="text-align:center">서비스구분</th>
        <th style="text-align:center">망종류</th>
        <th style="text-align:center">설치년도</th>
        <th style="text-align:center">실내외구분</th>
        <th style="text-align:center">WIFI접속환경</th>
        <th style="text-align:center">Y좌표</th>
        <th style="text-align:center">X좌표</th>
        <th style="text-align:center">작업일자</th>
    </tr>
<%
    if(request.getParameter("lat") == null && request.getParameter("lnt") == null){
        out.write("<tr>");
        out.write("<td colspan=\"17\" style=\"text-align:center\">위치 정보를 입력한 후에 조회해 주세요.</td>");
    }else{

        WifiListDbService wlds = new WifiListDbService();
        Map<OpenApi, Double> dbWifiList = wlds.dbWifiList(Double.parseDouble(request.getParameter("lat")), Double.parseDouble(request.getParameter("lnt")));

        HistoryService historyService = new HistoryService();

        LocalDateTime dateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

        History history = new History(request.getParameter("lat"), request.getParameter("lnt"), String.valueOf(dateTime.format(formatter)));
        historyService.userHistoryUpdate(history);
        for (Map.Entry<OpenApi, Double> openApi:dbWifiList.entrySet()) {
%>
    <tr>
        <td><%=openApi.getValue().toString()%></td>
        <td><%=openApi.getKey().getX_SWIFI_MGR_NO()%></td>
        <td><%=openApi.getKey().getX_SWIFI_WRDOFC()%></td>
        <td><a href="detail.jsp?wifi_id=<%=openApi.getKey().getWIFI_ID()%>"><%=openApi.getKey().getX_SWIFI_MAIN_NM()%></a></td>
        <td><%=openApi.getKey().getX_SWIFI_ADRES1()%></td>
        <td><%=openApi.getKey().getX_SWIFI_ADRES2()%></td>
        <td><%=openApi.getKey().getX_SWIFI_INSTL_FLOOR()%></td>
        <td><%=openApi.getKey().getX_SWIFI_INSTL_FLOOR()%></td>
        <td><%=openApi.getKey().getX_SWIFI_INSTL_MBY()%></td>
        <td><%=openApi.getKey().getX_SWIFI_SVC_SE()%></td>
        <td><%=openApi.getKey().getX_SWIFI_CMCWR()%></td>
        <td><%=openApi.getKey().getX_SWIFI_CNSTC_YEAR()%></td>
        <td><%=openApi.getKey().getX_SWIFI_INOUT_DOOR()%></td>
        <td><%=openApi.getKey().getX_SWIFI_REMARS3()%></td>
        <td><%=openApi.getKey().getLAT()%></td>
        <td><%=openApi.getKey().getLNT()%></td>
        <td><%=openApi.getKey().getWORK_DTTM()%></td>
    </tr>
<%

        }
    }
%>
</table>

</body>
</html>