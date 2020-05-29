package com.forum.utils;

import java.security.MessageDigest;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;

import com.alibaba.fastjson.JSONObject;
 
public class ForumUtils {
 
	public static String getRandomUUID() {
		return UUID.randomUUID().toString().replace("-", "");//replace:替换掉uuid中生成的-
	}
	
	public static String toJSONString(Integer code) {
		JSONObject root = new JSONObject();
		root.put("code", code);
		return root.toJSONString();
	}
	
	public static String toJSONString(Integer code,String message) {
		JSONObject root = new JSONObject();
		root.put("code", code);
		root.put("message", message);
		return root.toJSONString();
	}
	 
	public static String toJSONString(Integer code, Map<String, Object> map) {
		JSONObject root = new JSONObject();
		root.put("code", code);
        for(Entry<String, Object> entry : map.entrySet()) {
        	root.put(entry.getKey(), entry.getValue());
        }
		return root.toJSONString();
	}
	
	public static String MD5(String key) {
		char hexDigits[] = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		
		try {
			byte[] btInput = key.getBytes();
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			int j= md.length;
			char str[] =new char[j * 2];
			int k = 0;
			for(int i = 0; i < j; i++) {				
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
}
