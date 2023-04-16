package com.zb.zerobase_mission1;

import java.io.IOException;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException {
        Client testClient = new Client();
        ApiService testApi = new ApiService(testClient);
        Responses testResp = testApi.addPublicWifi(1, 1); // 오류 발생 시 다음의 주소를 참조할 것 : https://data.seoul.go.kr/dataList/OA-20883/S/1/datasetView.do
        int testRespTotalCount = testResp.getTotalCount(); // 총 데이터 건수를 받아오기 위한 API 호출.
        System.out.println(testRespTotalCount);
        int divine = (testRespTotalCount / 1000); // 1000개씩 API 리스트 호출
        for (int i = 0; i <= divine; i++) {
            Responses testLoopResp = testApi.addPublicWifi((i*1000)+1, (i*1000)+999);
            List<OpenApi> loopOpenApis = testLoopResp.getOpenApis();
            for (int j = 0; j < loopOpenApis.size(); j++) {
                System.out.println(
                        "-------------------------------------------------------------------\n"
                        + "관리번호 : " + loopOpenApis.get(j).getX_SWIFI_MGR_NO() + "\n" +
                        "자치구 : " + loopOpenApis.get(j).getX_SWIFI_WRDOFC() + "\n" +
                        "와이파이명 : " + loopOpenApis.get(j).getX_SWIFI_MAIN_NM() + "\n" +
                        "도로명주소 : " + loopOpenApis.get(j).getX_SWIFI_ADRES1() + "\n" +
                        "상세주소 : " + loopOpenApis.get(j).getX_SWIFI_ADRES2() + "\n" +
                        "설치위치(층) : " + loopOpenApis.get(j).getX_SWIFI_INSTL_FLOOR() + "\n" +
                        "설치유형 : " + loopOpenApis.get(j).getX_SWIFI_INSTL_FLOOR() + "\n" +
                        "설치기관 : " + loopOpenApis.get(j).getX_SWIFI_INSTL_MBY() + "\n" +
                        "서비스구분 : " + loopOpenApis.get(j).getX_SWIFI_SVC_SE() + "\n" +
                        "망종류 : " + loopOpenApis.get(j).getX_SWIFI_CMCWR() + "\n" +
                        "설치년도 : " + loopOpenApis.get(j).getX_SWIFI_CNSTC_YEAR() + "\n" +
                        "실내외구분 : " + loopOpenApis.get(j).getX_SWIFI_INOUT_DOOR() + "\n" +
                        "wifi접속환경 : " + loopOpenApis.get(j).getX_SWIFI_REMARS3() + "\n" +
                        "Y좌표 : " + loopOpenApis.get(j).getLAT() + "\n" +
                        "X좌표 : " + loopOpenApis.get(j).getLNT() + "\n" +
                        "작업일자 : " + loopOpenApis.get(j).getWORK_DTTM() + "\n" +
                        "-------------------------------------------------------------------"
                );
            }
        }
        System.out.println();
    }
}
