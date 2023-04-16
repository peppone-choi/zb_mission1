package com.zb.zerobase_mission1;

import com.google.gson.*;
import com.google.gson.annotations.JsonAdapter;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.lang.reflect.Type;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Client {
    public Responses getApiResponse(int first_count, int last_count) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://openapi.seoul.go.kr:8088/61694b4c4473616e33336d50715447/json/TbPublicWifiInfo/" + (first_count) + "/" + (last_count)).get().build();;
        Response response = okHttpClient.newCall(request).execute();

        //Gson 변환

        if (response.isSuccessful()) {
            String jsons = response.body().string();
            return new Gson().fromJson(jsons, Responses.class);
        }
        // 예외처리
        return null;
    }

}