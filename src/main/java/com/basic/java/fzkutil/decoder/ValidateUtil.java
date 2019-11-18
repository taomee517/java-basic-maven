/**
 * 
 */
package com.basic.java.fzkutil.decoder;

import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtil {
	public static void main(String args[]) {
		System.err.println(validateSocialCreditCode("91350100M000100Y43"));
	}

	/**
	 * 验证手机号码
	 * 
	 * @param phone
	 * @return
	 */
	public static boolean validatePhone(String phone) {
		Pattern p_phone = Pattern.compile("^(1[0123456789]\\d{9})$$");
		Matcher matcher = p_phone.matcher(phone);
		//如果是微信测试账号，不需要验证,测试手机账号为demo
//		if ( phone!=null&&phone.equals(paraControlUtil.getParamter("demo_phone"))) {
//			return true;
//		}
		return matcher.matches();
	}

	public static boolean validateEmail(String email) {
		Pattern p_email = Pattern.compile(
				"^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");

		Matcher matcher = p_email.matcher(email);
		return matcher.matches();
	}
	/**
	 * 
	* @Title: isCarnumberNO 
	* @Description: TODO(车牌号验证) 
	* @param carnumber
	* @return
	* @return boolean    返回类型 
	* @throws
	 */
	public static boolean isPlateNumber(String carnumber) {
        String carnumRegex = "([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}(([0-9]{5}[DF])|([DF]([A-HJ-NP-Z0-9])[0-9]{4})))|([京津沪渝冀豫云辽黑湘皖鲁新苏浙赣鄂桂甘晋蒙陕吉闽贵粤青藏川宁琼使领A-Z]{1}[A-Z]{1}[A-HJ-NP-Z0-9]{4}[A-HJ-NP-Z0-9挂学警港澳]{1})";

        if (StringUtils.isBlank(carnumber)) return false;
        else return carnumber.matches(carnumRegex);
    }

	/**
	 * 校验车架号
	 * 
	 * @param vin
	 * @return
	 */
	public static boolean validateVin(String vin) {
		// 长度必须是17位
		if (null == vin || vin.trim().length() != 17) {
			return false;
		}
		vin = vin.trim().toLowerCase();
		// 字幕 o q i
		for (char c : vin.toCharArray()) {
			if (c == 'o' || c == 'q' || c == 'i') {
				return false;
			}
		}
		// 年代位不能有字母Z,(第十位)
		if (vin.charAt(9) == 'z') {
			return false;
		}
		// 第九位必须是数字或字母X,
		List<Character> num = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
		if (vin.charAt(8) != 'x' && !num.contains(vin.charAt(8))) {
			return false;
		}
		// 最后四位必须是数字
		if (!num.contains(vin.charAt(16)) || !num.contains(vin.charAt(15)) || !num.contains(vin.charAt(14))
				|| !num.contains(vin.charAt(13))) {
			return false;
		}

		return checkVINValidateNumber(vin);
	}

	/**
	 * 检查第九位
	 * 
	 * @param vin
	 * @return
	 */
	private static boolean checkVINValidateNumber(String vin) {
		vin = vin.toLowerCase();// 转为小写
		Map<String, Integer> Arr = new HashMap<>();
		Map<Integer, Integer> Brr = new HashMap<>();
		Arr.put("a", 1);
		Arr.put("b", 2);
		Arr.put("c", 3);
		Arr.put("d", 4);
		Arr.put("e", 5);
		Arr.put("f", 6);
		Arr.put("g", 7);
		Arr.put("h", 8);
		Arr.put("j", 1);
		Arr.put("k", 2);
		Arr.put("l", 3);
		Arr.put("m", 4);
		Arr.put("n", 5);
		Arr.put("p", 7);
		Arr.put("r", 9);
		Arr.put("s", 2);
		Arr.put("t", 3);
		Arr.put("u", 4);
		Arr.put("v", 5);
		Arr.put("w", 6);
		Arr.put("x", 7);
		Arr.put("y", 8);
		Arr.put("z", 9);
		Arr.put("1", 1);
		Arr.put("2", 2);
		Arr.put("3", 3);
		Arr.put("4", 4);
		Arr.put("5", 5);
		Arr.put("6", 6);
		Arr.put("7", 7);
		Arr.put("8", 8);
		Arr.put("9", 9);
		Arr.put("0", 0);
		Brr.put(1, 8);
		Brr.put(2, 7);
		Brr.put(3, 6);
		Brr.put(4, 5);
		Brr.put(5, 4);
		Brr.put(6, 3);
		Brr.put(7, 2);
		Brr.put(8, 10);
		Brr.put(9, 0);
		Brr.put(10, 9);
		Brr.put(11, 8);
		Brr.put(12, 7);
		Brr.put(13, 6);
		Brr.put(14, 5);
		Brr.put(15, 4);
		Brr.put(16, 3);
		Brr.put(17, 2);
		String sKYZF = "abcdefghjklmnprstuvwxyz1234567890";
		String sJYW = "";
		boolean bl = false;
		boolean blKYZF = false;
		if (vin.length() == 17) {
			int iJQS = 0;
			int intTemp = 0;
			try {
				for (int i = 0; i < vin.length(); i++) {
					String c = vin.substring(i, i + 1);
					if (sKYZF.indexOf(c) != -1) {
						blKYZF = true;
						iJQS = iJQS + Arr.get(c) * Brr.get(i + 1);
					} else {
						blKYZF = false;
						break;
					}
				}
				if (blKYZF) {
					intTemp = iJQS % 11;
					if (intTemp == 10) {
						sJYW = "X";
					} else {
						sJYW = intTemp + "";
					}
					if (sJYW.equalsIgnoreCase(vin.substring(8, 9)))
						bl = true;
				} else {
					bl = false;
				}
			} catch (Exception e) {
				bl = false;
			}
		}
		return bl;
	}

	/**
	 * 获取四位随机数
	 * 
	 * @return
	 */
	public static String getAuthCode() {
		char[] arr = new char[4];// 生成四位编码
		char[] chr = "0123456789".toCharArray();
		Random r = new Random();
		int n = chr.length;
		boolean[] used = new boolean[n];
		int j = 0;
		while (true) {
			int index = r.nextInt(n);
			if (used[index] == true)
				continue;
			arr[j] = chr[index];
			used[index] = true;
			j++;
			if (j >= 4)
				break;
		}
		return new String(arr);
	}

	/**
	 * 验证身份证号码
	 * 
	 * @param idcard
	 * @return
	 */
	// public static boolean validateIdCard(String idCard) {
	// Pattern p_idcard_15 = Pattern.compile("^\\d{14}([0-9]|X|x)$");
	// Pattern p_idcard_18 = Pattern.compile("^\\d{17}([0-9]|X|x)$");
	// Matcher matcher15 = p_idcard_15.matcher(idCard);
	// Matcher matcher18 = p_idcard_18.matcher(idCard);
	// return (matcher15.matches() || matcher18.matches());
	// }

	public static boolean validateIdCard(String idCard) {
		Pattern p_idcard_15 = Pattern.compile(
				"^[1-9]\\d{5}(18|19|([23]\\d))\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$");
		Pattern p_idcard_18 = Pattern
				.compile("^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{2}$");
		Matcher matcher15 = p_idcard_15.matcher(idCard);
		Matcher matcher18 = p_idcard_18.matcher(idCard);
		return (matcher15.matches() || matcher18.matches());
	}

	/**
	 * 验证台胞证号码
	 * 
	 * @param idcard
	 * @return
	 */
	public static boolean validateTWIdCard(String idCard) {
		Pattern p_idcard_tw = Pattern.compile("^\\d{10}\\(B\\)$");
		Matcher matcher_tw = p_idcard_tw.matcher(idCard);
		return matcher_tw.matches();
	}

	/**
	 * 验证社会信用代码
	 * 
	 * @param idcard
	 * @return
	 */
	public static boolean validateSocialCreditCode(String creditCard) {
		Pattern p_creditCard = Pattern.compile("^[0-9A-Z]{18}$");
		Matcher matcher_creditCard = p_creditCard.matcher(creditCard);
		return matcher_creditCard.matches();
	}

	/**
	 * 判断是否8-15,包含大小写英文和数字, 也可以有特殊符号.
	 * 
	 * @param password
	 * @return
	 */
	public static boolean validatePassword(String password) {
		Pattern pattern = Pattern.compile("(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[-_@])?[a-zA-Z0-9(-_@)*]{8,15}");
		Matcher matcher = pattern.matcher(password);
		return matcher.matches();
	}

	/**
	 * 判断字符串是否符合手机号码格式
	 * 移动号段:134,135,136,137,138,139,147,150,151,152,157,158,159,170,178,182,183,184,187,188,1705（虚拟运营商移动号段）
	 * 联通号段: 130,131,132,145,155,156,170,171,175,176,185,186,1709（虚拟运营商联通号段）
	 * 电信号段:133,149,153,170,173,177,180,181,189,1700（虚拟运营商电信号段）
	 * 
	 * @param str
	 * @return 待检测的字符串
	 */
	public static boolean validateMobilehone(String mobileNums) {
		Pattern pattern = Pattern.compile("^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$");
		Matcher matcher = pattern.matcher(mobileNums);
		return matcher.matches();
	}

}
