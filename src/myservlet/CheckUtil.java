
    /**  
    * @Title: CheckUtil.java
    * @Package myservlet
    * @Description: TODO(��һ�仰�������ļ���ʲô)
    * @author wjk
    * @date 2018��7��5��
    * @version V1.0  
    */
    
package myservlet;

import java.util.Arrays;

/**
    * @ClassName: CheckUtil
    * @Description: TODO(������һ�仰��������������)
    * @author wjk
    * @date 2018��7��5��
    *
    */

public class CheckUtil {
	
	public static final String token  ="##";
	
	public static boolean check(String signature,String timestamp,String nonce ) {
		String arrs[] = {token,timestamp,nonce};
		Arrays.sort(arrs);//�ֵ�����
		//ƴ���ַ���
		StringBuffer sb = new  StringBuffer();
		for(String str :arrs) {
			sb.append(str);
		}
		String signaturesha1 = Sha1Util.encode(sb.toString());
		return  signaturesha1.equals(signature);
	}

}
