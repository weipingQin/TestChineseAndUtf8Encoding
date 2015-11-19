package com.test.qinweiping;

import java.io.UnsupportedEncodingException;
import java.util.concurrent.SynchronousQueue;

public class TestUtf8Encoding {
	
	public static void main(String[] args) {
		String testUtf8String = "\u4e2d\u56fd\u4f01\u4e1a\u5bb6\u6742\u5fd7";
		

		String testString1 = "\u9a8c\u8bc1\u7801\u9519\u8bef0";
		
		String testString2 = "\u9a8c\u8bc1\u7801\u9519\u8bef";
		
		try{
			TestUtf8Encoding test = new TestUtf8Encoding();
			String chineseStr = test.decodingUtf8(testString1);
			String testChineseStr = test.decodingUtf8(testString2);
			System.out.println("知乎网友模拟登录将utf-8编码转化成中文:"+chineseStr);
			System.out.println("知乎网友模拟登录解出来的字符:"+testChineseStr);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		String result = TestUtf8Encoding.encodingGBK("中国企业家杂志");
		System.out.println("将中文转化成utf-8编码:"+result);
		
		String testString = TestUtf8Encoding.stringConvertHexCharacter("中国企业家杂志");
		System.out.println(testString);
		
		
		//String utf8String = TestUtf8Encoding.formatUft8String(testString);
	//	System.out.println("formatutf-8String"+utf8String);
		
	}
	
	

	/**
	 * 将utf-8编码解码
	 * 
	 * @param strUft8
	 */
	private String decodingUtf8(String strUft8) throws UnsupportedEncodingException{
		String strChineString = new String(strUft8.getBytes("UTF-8"),"utf-8");
		return strChineString;
	}
	/**
	 * 将gbk编码转化utf-8编码
	 * @param gbkString
	 * @return
	 */
	private static String encodingGBK(String gbkString){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< gbkString.length(); i++){
			sb.append("\\u" +Integer.toString(gbkString.charAt(i), 16));
		}
		return sb.toString();
	}
	
	/**
	 * 将中文字符转化成十六进制的字符数组
	 * @return gbkString
	 */
	private static String stringConvertHexCharacter(String gbkString){
		String result = "";
		for(int i = 0 ; i < gbkString.length();i++){
			int ch = (int)gbkString.charAt(i);
			String s = Integer.toHexString(ch);
			result += s;
		}
		return result;
	}
	
	
	/**
	 * 将16进制数格式化一下 就变成了utf-8编码 
	 */
	private static String formatUft8String(String hexString){
		String result = "";
		StringBuilder sb = new StringBuilder();
		for(int i = 0 ; i < hexString.length() ; i++){
			result +=hexString.substring(i*4,hexString.length());
			//break;
			result += hexString.substring(i*4,i*4+4)+"\\u";
		}
		return result;
	}


	//	public static String getUTF8StringFromGBKString(String gbkStr) {  
	//        try {  
	//            return new String(getUTF8BytesFromGBKString(gbkStr), "UTF-8");  
	//        } catch (UnsupportedEncodingException e) {  
	//            throw new InternalError();  
	//        }  
	//    }  
	//	
	//	
	//	 public static byte[] getUTF8BytesFromGBKString(String gbkStr) {  
	//	        int n = gbkStr.length();  
	//	        byte[] utfBytes = new byte[3 * n];  
	//	        int k = 0;  
	//	        for (int i = 0; i < n; i++) {  
	//	            int m = gbkStr.charAt(i);  
	//	            if (m < 128 && m >= 0) {  
	//	                utfBytes[k++] = (byte) m;  
	//	                continue;  
	//	            }  
	//	            utfBytes[k++] = (byte) (0xe0 | (m >> 12));  
	//	            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));  
	//	            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));  
	//	        }  
	//	        if (k < utfBytes.length) {  
	//	            byte[] tmp = new byte[k];  
	//	            System.arraycopy(utfBytes, 0, tmp, 0, k);  
	//	            return tmp;  
	//	        }  
	//	        return utfBytes;  
	//	    }  
	
}
