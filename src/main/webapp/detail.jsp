<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html charset="utf-8">
<head>
    <link rel="stylesheet" href="mission1.css">

</head>
<p>

<h1>와이파이 정보 구하기</h1>
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="#">북마크 보기</a> | <a href="#">북마크 그룹 관리</a> </div>
<div style="padding: 2px 0px 10px 0px">


    <form>
        <select>
            <option value="">북마크 그룹 이름 선택</option>
        </select>
        <button id="addBookmark" onclick = "location.href = '#'">북마크 추가하기</button>
    </form>
</div>
<table id="wifi-table">

    <tr><th>거리</th><td>-</td></tr>
    <tr><th>관리번호</th><td>-</td></tr>
    <tr><th>자치구</th><td>-</td></tr>
    <tr><th>와이파이명</th><td>-</td></tr>
    <tr><th>도로명주소</th><td>-</td></tr>
    <tr><th>상세주소</th><td>-</td></tr>
    <tr><th>설치위치(층)</th><td>-</td></tr>
    <tr><th>설치유형</th><td>-</td></tr>
    <tr><th>설치기관</th><td>-</td></tr>
    <tr><th>서비스구분</th><td>-</td></tr>
    <tr><th>망종류</th><td>-</td></tr>
    <tr><th>설치년도</th><td>-</td></tr>
    <tr><th>실내외구분</th><td>-</td></tr>
    <tr><th>WIFI접속환경</th><td>-</td></tr>
    <tr><th>X좌표</th><td>-</td></tr>
    <tr><th>Y좌표</th><td>-</td></tr>
    <tr><th>작업일자</th><td>-</td></tr>
</table>

</body>
</html>