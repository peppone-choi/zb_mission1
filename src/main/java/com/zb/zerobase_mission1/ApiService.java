package com.zb.zerobase_mission1;

import lombok.RequiredArgsConstructor;
import okhttp3.Response;

import java.io.IOException;

@RequiredArgsConstructor
public class ApiService {
    private final Client client;

    public Responses addPublicWifi(int first_count, int last_count) throws IOException {
        return client.getApiResponse(first_count, last_count); // first_count, last_count 사이가 1000 이상이면 안됨. 호출 수는 최대 1000개
    }
}
