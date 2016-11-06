package com.idea.mcq.util;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtils {

	private static ObjectMapper mapper = new ObjectMapper();
	static{
		mapper.configure(Feature.ALLOW_SINGLE_QUOTES, true);
	}
	
	public static synchronized Object convertToObject(String json, Class<?> entityType){
		try {
			return mapper.readValue(json, entityType);
		} catch (IOException e) {
			throw new RuntimeException(String.format("Exception occured while converting json to %s", entityType.getSimpleName()), e);
		}
	}
	
	public static synchronized String toJson(Object obj){
		try {
			return mapper.writeValueAsString(obj);
		} catch (IOException e) {
			throw new RuntimeException("Exception occured while converting object to json", e);
		}
	}
	
	public static synchronized String toJson(List objs, Class<?> entityType){
		try {
			return mapper.writeValueAsString(objs);
		} catch (IOException e) {
			throw new RuntimeException("Exception occured while converting object to json", e);
		}
	}
}
