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
<div style="padding: 2px 0px 5px 0px"><a href="index.jsp">홈</a> | <a href="history.jsp">위치 히스토리 목록</a> | <a href="load-wifi.jsp">OpenApi 와이파이 정보 가져오기</a> | <a href="#">북마크 보기</a> | <a href="#">북마크 그룹 관리</a> </div>
<div style="padding: 2px 0px 10px 0px">
    <form>
        LAT : <input class="lat" value="0.0" placeholder="0.0"></input> LNT : <input class="lnt" value="0.0" placeholder="0.0"></input> <button id="getGeo" type="button" onclick = "getPosition()">내 위치 가져오기</button> <button id="findWifi" onclick = "location.href = '#'">근처 WIFI 정보 보기</button>
    </form>
</div>
<table id="wifi-table">
    <tr>
        <th>거리</th>
        <th>관리번호</th>
        <th>자치구</th>
        <th>와이파이명</th>
        <th>도로명주소</th>
        <th>상세주소</th>
        <th>설치위치(층)</th>
        <th>설치유형</th>
        <th>설치기관</th>
        <th>서비스구분</th>
        <th>망종류</th>
        <th>설치년도</th>
        <th>실내외구분</th>
        <th>WIFI접속환경</th>
        <th>X좌표</th>
        <th>Y좌표</th>
        <th>작업일자</th>
    </tr>
    <tr>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
        <td>-</td>
    </tr>
</table>

</body>
</html>