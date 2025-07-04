package exmenu;

import java.time.LocalDate;
import java.util.*;

public class MenuMain {

	// 인증키 및 역삼동 NX, NY 정보
    static final String SERVICE_KEY = "9AA719PkHP%2FL9samf6Tw%2BW7K%2FsloxojIIrx9yvPw2pejN75FzaN1GY0%2BuUl8LC9QIG3CFmxlwtmlSz6LVBGU2A%3D%3D";
    static final String NX = "63";
    static final String NY = "125";

    // 현재 일자 확인
    public static void main(String[] args) throws Exception {
        LocalDate today = LocalDate.now();

        // 복날 체크
        if (isBoknal(today)) {
            System.out.println("🥵 오늘은 복날입니다! 메뉴는 무조건: 삼계탕");
            return;
        }

        // WeatherAPIClient 파싱
        WeatherAPIClient.WeatherInfo weather = WeatherAPIClient.getWeatherInfo(NX, NY, SERVICE_KEY);

        
        System.out.printf("▶ 현재 날씨 기준 - 강수확률: %d%%, 기온: %.1f°C%n",
                weather.rainProbability, weather.temperature);

        // 전체 메뉴
        List<String> menuList = new ArrayList<>(Arrays.asList(
            "짬뽕", "비빔밥", "칼국수", "냉모밀", "돈까스", "쭈꾸미", "오징어", "부대찌개", "전골", "콩국수",
            "닭볶음탕", "아지매국밥", "순대국밥", "김밥천국", "삼계탕", "된장전골", "북엇국", "샤브샤브", "김치찌개", "물회"
        ));

        // 비올때, 더울때 제외 음식 리스트
        List<String> rainExcluded = Arrays.asList("칼국수", "콩국수", "김밥천국", "냉모밀", "물회", "전골");
        List<String> hotExcluded = Arrays.asList("부대찌개", "전골", "닭볶음탕", "아지매국밥", "순대국밥", "된장전골", "샤브샤브", "김치찌개");

        if (weather.rainProbability >= 70) { // 강수확률 70퍼센트 일때 제외
            menuList.removeAll(rainExcluded);
        }
        if (weather.temperature >= 32.0) { // 온도 32도 이상일때 제외
            menuList.removeAll(hotExcluded);
        }

        if (menuList.isEmpty()) {
            System.out.println("❌ 조건에 맞는 추천 메뉴가 없습니다. 직접 고르세요!");
        } else {
            Collections.shuffle(menuList);
            System.out.println("🍽 오늘의 추천 메뉴: " + menuList.get(0));
        }
    }

    // 복날 설정
    private static boolean isBoknal(LocalDate date) {
        return date.equals(LocalDate.of(2025, 7, 20)) ||
               date.equals(LocalDate.of(2025, 7, 30)) ||
               date.equals(LocalDate.of(2025, 8, 9));
    }
} 