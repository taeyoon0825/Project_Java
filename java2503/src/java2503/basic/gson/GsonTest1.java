package java2503.basic.gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class GsonTest1 {

	public static void main(String[] args) {

		Gson gson = new GsonBuilder().setPrettyPrinting().create();

		JsonObject jsonObject = new JsonObject();
		jsonObject.addProperty("name","홍길동");
		jsonObject.addProperty("age",30);

		String jsonStr =  gson.toJson(jsonObject);
		System.out.println(jsonStr);

		String jsonStr2 = "{\"name\":\"강감찬\",\"age\":30}";
		Person person = gson.fromJson(jsonStr2, Person.class);
		System.out.println(person);

		String jsonStr3 = gson.toJson(person);
		System.out.println(jsonStr3);

		Map<String, String> map = new HashMap<>();
		map.put("name", "유관순");
		map.put("age", "20");
		map.put("gender", "여성");
		String mapStr = gson.toJson(map);
		System.out.println(mapStr);

		Map<String, String> map2 = gson.fromJson(mapStr, Map.class);
		System.out.println(map2);

		List<Person> personList = new ArrayList<>();
		personList.add(new Person("홍길동", 30));
		personList.add(new Person("강감찬", 40));
		personList.add(new Person("이순신", 50));
		String jsonStr4 = gson.toJson(personList);
		System.out.println(jsonStr4);

		List<Person> personList2 = gson.fromJson(jsonStr4, List.class);
		System.out.println(personList2);


	}


}
