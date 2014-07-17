package com.util;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Description:   判断是否为空工具类
 * @author: 杨聪艺
 * Create Date: 2014-3-26
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-3-26.1		杨聪艺		2014-3-26		create					
 * </pre>
 */
public class EmptyUtil {
	
	/**
	 * Description :判断obj是否为null
	 * @param obj
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNull(Object obj) {
		return null==obj;
	}
	
	/**
	 * Description :判断obj是否不为null
	 * @param obj
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNotNull(Object obj) {
		return !isNull(obj);
	}
	
	/**
	 * Description :判断obj对象的属性值是否都不为空
	 * @param obj
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNotEmpty(Object obj) {
		return !isEmpty(obj);
	}
	
	/**
	 * Description :判断obj对象的属性值是否都为空
	 * @param obj
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isEmpty(Object obj) {
		
		boolean flag = true;
		
		if(null == obj) {
			return flag;
		}
		else {
			Field fields[]=obj.getClass().getDeclaredFields();
			for(Field field:fields) {
				field.setAccessible(true);
				try {
					Object value=field.get(obj);
					if(null != value) {
						flag=false;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return flag;
		
	}
	
	/**
	 * Description :判断字符串是否不为null或""
	 * @param str
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}
	
	/**
	 * Description :判断字符串是否为null或""
	 * @param str
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isEmpty(String str) {
		
		boolean flag = false;
		
		if(null == str) {
			flag = true;
		}
		else if("".equals(str)) {
			flag = true;
		}
		else if(null == str.trim()) {
			flag = true;
		}
		else if("".equals(str.trim())) {
			flag = true;
		}
		
		return flag;
		
	}
	
	/**
	 * Description :判断一个List对象是否不为null或size=0
	 * @param list
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNotEmpty(List<?> list) {
		return !isEmpty(list);
	}
	
	/**
	 * Description :判断一个List对象是否为null或size=0
	 * @param list
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isEmpty(List<?> list) {
		
		boolean flag = false;
		
		if(null == list) {
			flag = true;
		}
		else if(list.size()<=0) {
			flag = true;
		}
		
		return flag;
		
	}
	
	/**
	 * Description :判断一个Set对象是否不为null或size=0
	 * @param sets
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNotEmpty(Set<?> sets) {
		return !isEmpty(sets);
	}
	
	/**
	 * Description :判断一个Set对象是否为null或size=0
	 * @param sets
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isEmpty(Set<?> sets) {
		
		boolean flag = false;
		
		if(null == sets) {
			flag = true;
		}
		else if(sets.size()<=0) {
			flag = true;
		}
		
		return flag;
		
	}
	
	/**
	 * Description :判断一个数组是否不为空或leng=0
	 * @param objs
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNotEmpty(Object objs[]) {
		return !isEmpty(objs);
	}
	
	/**
	 * Description :判断一个数组是否为空或leng=0
	 * @param objs
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isEmpty(Object objs[]) {
		
		boolean flag = false;
		
		if(null == objs) {
			flag = true;
		}
		else if(objs.length<=0) {
			flag = true;
		}
		
		return flag;
		
	}
	
	/**
	 * Description :判断一个Map是否不为空或者size=0
	 * @param map
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isNotEmpty(Map<Object, Object> map) {
		return !isEmpty(map);
	}
	
	/**
	 * Description :判断一个Map是否为空或者size=0
	 * @param map
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static boolean isEmpty(Map<Object, Object> map) {
		
		boolean flag = false;
		
		if(null == map) {
			flag = true;
		}
		else if(map.size()<=0) {
			flag = true;
		}
		
		return flag;
		
	}

}
