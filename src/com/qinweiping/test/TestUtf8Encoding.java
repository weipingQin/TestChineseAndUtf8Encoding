package com.qinweiping.test;

import java.io.UnsupportedEncodingException;

public class TestUtf8Encoding {

	public static void main(String[] args) {
		String testUtf8String = "\u4e2d\u56fd\u4f01\u4e1a\u5bb6\u6742\u5fd7";
		try{
			TestUtf8Encoding test = new TestUtf8Encoding();
			String chineseStr = test.decodingUtf8(testUtf8String);
			System.out.println("将utf-8编码转化成中文:"+chineseStr);
		}catch(UnsupportedEncodingException e){
			e.printStackTrace();
		}
		String result = TestUtf8Encoding.encodingGBK("中国企业家杂志");
		System.out.println("将中文转化成utf-8编码:"+result);
		//System.out.println("将中文转化成utf-8编码"＋result);
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
