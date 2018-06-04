package timesheets.clicktime.common;

import java.io.IOException;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class JsonHelper {
	public static boolean isEmpty(String json) {
		return json.isEmpty() || json == null;
	}

	public static List<?> jsonToList(String json, Class<?> className) {
		ObjectMapper mapper = new ObjectMapper();
		List<?> list = new ArrayList<>();
		try {
			list = mapper.readValue(json, TypeFactory.defaultInstance().constructCollectionType(List.class, className));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
}
