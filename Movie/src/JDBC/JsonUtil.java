package JDBC;

import java.lang.reflect.Type;
import com.google.gson.Gson;

public class JsonUtil {
	public static <T> T getEntity(String str, Class<T> classOfT) {
		Gson gson = new Gson();
		return gson.fromJson(str, classOfT);
	}
	public static String EntityToJson(Object obj) {
		Gson gson = new Gson();
		return gson.toJson(obj);
	}
	public static <T> T getEntityList(String str, Type typeOfT) {
		Gson gson = new Gson();
		return gson.fromJson(str, typeOfT);
	}
}
