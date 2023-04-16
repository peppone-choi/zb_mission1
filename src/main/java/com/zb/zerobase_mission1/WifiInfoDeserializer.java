package com.zb.zerobase_mission1;

import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class WifiInfoDeserializer implements JsonDeserializer<Responses> {
    @Override
    public Responses deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject responseBody = json.getAsJsonObject();
        JsonObject tbPublicWifiInfo = json.getAsJsonObject().getAsJsonObject("TbPublicWifiInfo");
        int list_total_count = tbPublicWifiInfo.get("list_total_count").getAsInt();
        JsonArray row = tbPublicWifiInfo.get("row").getAsJsonArray();
        ArrayList<OpenApi> list = new ArrayList<>();
        for (JsonElement element : row) {
            OpenApi openApi = new Gson().fromJson(element.getAsJsonObject(), OpenApi.class);
            list.add(openApi);
        }

        return new Responses(list_total_count, list);
    }
}
