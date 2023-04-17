package com.zb.zerobase_mission1;

import java.sql.*;
import java.util.*;

public class WifiInfoDbService {

    public Map<OpenApi, Double> dbWifiList(int no){
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserID = "testuser3";
        String dbPassword = "3c2s1q!@#$";
        OpenApi openApi = new OpenApi();
        // 드라이버 로드
        Map<OpenApi, Double> wifiInfo = new LinkedHashMap<>();
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        Connection connection = null;
        PreparedStatement prepeaedStatement = null;
        String sql = "";
        ResultSet rs = null;

        // 커넥션 객체 생성

        try {
            connection = DriverManager.getConnection(url, dbUserID, dbPassword);

            // 스테이트먼트 객체 실행


            // 쿼리 실행
            sql = "SELECT *," +
                    "(1000*6371*ACOS(COS(RADIANS('37.4831154'))" +
                    "    *COS(RADIANS(LAT))" +
                    "        *COS(radians(LNT)-RADIANS('126.798553'))" +
                    "        +SIN(RADIANS('37.4831154'))*SIN(RADIANS(LAT))))" +
                    "\tAS DISTANCE\n" +
                    "\n" +
                    "FROM wifitable where WIFI_ID = ?";

            prepeaedStatement = connection.prepareStatement(sql);

            prepeaedStatement.setInt(1, no);

            rs = prepeaedStatement.executeQuery();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;



            // 결과 수행

            while (rs.next()){
                String X_SWIFI_MGR_NO = rs.getString("X_SWIFI_MGR_NO");
                String X_SWIFI_WRDOFC = rs.getString("X_SWIFI_WRDOFC");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String X_SWIFI_ADRES1 = rs.getString("X_SWIFI_ADRES1");
                String X_SWIFI_ADRES2 = rs.getString("X_SWIFI_ADRES2");
                String X_SWIFI_INSTL_FLOOR = rs.getString("X_SWIFI_INSTL_FLOOR");
                String X_SWIFI_INSTL_TY = rs.getString("X_SWIFI_INSTL_TY");
                String X_SWIFI_INSTL_MBY = rs.getString("X_SWIFI_INSTL_MBY");
                String X_SWIFI_SVC_SE = rs.getString("X_SWIFI_SVC_SE");
                String X_SWIFI_CMCWR = rs.getString("X_SWIFI_CMCWR");
                String X_SWIFI_CNSTC_YEAR = rs.getString("X_SWIFI_CNSTC_YEAR");
                String X_SWIFI_INOUT_DOOR = rs.getString("X_SWIFI_INOUT_DOOR");
                String X_SWIFI_REMARS3 = rs.getString("X_SWIFI_REMARS3");
                String LAT = rs.getString("LAT");
                String LNT = rs.getString("LNT");
                String WORK_DTTM = rs.getString("WORK_DTTM");
                double distance = rs.getDouble("distance");


                openApi.setX_SWIFI_MGR_NO(X_SWIFI_MGR_NO);
                openApi.setX_SWIFI_WRDOFC(X_SWIFI_WRDOFC);
                openApi.setX_SWIFI_MAIN_NM(X_SWIFI_MAIN_NM);
                openApi.setX_SWIFI_ADRES1(X_SWIFI_ADRES1);
                openApi.setX_SWIFI_ADRES2(X_SWIFI_ADRES2);
                openApi.setX_SWIFI_INSTL_FLOOR(X_SWIFI_INSTL_FLOOR);
                openApi.setX_SWIFI_INSTL_TY(X_SWIFI_INSTL_TY);
                openApi.setX_SWIFI_INSTL_MBY(X_SWIFI_INSTL_MBY);
                openApi.setX_SWIFI_SVC_SE(X_SWIFI_SVC_SE);
                openApi.setX_SWIFI_CMCWR(X_SWIFI_CMCWR);
                openApi.setX_SWIFI_CNSTC_YEAR(X_SWIFI_CNSTC_YEAR);
                openApi.setX_SWIFI_INOUT_DOOR(X_SWIFI_INOUT_DOOR);
                openApi.setX_SWIFI_REMARS3(X_SWIFI_REMARS3);
                openApi.setLAT(LAT);
                openApi.setLNT(LNT);
                openApi.setWORK_DTTM(WORK_DTTM);
                wifiInfo.put(openApi, (Math.round(distance* 1000) / 1000.0));
            }

            // 객체 연결 해제


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if(rs != null && !rs.isClosed()){
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(!prepeaedStatement.isClosed()){
                    prepeaedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if(!connection.isClosed()){
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return wifiInfo;
    }

}