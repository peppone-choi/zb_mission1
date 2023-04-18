package com.zb.zerobase_mission1;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookmarkService {
    public void bookmarkUpdate(int WifiId, int BookmarkGroupID){
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

            LocalDateTime dateTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // 쿼리 실행
            sql = "insert into bookmarklist (BOOKMARK_GROUP_ID, WIFI_ID, BOOKMARK_DAY) " +
                    "VALUES (?, ?, ?);";

            prepeaedStatement = connection.prepareStatement(sql);

            prepeaedStatement.setInt(1, BookmarkGroupID);
            prepeaedStatement.setInt(2, WifiId);
            prepeaedStatement.setString(3, String.valueOf(dateTime.format(formatter)));

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

    public List<Bookmark> bookmarkList(){
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)

        List<Bookmark> bookmarkList = new ArrayList<>();

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
            sql = "SELECT * FROM bookmarklist cross join wifitable w on bookmarklist.WIFI_ID = w.WIFI_ID cross join bookmarkgroup b on b.BOOKMARK_GROUP_ID = bookmarklist.BOOKMARK_GROUP_ID;\n";

            prepeaedStatement = connection.prepareStatement(sql);

            rs = prepeaedStatement.executeQuery();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행

            while (rs.next()){
                int BOOKMARK_ID = rs.getInt("BOOKMARK_ID");
                String BOOKMARK_NAME = rs.getString("BOOKMARK_NAME");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String BOOKMARK_DAY = rs.getString("BOOKMARK_DAY");



                Bookmark bookmark = new Bookmark(BOOKMARK_ID, BOOKMARK_NAME, X_SWIFI_MAIN_NM, BOOKMARK_DAY);

                bookmarkList.add(bookmark);

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
        return bookmarkList;
    }

    public Bookmark bookmarkDetail(int no){
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)SELECT *
        //FROM bookmarklist
        //JOIN wifitable w ON bookmarklist.WIFI_ID = w.WIFI_ID
        //JOIN bookmarkgroup b ON b.BOOKMARK_GROUP_ID = bookmarklist.BOOKMARK_GROUP_ID
        //WHERE BOOKMARK_ID = 3;
        

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
        Bookmark bookmark = null;
        // 커넥션 객체 생성

        try {
            connection = DriverManager.getConnection(url, dbUserID, dbPassword);

            // 스테이트먼트 객체 실행


            // 쿼리 실행
            sql = "SELECT *\n" +
                    "FROM bookmarklist\n" +
                    "JOIN wifitable w ON bookmarklist.WIFI_ID = w.WIFI_ID\n" +
                    "JOIN bookmarkgroup b ON b.BOOKMARK_GROUP_ID = bookmarklist.BOOKMARK_GROUP_ID\n" +
                    "WHERE BOOKMARK_ID = ?";

            prepeaedStatement = connection.prepareStatement(sql);

            prepeaedStatement.setInt(1, no);
            
            rs = prepeaedStatement.executeQuery();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행

            while (rs.next()){
                int BOOKMARK_ID = rs.getInt("BOOKMARK_ID");
                String BOOKMARK_NAME = rs.getString("BOOKMARK_NAME");
                String X_SWIFI_MAIN_NM = rs.getString("X_SWIFI_MAIN_NM");
                String BOOKMARK_DAY = rs.getString("BOOKMARK_DAY");



                
                bookmark = new Bookmark(BOOKMARK_ID, BOOKMARK_NAME, X_SWIFI_MAIN_NM, BOOKMARK_DAY);

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
        return bookmark;
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
        String userIdValue = "zerobase.naver.com";
        String passwordValue = "9999";


        // 커넥션 객체 생성

        try {
            connection = DriverManager.getConnection(url, dbUserID, dbPassword);

            // 스테이트먼트 객체 실행


            // 쿼리 실행
            sql = "delete from bookmarklist where BOOKMARK_ID = ?";

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
