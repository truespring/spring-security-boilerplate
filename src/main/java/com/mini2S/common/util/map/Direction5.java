package com.mini2S.common.util.map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.mini2S.common.NaverApiInfo;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class Direction5 {

    // Naver Cloud Platform의 Direction5 사용, 네비게이션 기준 거리 산정
    public static JsonElement selectNavigationInfo(String userStartX, String userStartY, String branchGoalX, String branchGoalY) {
        NaverApiInfo naverApiInfo = new NaverApiInfo();
        String start_point;
        String goal_point;
        StringBuffer result;

        try {
            start_point = URLEncoder.encode((userStartY + "," + userStartX), StandardCharsets.UTF_8.toString());
            goal_point = URLEncoder.encode((branchGoalY + "," + branchGoalX), StandardCharsets.UTF_8.toString());
            // trafast : 실시간 빠른길
            String api = "https://naveropenapi.apigw.ntruss.com/map-direction/v1/driving?start=" + start_point + "&goal=" + goal_point + "&option=traoptimal";
            result = new StringBuffer();
            URL url = new URL(api);
            HttpsURLConnection http = (HttpsURLConnection) url.openConnection();
            http.setRequestProperty("Content-Type", "application/json");
            http.setRequestProperty("X-NCP-APIGW-API-KEY-ID", naverApiInfo.getKeyId());
            http.setRequestProperty("X-NCP-APIGW-API-KEY", naverApiInfo.getKey());
            http.setRequestMethod("GET");
            http.connect();
            InputStreamReader in = new InputStreamReader(http.getInputStream(), StandardCharsets.UTF_8);
            BufferedReader br = new BufferedReader(in);
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
            return JsonParser.parseString(String.valueOf(result));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map<String, String> selectDistanceAFromB(JsonElement jsonElement) {
        JsonElement element = JsonParser.parseString(String.valueOf(jsonElement));
        Map<String, String> result = new HashMap<>();
        result.put("code", String.valueOf(element.getAsJsonObject().get("code")));
        result.put("message", String.valueOf(element.getAsJsonObject().get("message")));
        if (!result.get("code").equals("2")) {
            JsonArray traoptimal = (element.getAsJsonObject().get("route").getAsJsonObject()).getAsJsonArray("traoptimal");
            result.put("distance", ((traoptimal.get(0).getAsJsonObject())
                    .get("summary").getAsJsonObject())
                    .get("distance").toString());
        }
        return result;
    }
}
