package com.zb.zerobase_mission1;

import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BookmarkGroupService {

    public BookmarkGroup bookmarkGroupSelect(int no) {
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)

        BookmarkGroup bg = null;

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
        String memberTypeValue = "kakao";
        // 커넥션 객체 생성

        try {
            connection = DriverManager.getConnection(url, dbUserID, dbPassword);

            // 스테이트먼트 객체 실행


            // 쿼리 실행
            sql = "select * from bookmarkgroup where BOOKMARK_GROUP_ID = ? ";

            prepeaedStatement = connection.prepareStatement(sql);


            prepeaedStatement.setInt(1, no);

            rs = prepeaedStatement.executeQuery();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행

            while (rs.next()) {
                int BOOKMARK_GROUP_ID = rs.getInt("BOOKMARK_GROUP_ID");
                String BOOKMARK_NAME = rs.getString("BOOKMARK_NAME");
                int ORDER = rs.getInt("ORDER");
                String BOOKMARK_MAKE_DAY = rs.getString("BOOKMARK_MAKE_DAY");
                String BOOKMARK_CORRECTION_DAY = rs.getString("BOOKMARK_CORRECTION_DAY");

                bg = new BookmarkGroup(BOOKMARK_GROUP_ID, BOOKMARK_NAME, ORDER, BOOKMARK_MAKE_DAY, BOOKMARK_CORRECTION_DAY);

            }

            // 객체 연결 해제


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (!prepeaedStatement.isClosed()) {
                    prepeaedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return bg;
    }

    public List<BookmarkGroup> bookmarkGroupListSelect() {
        // DB 접속 (IP, Port, 계정, Passwort, 인스턴스)

        String url = "jdbc:mariadb://localhost:3306/testdb1";
        String dbUserID = "testuser3";
        String dbPassword = "3c2s1q!@#$";

        List<BookmarkGroup> bookmarkGroupList = new ArrayList<>();

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
            sql = "select * from bookmarkgroup order by BOOKMARK_GROUP_ID;";

            prepeaedStatement = connection.prepareStatement(sql);


            rs = prepeaedStatement.executeQuery();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행

            while (rs.next()) {
                int BOOKMARK_GROUP_ID = rs.getInt("BOOKMARK_GROUP_ID");
                String BOOKMARK_NAME = rs.getString("BOOKMARK_NAME");
                int ORDER = rs.getInt("ORDER");
                String BOOKMARK_MAKE_DAY = rs.getString("BOOKMARK_MAKE_DAY");
                String BOOKMARK_CORRECTION_DAY = rs.getString("BOOKMARK_CORRECTION_DAY");

                BookmarkGroup bg = new BookmarkGroup(BOOKMARK_GROUP_ID, BOOKMARK_NAME, ORDER, BOOKMARK_MAKE_DAY, BOOKMARK_CORRECTION_DAY);
                bookmarkGroupList.add(bg);
            }

            // 객체 연결 해제


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (!prepeaedStatement.isClosed()) {
                    prepeaedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return bookmarkGroupList;
    }

    public void bookmarkGroupInsert(String name, int order) {
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


        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String formattedDateTime = now.format(formatter);

        Connection connection = null;
        PreparedStatement prepeaedStatement = null;
        String sql = "";
        ResultSet rs = null;


        // 커넥션 객체 생성

        try {
            connection = DriverManager.getConnection(url, dbUserID, dbPassword);

            // 스테이트먼트 객체 실행


            // 쿼리 실행
            sql = "insert into bookmarkgroup (BOOKMARK_NAME, `ORDER`, BOOKMARK_MAKE_DAY) VALUE (?, ?, ?);";

            prepeaedStatement = connection.prepareStatement(sql);


            prepeaedStatement.setString(1, name);
            prepeaedStatement.setInt(2, order);
            prepeaedStatement.setString(3, formattedDateTime);


            int affected = prepeaedStatement.executeUpdate();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행
            if (affected > 0) {
                System.out.println("저장 성공");
            } else {
                System.out.println("저장 실패");
            }

            // 객체 연결 해제


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (rs != null && !rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (!prepeaedStatement.isClosed()) {
                    prepeaedStatement.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                if (!connection.isClosed()) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public void bookmarkGroupUpdate(int no, String name, int order){
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

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        String formattedDateTime = now.format(formatter);


        Connection connection = null;
        PreparedStatement prepeaedStatement = null;
        String sql = "";
        ResultSet rs = null;

        // 커넥션 객체 생성

        try {
            connection = DriverManager.getConnection(url, dbUserID, dbPassword);

            // 스테이트먼트 객체 실행


            // 쿼리 실행
            sql = "UPDATE bookmarkgroup SET BOOKMARK_NAME = ?, `ORDER` = ? ,BOOKMARK_CORRECTION_DAY = ? WHERE BOOKMARK_GROUP_ID = ?;";

            prepeaedStatement = connection.prepareStatement(sql);




            prepeaedStatement.setString(1, name);
            prepeaedStatement.setInt(2, order);
            prepeaedStatement.setString(3, formattedDateTime);
            prepeaedStatement.setInt(4, no);

            int affected = prepeaedStatement.executeUpdate();

//            PreparedStatement preparedStatement = null; 주로 이거 사용
//            CallableStatement callableStatement = null;

            // 결과 수행
            if (affected > 0){
                System.out.println("수정 성공");
            }else {
                System.out.println("수정 실패");
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

    public void bookmarkGroupDelete(int no){
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
            sql = "delete from bookmarkgroup where BOOKMARK_Group_ID = ?;";

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