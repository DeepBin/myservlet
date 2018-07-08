package myservlet;

import java.security.MessageDigest;

public final class Sha1Util {

	private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
			'e', 'f' };

	/**
	 * 
	    * @Title: getFormattedText
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param bytes
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	private static String getFormattedText(byte[] bytes) {
		int len = bytes.length;
		StringBuilder buf = new StringBuilder(len * 2);
		// ������ת����ʮ�����Ƶ��ַ�����ʽ
		for (int j = 0; j < len; j++) {
			buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
			buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
		}
		return buf.toString();
	}

	/**
	 * 
	    * @Title: encode
	    * @Description: TODO(������һ�仰�����������������)
	    * @param @param str
	    * @param @return    ����
	    * @return String    ��������
	    * @throws
	 */
	public static String encode(String str) {
        if (str == null) {
            return null;
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(str.getBytes());
            return getFormattedText(messageDigest.digest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}