package com.util;

import org.apache.struts2.ServletActionContext;

public class PathUtil {
	
	public static String getRightJsonPath(String fileName) {
		String contextPath="common\\json\\"+fileName+".json";
		String realPath=ServletActionContext.getServletContext().getRealPath("/")+contextPath;
		return realPath;
	}
	
	/*
	public static String getRightPropertiesPath(String path) {
		String realPath=ServletActionContext.getServletContext().getRealPath("/")+path.replaceAll("/", "\\\\");
		return realPath;
	}
	*/

}
