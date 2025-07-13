package exmenu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

// Json 서버 요청 class (Heewon-07.05)
public class JsonRest {

	// JSON URL 환경에 맞게 변경 가능
	private static final String JSON_URL = "http://localhost:3000/food";
	// 통신 객체 (HTTP Client : HTTP 요청을 보내고 응답받는 객체)
	private static final OkHttpClient client = new OkHttpClient();
	// Gson 객체
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	// Json 서버에 저장된 연속으로 먹은 5개 메뉴 삭제를 위한 리스트
	public static List<String> recentEatFood = new ArrayList<String>();

	// Json 서버에서 보낸 Json 요청의 List
	public static List<Food> jsonFoodList = new ArrayList<Food>();

	// JSON 서버에 GET 요청
	public static void getFood() {
		// request 요청 객체 만들기
		Request request = new Request.Builder().url(JSON_URL).build();

		try {
			// client response
			Response response = client.newCall(request).execute();

			String json = Objects.requireNonNull(response.body()).string();

			// Food 객체로 변환 후 리스트에저장
			jsonFoodList = gson.fromJson(json, new TypeToken<List<Food>>() {
			}.getType());

			// 이름만 뽑아서 recentEatFood에 저장
			recentEatFood.clear();
			recentEatFood.addAll(jsonFoodList.stream().map(Food::getName).collect(Collectors.toList()));

			
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	} // getFood()

	// JSON 서버에 POST 요청
	public static void postFood(Food addFood) {

		// 파라미터로 받아온 Food 객체를 json으로 변환
		String json = gson.toJson(addFood);
		RequestBody body = RequestBody.create(MediaType.parse("application/json"), json);

		try {

			Request request = new Request.Builder().url(JSON_URL).post(body).build();
			client.newCall(request).execute();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // postFood()

	// JSON 서버에 DELETE 요청
	public static void delFood(String id) {

		// request 요청 객체 만들기
		Request request = new Request.Builder().url(JSON_URL + "/" + id).delete().build();
		// client response
		try {
			client.newCall(request).execute();

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	} // delFood

	// 최신메뉴 리스트 반환하는 메소드
	public static List<String> getRecentMenus() {
	    List<String> menus = new ArrayList<>();
	    try {
	        OkHttpClient client = new OkHttpClient();
	        Request request = new Request.Builder().url("http://localhost:3000/food").build();
	        Response response = client.newCall(request).execute(); // 동기 호출!
	        String json = Objects.requireNonNull(response.body()).string();

	        Gson gson = new Gson();
	        List<Food> foodList = gson.fromJson(json, new TypeToken<List<Food>>() {}.getType());

	        int size = foodList.size();
	        for (int i = Math.max(0, size - 5); i < size; i++) {
	            menus.add(foodList.get(i).getName());
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return menus;
	}
	
	
} // class
