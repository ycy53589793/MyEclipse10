package com.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.struts2.json.JSONUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.constant.Constant;
import com.constant.Encoding;

public class JsonUtil extends JSONUtil {
	
	private static String readFileAsString(String path) {
		//从json文件读取的值
		String json="";
		BufferedReader reader=null;
		try {
			FileInputStream fis=new FileInputStream(path);
			InputStreamReader isr=new InputStreamReader(fis,Encoding.UTF_8.toString());
			reader=new BufferedReader(isr);
			while (true) {
				String s=reader.readLine();
				if(EmptyUtil.isEmpty(s)) {
					break;
				}
				json+=s;
			}
			json=json.replaceAll("\t", "");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(EmptyUtil.isNotEmpty(reader)) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return json;
	}
	
	public static InputStream readFileAsStream(String classPath) {
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream input = loader.getResourceAsStream(classPath);
        return input;
	}
	
	public static Object getObjectFromFileOfJSON(String classPath,Class<?> clazz) {
		return getObjectFromFileOfJSON(classPath,Encoding.UTF_8.toString(),clazz);
	}
	
	public static Object getObjectFromFileOfJSON(String classPath, String encoding, Class<?> clazz) {
        InputStream input = readFileAsStream(classPath);
        BufferedReader reader = null;
        Object obj = null;
        try {
            reader = new BufferedReader(new InputStreamReader(input, encoding));
            StringBuffer buffer = new StringBuffer();
            // 读取第一行
            String line = reader.readLine();
            // 如果 line 为空说明读完了
            while (line != null) {
            	// 将读到的内容添加到 buffer中
                buffer.append(line);
                // 读取下一行
                line = reader.readLine();
            }
            String str = buffer.toString();
            JSONObject object = JSONObject.fromObject(str);
            if(EmptyUtil.isNotEmpty(clazz)) {
            	obj = JSONObject.toBean(object, clazz);
            }
            else {
            	obj = object;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            obj = null;
        }
        return obj;
    }
	
	public static Object getObjectFromFileOfJSON(String classPath) {
		return getObjectFromFileOfJSON(classPath,Encoding.UTF_8.toString());
	}
	
	public static Object getObjectFromFileOfJSON(String classPath,String encoding) {
		return getObjectFromFileOfJSON(classPath,encoding,null);
	}
	
	public static JSONObject getJsonObject(String path) {
		return getJsonObject(path,Constant.NUMBER.ZERO);
	}
	
	public static JSONObject getJsonObject(String path,int index) {
		JSONArray jsons=getJsonArray(path);
		if(EmptyUtil.isNotEmpty(jsons)) {
			int size=jsons.size();
			if(size>index) {
				return jsons.getJSONObject(index);
			}
		}
		return null;
	}
	
	public static JSONArray getJsonArray(String path) {
		String json=readFileAsString(path);
		return JSONArray.fromObject(json);
	}

}
