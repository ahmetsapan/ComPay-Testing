package com.company;

public final class SeleniumConstants {

	public static final long DEFAULT_WAIT_TIME_IN_SECONDS = 4;
	
	public static final String ADMIN_MERCHANT_ID = "999!";
	
	public static final String TEST_ENVIRONMENT_USERNAME = "seleniumtestadmin";
	public static final String TEST_ENVIRONMENT_PASSWORD = "password";
	
	public static final String COMPAY_LOCAL_ENVIRONMENT = "http://localhost:8080";
	public static final String COMPAY_TEST_ENVIRONMENT = "https://test.compaypayment.com";
	public static final String COMPAY_PROD_ENVIRONMENT = "https://www.compaypayment.com";
	
	public static final String MERCHANT_APP = "/merchant/app/";
	public static final String INTEGRATION_APP = "/integration/app/";
	
	public static final int[] BANK_ACQUIRER_IDS = { 7 , 2, 11, 2, 13, 33, 3, 16 }; //, 1, 2,11, 13, 14, 16, 33
	
	public static final String COMPAY_BANK_APPROVE_STATUS = "00";
	
}
