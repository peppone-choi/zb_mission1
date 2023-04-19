package com.zb.zerobase_mission1;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class HistoryService {
    public void userHistoryUpdate(History history){
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserID = "testuser3";
        String dbPassword = "3c2s1q!@#$";

        // 드라이버 로드

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
            sql = "insert into history (NOW_LNT, NOW_LAT, SEARCH_DAY) " +
                    "VALUES (?, ?, ?);";

            prepeaedStatement = connection.prepareStatement(sql);




            prepeaedStatement.setString(1, history.getLnt());
            prepeaedStatement.setString(2, history.getLat());
            prepeaedStatement.setString(3, history.getLocalTime());

            int affected = prepeaedStatement.executeUpdate();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행
            if (affected > 0){
                System.out.println("저장 성공");
            }else {
                System.out.println("저장 실패");
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
    }

    public List<History> userHistroyList(){
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)

        List<History> historyList = new ArrayList<>();

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserID = "testuser3";
        String dbPassword = "3c2s1q!@#$";

        // 드라이버 로드

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
            sql = "select * from history order by SEARCH_DAY desc limit 20";

            prepeaedStatement = connection.prepareStatement(sql);

            rs = prepeaedStatement.executeQuery();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행

            while (rs.next()){
                String HISTORY_ID = rs.getString("HISTORY_ID");
                String NOW_LNT = rs.getString("NOW_LNT");
                String NOW_LAT = rs.getString("NOW_LAT");
                String SEARCH_DAY = rs.getString("SEARCH_DAY");



                History history = new History(HISTORY_ID, NOW_LNT, NOW_LAT, SEARCH_DAY);

                historyList.add(history);

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
        return historyList;
    }

    public void bookmarkDelete(int no){
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserID = "testuser3";
        String dbPassword = "3c2s1q!@#$";

        // 드라이버 로드

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
            sql = "delete from history where HISTORY_ID = ?";

            prepeaedStatement = connection.prepareStatement(sql);

            prepeaedStatement.setInt(1, no);



            int affected = prepeaedStatement.executeUpdate();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행
            if (affected > 0){
                System.out.println("삭제 성공");
            }else {
                System.out.println("삭제 실패");
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
    }
}
