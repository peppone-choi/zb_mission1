package com.zb.zerobase_mission1;

import com.google.gson.annotations.JsonAdapter;

import java.util.List;

/**
 * totalCount   총 데이터 건수 (정상조회 시 출력)
 * openApis     와이파이 항목의 리스트 (OpenApi.java 참고)
 */
@JsonAdapter(WifiInfoDeserializer.class)
public class Responses {
    private int totalCount;
    private List<OpenApi> openApis;

    Responses(int totalCount, List<OpenApi> openApis) {
        this.totalCount = totalCount;
        this.openApis = openApis;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public List<OpenApi> getOpenApis() {
        return openApis;
    }
}
