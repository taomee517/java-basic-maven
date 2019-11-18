package com.basic.java.fzkutil.decoder;


public class Decryptor {
	public static void main(String[] args) {
		String secretUrl = "192D404EE5FF06D73367A552CA9A0A8791CB4A1FFC9967F5";
		String url = Encryptor.decrypt(secretUrl);
		System.out.println("解密后的url:" + url);


		String plainUrl = "jdbc:mysql://192.168.6.160:3306/db_blacktea_cfg?useUnicode=true&characterEncryptoroding=utf8&allowMultiQueries=true&serverTimezone=Asia/Shanghai";
		String enc_url = Encryptor.encrypt(plainUrl);
		System.out.println("加密url:" + enc_url);
		
		String vin = "MY5MFMPP837CY2678";
		boolean b = ValidateUtil.validateVin(vin);
		System.out.println(b);
	}
}
