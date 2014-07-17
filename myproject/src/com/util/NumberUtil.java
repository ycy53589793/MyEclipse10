package com.util;

import java.text.DecimalFormat;
/**
 * Description:   数字工具类
 * @author: 杨聪艺
 * Create Date: 2014-4-3
 * <pre>
 * 修改记录:
 * 修改后版本			修改人		修改日期			修改内容 
 * 2014-4-3.1		杨聪艺		2014-4-3		create					
 * </pre>
 */
public class NumberUtil {
	
	/**
	 * Description :对a进行四舍五入取b位小数
	 * @param a
	 * @param b
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static double decimalFormat(double a,int b) {
		if(b==0) {
			return Math.rint(a);
		}
		double rr=10.0;
		for(int i=0;i<b-1;i++) {
			rr*=10;
		}
		return Math.round(a*rr)/rr;
	}
	
	/**
	 * Description :对a进行四舍五入取整
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static double decimalFormat(double a) {
		return decimalFormat(a,0);
	}
	
	/**
	 * Description :对a进行四舍五入取b位小数
	 * @param a
	 * @param b
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static String decimalFormatToString(double a,int b) {
		String fm="###.";
		if(b==0) {
			fm="###";
		}
		for(int i=0;i<b;i++) {
			fm+="0";
		}
		DecimalFormat df=new DecimalFormat(fm);
		return df.format(a);
	}
	
	/**
	 * Description :对a进行四舍五入取整
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static String decimalFormatToString(double a) {
		return decimalFormatToString(a,0);
	}
	
	/**
	 * Description :如果a为空值则返回0,否则返回a
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static Double nullToZero(Double a) {
		if(null==a) {
			return 0.0;
		}
		return a;
	}
	
	/**
	 * Description :如果a为空值则返回0,否则返回a
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-4-3
	 */
	public static Integer nullToZero(Integer a) {
		if(null==a) {
			return 0;
		}
		return a;
	}
	
	/**
	 * Description :字符串转换Integer或者int
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-5-31
	 */
	public static Integer stringToInteger(String a) {
		return new Integer(a);
	}
	
	/**
	 * Description :字符串转换Long或者long
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-5-31
	 */
	public static Long stringToLong(String a) {
		return new Long(a);
	}
	
	/**
	 * Description :字符串转换Float或者float
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-5-31
	 */
	public static Float stringToFloat(String a) {
		return new Float(a);
	}
	
	/**
	 * Description :字符串转换Double或者double
	 * @param a
	 * @return
	 * @Author: 杨聪艺
	 * @Create Date: 2014-5-31
	 */
	public static Double stringToDouble(String a) {
		return new Double(a);
	}
	
//	public static void main(String args[]) {
//		System.out.println(decimalFormatToString(2.187,0));
//	}

}
