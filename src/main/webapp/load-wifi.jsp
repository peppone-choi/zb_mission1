<%@ page import="com.zb.zerobase_mission1.Client" %>
<%@ page import="com.zb.zerobase_mission1.ApiService" %>
<%@ page import="com.zb.zerobase_mission1.Responses" %>
<%@ page import="com.zb.zerobase_mission1.OpenApi" %>
<%@ page import="java.util.List" %>
<%@ page import="java.sql.DriverManager" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">
</head>
<p>

        <%

    Class.forName("org.mariadb.jdbc.Driver");

    java.sql.Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/testdb1?allowMultiQueries=true","testuser3","3c2s1q!@#$");

    PreparedStatement stmt1 = conn.prepareStatement("SET FOREIGN_KEY_CHECKS = 0; truncate wifitable; SET FOREIGN_KEY_CHECKS = 1;");

    stmt1.executeUpdate();

    Client testClient = new Client();
    ApiService testApi = new ApiService(testClient);
    Responses testResp = testApi.addPublicWifi(1, 1); // 오류 발생 시 다음의 주소를 참조할 것 : https://data.seoul.go.kr/dataList/OA-20883/S/1/datasetView.do
    int testRespTotalCount = testResp.getTotalCount(); // 총 데이터 건수를 받아오기 위한 API 호출.
    int divine = (testRespTotalCount / 1000); // 1000개씩 API 리스트 호출
        for (int i = 0; i <= divine; i++) {
            Responses testLoopResp = testApi.addPublicWifi((i*1000)+1, (i*1000)+999);
            List<OpenApi> loopOpenApis = testLoopResp.getOpenApis();
            for (int j = 0; j < loopOpenApis.size(); j++) {
                PreparedStatement stmt = conn.prepareStatement(
                 "insert into wifitable(X_SWIFI_MAIN_NM, X_SWIFI_MGR_NO, X_SWIFI_WRDOFC, X_SWIFI_ADRES1, X_SWIFI_ADRES2, X_SWIFI_INSTL_FLOOR, X_SWIFI_INSTL_TY, X_SWIFI_INSTL_MBY, X_SWIFI_SVC_SE, X_SWIFI_CMCWR, X_SWIFI_CNSTC_YEAR, X_SWIFI_INOUT_DOOR, X_SWIFI_REMARS3, LAT, LNT, WORK_DTTM)" +
                  " values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
	            stmt.setString(1, loopOpenApis.get(j).getX_SWIFI_MAIN_NM());
	            stmt.setString(2, loopOpenApis.get(j).getX_SWIFI_MGR_NO());
	            stmt.setString(3, loopOpenApis.get(j).getX_SWIFI_WRDOFC());
	            stmt.setString(4, loopOpenApis.get(j).getX_SWIFI_MAIN_NM());
                stmt.setString(5, loopOpenApis.get(j).getX_SWIFI_ADRES1());
                stmt.setString(6, loopOpenApis.get(j).getX_SWIFI_ADRES2());
                stmt.setString(7, loopOpenApis.get(j).getX_SWIFI_INSTL_FLOOR());
                stmt.setString(8, loopOpenApis.get(j).getX_SWIFI_INSTL_MBY());
                stmt.setString(9, loopOpenApis.get(j).getX_SWIFI_SVC_SE());
                stmt.setString(10, loopOpenApis.get(j).getX_SWIFI_CMCWR());
                stmt.setString(11, loopOpenApis.get(j).getX_SWIFI_CNSTC_YEAR());
                stmt.setString(12, loopOpenApis.get(j).getX_SWIFI_INOUT_DOOR());
                stmt.setString(13, loopOpenApis.get(j).getX_SWIFI_REMARS3());
                stmt.setString(14, loopOpenApis.get(j).getLAT());
                stmt.setString(15, loopOpenApis.get(j).getLNT());
                stmt.setString(16, loopOpenApis.get(j).getWORK_DTTM());
	            // 쿼리 실행
	            stmt.executeUpdate();

        }

    }
        conn.close();
%>

<h1 style="text-align: center"><%=testRespTotalCount%>개의 Wifi 정보를 정상적으로 저장하였습니다.</h1>
<div style="text-align: center">
    <a href="index.jsp">홈으로 가기</a>
</div>
</html>