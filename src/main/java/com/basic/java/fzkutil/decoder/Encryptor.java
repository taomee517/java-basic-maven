package com.basic.java.fzkutil.decoder;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class Encryptor {

//	protected final static Logger logger = LogUtil.getLogger(Encryptor.class);

	/**
	 * 解密
	 * 
	 * @param message
	 *            加密后的内容
	 * @param key
	 *            密钥
	 * @return
	 * @throws NoSuchPaddingException 
	 * @throws NoSuchAlgorithmException 
	 * @throws UnsupportedEncodingException 
	 * @throws InvalidKeyException 
	 * @throws Exception
	 */
	public static String decrypt(String message, String key) throws Exception {

		byte[] bytesrc = convertHexString(message);
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));

		cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);

		byte[] retByte = cipher.doFinal(bytesrc);
		return new String(retByte);
	}

	/**
	 * 加密
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static byte[] encrypt(String message, String key) throws Exception {
		Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

		return cipher.doFinal(message.getBytes("UTF-8"));
	}

	public static byte[] convertHexString(String ss) {
		byte digest[] = new byte[ss.length() / 2];
		for (int i = 0; i < digest.length; i++) {
			String byteString = ss.substring(2 * i, 2 * i + 2);
			int byteValue = Integer.parseInt(byteString, 16);
			digest[i] = (byte) byteValue;
		}

		return digest;
	}

	/**
	 * 加密，返回的是加密后的字符串
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String encrypt2(String message, String key) throws Exception {
		String jiami = java.net.URLEncoder.encode(message, "utf-8").toLowerCase();
		String a = toHexString(encrypt(jiami, key)).toUpperCase();
		return a;
	}

	/**
	 * 解密，返回的是解密后的字符串
	 * 
	 * @param message
	 * @param key
	 * @return
	 * @throws Exception
	 */
	public static String decrypt2(String message, String key) throws Exception {
		String result = java.net.URLDecoder.decode(decrypt(message, key), "utf-8");
		return result;
	}

	public static void main(String[] args) throws Exception {
		System.out.println(encrypt("jdbc:sqlserver://localhost;DatabaseName=siruiportal"));
//		System.err.println(decrypt("C0438870200054C4118231BCD8A2D19D").equals("000000000000001"));
//		System.out.println(decrypt("6560612F34F04D9EDBF9179F634006EFB1B71095DE4232913CD1D77B15353C6798A75F18A718184F01B93728FFD8216C521CAFD24A9B3A2582107DEA2E6F4771D501A27C851C5967BBFDBDCEC60469096153E52DADF8853FC3D96BB6255240DA5A466F258FEA35342019A7C9014DA0EA35E30AA5329FB10E5F7AB04BCFB1437DFC2C93F7B38D053F5AD3A91915B5470648E6305811432AC3F6900BDAFC2D5BDA9E01DCBCBAABB388B737237D25A4AD67E65225AC64E519264EBA878D34C98C5EE81C676337B7136F"));
//		System.out.println(decrypt("68E2FE2FDC2976F8DBD96E5A746EBA66"));
		System.out.println("密码"+decrypt("3821920523632EA0"));

	}

	public static String encrypt(String msg) {
		String key = "BOTWAVEE";
		try {
			return toHexString(encrypt(msg, key)).toUpperCase();
		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
			return null;
		}
	}

	public static String decrypt(String msg) {
		try {
			if (msg == null || msg.trim().length() == 0) {
				return "";
			}
			return java.net.URLDecoder.decode(decrypt(msg, "BOTWAVEE"), "utf-8");
		} catch (Exception e) {
//			logger.error(null, e);
			return null;
		}
	}

	public static String toHexString(byte b[]) {
		StringBuffer hexString = new StringBuffer();
		for (int i = 0; i < b.length; i++) {
			String plainText = Integer.toHexString(0xff & b[i]);
			if (plainText.length() < 2)
				plainText = "0" + plainText;
			hexString.append(plainText);
		}

		return hexString.toString();
	}

}
