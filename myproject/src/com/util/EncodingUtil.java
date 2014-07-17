package com.util;

import java.io.UnsupportedEncodingException;

public class EncodingUtil {
	
	public static String toUTF8(String s) {
		if(EmptyUtil.isNotEmpty(s)) {
			try {
				return new String(s.getBytes("ISO-8859-1"),"utf-8");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	public static String toGBK(String s) {
		if(EmptyUtil.isNotEmpty(s)) {
			try {
				return new String(s.getBytes("ISO-8859-1"),"gbk");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return s;
	}
	
	public static String toGB2312(String s) {
		if(EmptyUtil.isNotEmpty(s)) {
			try {
				return new String(s.getBytes("ISO-8859-1"),"gb2312");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return s;
	}

}
