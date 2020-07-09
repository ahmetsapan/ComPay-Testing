package com.company;

public class SeleniumTestUtility {

	public static String nullTrim(String str) {
		
		if (str == null) {
			str = "";
		}
	
		return str.trim();		
	}
	
	public static boolean compareString(String str, String str2) {
		
		str = nullTrim(str);
		
		str2 = nullTrim(str2);
		
		if("".equals(str)) {
			return false;
		}
		else if(str2.equals(str)) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static String getAcquirerBankName(int acquirerId) {
		
		String bankName = null;
		
		switch(acquirerId) {
		
		case 0:
			bankName = "COMPAY";
			break;
		case 1:
			bankName = "AKBANK_DIREKT";
			break;
		case 2:
			bankName = "FASTPAY";
			break;
		case 3:
			bankName = "VAKIFBANK";
			break;
		case 4:
			bankName = "INGBANK";
			break;
		case 5:
			bankName = "FINANSBANK";
			break;
		case 6:
			bankName = "ZIRAAT_KATILIM";
			break;
		case 7:
			bankName = "KUVEYTTURK";
			break;
		case 8:
			bankName = "ALBARAKA";
			break;
		case 9:
			bankName = "FIBABANKA";
			break;
		case 10:
			bankName = "DENIZBANK";
			break;
		case 11:
			bankName = "AKTIFBANK";
			break;
		case 33:
			bankName = "VAKIFPAY";
			break;
		case 16:
			bankName = "ISBANK";
			break;
		case 14:
			bankName = "BURGANBANK";
			break;
		case 13:
			bankName = "VAKIF_KATILIM";
			break;
		default:
			bankName = "Banka bulunamadi.";
			break;
		}
		
		return bankName;
	}
	
}