package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {
	
	public static Integer getValueToInteger(String filePath,String key) {
		String value=getValue(filePath,key);
		Integer res=new Integer(value);
		return res;
	}
	
	public static String getValue(String filePath,String key) {
		
        Properties props=getProperties(filePath);
        String value = props.getProperty(key);
        
        return value;
    }
	
	public static Properties getProperties(InputStream ips) {
		
		Properties props = new Properties();
		try {
			props.load(ips);
//			Iterator<Object> its=props.keySet().iterator();
//			while(its.hasNext()) {
//				String key=(String)its.next();
//				if(Constant.PARENT.equals(key)) {
//					String path=(String)props.get(key);
//					props.putAll(getProperties(path));
//				}
//			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return props;
	}
	
	//读取全部信息
    public static Properties getProperties(String filePath) {
    	
        Properties props = new Properties();
        InputStream ips = null;
        
    	ips=PropertiesUtil.class.getResourceAsStream(filePath);
        props=getProperties(ips);
        
        if(ips != null){
            try {
                ips.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        return props;
    }
    
}
