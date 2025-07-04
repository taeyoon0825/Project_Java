package exmenu;

import java.io.IOException;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class JsonRest {
	
	// JSON URL 환경에 맞게 변경 가능
	private static final String JSON_URL = "http://localhost:3000/food";
	// 통신 객체 (HTTP Client : HTTP 요청을 보내고 응답받는 객체) 
	private static final OkHttpClient client = new OkHttpClient();
	// Gson 객체
	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	// JSON 서버에 GET 요청
	public static void getFood() {
		
		// request 요청 객체 만들기
		Request request = new Request.Builder().url(JSON_URL).build();
		
		// client
		client.newCall(request).enqueue(new Callback() {
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				// json 문자열 가져오기
				String json =  Objects.requireNonNull(response.body().string());
				System.out.println(json);
			}
			@Override
			public void onFailure(Call call, IOException ioe) {
				ioe.printStackTrace();
			}
		});
		
	} // getFood()
	
	
	
	
} // class
