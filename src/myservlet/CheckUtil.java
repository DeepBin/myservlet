
    /**  
    * @Title: CheckUtil.java
    * @Package myservlet
    * @Description: TODO(用一句话描述该文件做什么)
    * @author wjk
    * @date 2018年7月5日
    * @version V1.0  
    */
    
package myservlet;

import java.util.Arrays;

/**
    * @ClassName: CheckUtil
    * @Description: TODO(这里用一句话描述这个类的作用)
    * @author wjk
    * @date 2018年7月5日
    *
    */

public class CheckUtil {
	
	public static final String token  ="##";
	
	public static boolean check(String signature,String timestamp,String nonce ) {
		String arrs[] = {token,timestamp,nonce};
		Arrays.sort(arrs);//字典排序
		//拼接字符串
		StringBuffer sb = new  StringBuffer();
		for(String str :arrs) {
			sb.append(str);
		}
		String signaturesha1 = Sha1Util.encode(sb.toString());
		return  signaturesha1.equals(signature);
	}

}
