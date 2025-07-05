package exmenu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.google.gson.*;

public class WeatherAPIClient {

    public static WeatherInfo getWeatherInfo(String nx, String ny, String serviceKey) throws Exception {
        String baseDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")); // 초기화
        String baseTime = getBaseTime();

        // API URL 설정
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst");
        urlBuilder.append("?").append(URLEncoder.encode("serviceKey", "UTF-8")).append("=").append(serviceKey);
        urlBuilder.append("&pageNo=1&numOfRows=1000&dataType=JSON");
        urlBuilder.append("&base_date=").append("20250704");
        urlBuilder.append("&base_time=").append("1200");
        urlBuilder.append("&nx=").append(nx).append("&ny=").append(ny);

        // 호출 방식 GET
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        // 응답처리 200~ 300 정상 400~500 오류메세지 처리
        BufferedReader rd = new BufferedReader(new InputStreamReader(
                conn.getResponseCode() >= 200 && conn.getResponseCode() < 300 ?
                        conn.getInputStream() : conn.getErrorStream()));
        
        // 본문 읽고 저장 
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) sb.append(line);
        rd.close();
        conn.disconnect();

        // Json 파싱 (전체 응답 문자열을 Gson으로 파싱해서 JsonElement로 변환)
        JsonObject items = JsonParser.parseString(sb.toString())
                .getAsJsonObject().getAsJsonObject("response")
                .getAsJsonObject("body").getAsJsonObject("items");

        int pop = 0;
        double t1h = -100;

        // 필요 데이터 추출 
        for (JsonElement e : items.getAsJsonArray("item")) {
            JsonObject obj = e.getAsJsonObject();
            String category = obj.get("category").getAsString();
            String fcstValue = obj.get("fcstValue").getAsString();
            if (category.equals("POP")) {
                pop = Integer.parseInt(fcstValue);
            } else if (category.equals("T1H")) {
                t1h = Double.parseDouble(fcstValue);
            }
        }
        
        return new WeatherInfo(pop, t1h);
    } // getWeatherInfo

    // 현재 시각을 가져와 기상청이 요구하는 정각시각 으로 계산 (getBaseTime() 함수)
    private static String getBaseTime() {
        LocalTime now = LocalTime.now();
        int hour = now.getHour();
        int minute = now.getMinute();
        if (minute < 45) hour--;
        if (hour < 0) hour = 23;
        return String.format("%02d00", hour);
    }

    public static class WeatherInfo {
        public int rainProbability;
        public double temperature;
        
        public WeatherInfo(int pop, double t1h) {
            this.rainProbability = pop;
            this.temperature = t1h;
        }
    } 
    
} // class
