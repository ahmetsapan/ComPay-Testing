package com.company;

public class SeleniumCodes {

}

package com.compay.selenium.main;

import java.io.File;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.compay.selenium.utility.PaymentState;
import com.compay.selenium.utility.SeleniumTestConstants;
import com.compay.selenium.utility.SeleniumTestUtility;

public class TestStarter {

	public static void main(String[] args) throws InterruptedException {
		
		File file = new File("chromedriver.exe");
		String location = file.getAbsolutePath();
		
		startSmokeTest(location);
		
	}

	private static void startSmokeTest(String location) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", location);
		WebDriver driver = new ChromeDriver();
		
		long waitResponseTime = 0;
		boolean isAdmin = true;
		String environment = "", integrationApp = "", merchantApp = "";
		
		waitResponseTime = SeleniumTestConstants.DEFAULT_WAIT_TIME_IN_SECONDS;
		environment = SeleniumTestConstants.COMPAY_TEST_ENVIRONMENT;
		integrationApp = SeleniumTestConstants.INTEGRATION_APP;
		merchantApp = SeleniumTestConstants.MERCHANT_APP;
		
		String paymentRequestId = "";
		
		driver.manage().timeouts().pageLoadTimeout(waitResponseTime, TimeUnit.SECONDS);
		
		for (int currentAcquirerId = SeleniumTestConstants.BANK_ACQUIRER_IDS[0], counter = 0; counter < SeleniumTestConstants.BANK_ACQUIRER_IDS.length; ++counter) {
		
			currentAcquirerId = SeleniumTestConstants.BANK_ACQUIRER_IDS[counter];
			
			paymentRequestId = paymentTest(currentAcquirerId, environment, merchantApp, driver);
			if(counter == 0 )
			{
				refundTest(isAdmin, paymentRequestId, environment, integrationApp, driver);
			}
		}
		
		driver.close();
		
	}

	private static String paymentTest(int currentAcquirerId, String environment, String app, WebDriver driver) {
		
		String paymentRequestId = "";
		String orderId = "";
		
		try {
			
			driver.get(environment + app + "compayPayment");
			
			// For ComPay Bank (COMPLETED)
			if(currentAcquirerId == (0)) {
				
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[1]")).sendKeys(Keys.CONTROL+"a");
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[1]")).sendKeys(Keys.CONTROL+"c");
				driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[13]")).sendKeys("0");
				driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();
				driver.findElement(By.name("submit")).click();
				
				Thread.sleep(3000);
				
				paymentRequestId = driver.findElement(By.xpath("/html/body/input[12]")).getAttribute("value").trim();
				
				String response = driver.findElement(By.name("acqResponseCode")).getAttribute("value").trim();
				
				if(!response.equals(SeleniumTestConstants.COMPAY_BANK_APPROVE_STATUS)) {
					
					System.out.println("Payment has not completed for paymentRequestId: " + paymentRequestId
							+ " acquirerId: " + currentAcquirerId + " Bank name: " + SeleniumTestUtility.getAcquirerBankName(currentAcquirerId));
				}
				
			}
			
			else {
				
				orderId = driver.findElement(By.name("orderId")).getAttribute("value").trim();
				
				// For VakıfPay (TOKEN_SUCCESS)
				if(currentAcquirerId == (33)) {
					
					WebElement webElementCount1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[44]"));
					WebElement webElementProdAmount1 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[45]"));
					Integer count1 = Integer.parseInt(webElementCount1.getAttribute("value")); 
					Integer prodAmount1 = Integer.parseInt(webElementProdAmount1.getAttribute("value"));
					Integer totalAmount = count1 * prodAmount1;
					
					if(driver.findElements(By.name("count2")).size() != 0 ) {
					
						WebElement webElementCount2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[50]"));
						WebElement webElementProdAmount2 = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[51]"));
						Integer count2 = Integer.parseInt(webElementCount2.getAttribute("value"));
						Integer prodAmount2 = Integer.parseInt(webElementProdAmount2.getAttribute("value"));
						
						totalAmount = count1 * prodAmount1 + count2 * prodAmount2 ;
					}
					
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[13]")).sendKeys("33");
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).clear();
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).sendKeys(totalAmount.toString());
					driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();
					Thread.sleep(10000);
	
				}
				
				// Other Banks (TOKEN_SUCCESS)
				else {			
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[13]")).sendKeys(Integer.toString(currentAcquirerId));
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).clear();
					driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).sendKeys("155");
					driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();
					Thread.sleep(10000);
				}
			/*
				loginUser(environment, driver);
				
				// Open searchPayments page to get paymentRequestId using orderId
				driver.get(environment + SeleniumTestConstants.INTEGRATION_APP + "searchPayments");
				
				driver.findElement(By.name("orderId")).sendKeys(orderId);
				driver.findElement(By.name("search")).click();
				
				if(!driver.findElements(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr/td[1]")).isEmpty()) {
					
					paymentRequestId = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr[1]/td[1]/a")).getText().trim();
					
				}
				else {
					
					System.out.println("Payment has not completed for paymentRequestId: " + paymentRequestId
							+ " acquirerId: " + currentAcquirerId + " Bank name: " + SeleniumTestUtility.getAcquirerBankName(currentAcquirerId));
				}
				*/
			}
			
			
		
		}
		catch(Exception e) {
			
			System.out.println(e.getMessage());
		}
		
		return paymentRequestId;
		
	}

	private static void refundTest(boolean isAdmin, String paymentRequestId, String environment, String app, WebDriver driver) throws InterruptedException {

		try {
			
			loginUser(environment, driver);
			
			if(isAdmin) {
				
				// Open searchPayments page to search for payment using paymentRequestId
				driver.get(environment + app + "searchPayments");
				
				driver.findElement(By.name("paymentRequestId")).sendKeys(paymentRequestId);
				driver.findElement(By.name("search")).click();
				
				// Check if database has returned payment entry for paymentRequestId
				if(!driver.findElements(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr/td[1]")).isEmpty()) {
					
					// Open viewPaymentDetails page for more detailed comparisons
					driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr/td[1]/a")).click();
					
					String statusFromPage = driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/table/tbody/tr[5]/td[2]")).getText().trim();
					
					// Check paymentState of payment, if not TOKEN_SUCCESS, UPDATED_BY_BANK or COMPLETED; close program
					if(SeleniumTestUtility.compareString(statusFromPage, PaymentState.TOKEN_SUCCESS.toString())
							|| SeleniumTestUtility.compareString(statusFromPage, PaymentState.COMPLETED.toString())
							|| SeleniumTestUtility.compareString(statusFromPage, PaymentState.UPDATED_BY_BANK.toString())) {
						
						// If payment is completed, try to partial refund
						if(SeleniumTestUtility.compareString(statusFromPage, PaymentState.COMPLETED.toString())){
							
							driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/table/tbody/tr[23]/td[2]/a")).click();
							
							BigDecimal balance, newBalance, divisor, ceil, floor;
							
							WebElement balanceElement = driver.findElement(By.name("balance"));
							
							balance = new BigDecimal(balanceElement.getAttribute("value"));
							divisor = new BigDecimal("2");
							
							ceil = balance.divide(divisor, 2, RoundingMode.CEILING);
							floor = balance.divide(divisor, 2, RoundingMode.FLOOR);
							
							if(balance.compareTo(BigDecimal.ZERO) == 0) {
								System.out.println("Payment is already refunded, current balance: "
										+ balance.toString());
								
								//driver.quit();
							}
	
							// Refund half of the balance
							driver.findElement(By.name("refundAmount")).sendKeys(ceil.toString());
							driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/form/div[6]/button")).click();
							
							driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/table/tbody/tr[23]/td[2]/a")).click();
							
							balanceElement = driver.findElement(By.name("balance"));
							
							newBalance = new BigDecimal(balanceElement.getAttribute("value"));
							
							// Check balance if correct amount of partial refund has been made
							if(!(newBalance.compareTo(floor) == 0)) {
								System.out.println("Refund operation has failed. Expected balance: " 
										+ balance.subtract(ceil).toString() + ", current balance: "
										+ newBalance.toString());
								
								//driver.quit();
							}
							
							
							// Refund the other half of balance
							driver.findElement(By.name("refundAmount")).sendKeys(floor.toString());
							driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/form/div[6]/button")).click();
							
							newBalance = new BigDecimal(driver.findElement(By.name("balance")).getText());
							
							// Check balance if correct amount of partial refund has been made
							if(!(newBalance.compareTo(BigDecimal.ZERO) == 0)) {
								System.out.println("Refund operation has failed. Expected balance: " 
										+ newBalance.subtract(floor).toString() + ", current balance: "
										+ newBalance.toString());
								
								//driver.quit();
							}
							
						}
						
					}
					
					else {
						System.out.println("Payment state for paymentRequestId:" + paymentRequestId + " is not expected"
								+ "(Expected states were: " + PaymentState.TOKEN_SUCCESS.toString() + " or " + PaymentState.COMPLETED.toString() + ") "
								+ "statusFromPage: " + statusFromPage);
						
						//driver.quit();
					}
				}
				
				else {
					System.out.println("Payment not found for paymentRequestId:" + paymentRequestId);
					
					//driver.quit();
				}
				
			}
			
			System.out.println("Refund operation (using two partial refund for based on current balance) for payment with paymentRequestId: " 
					+ paymentRequestId + " has completed successfully");
			
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

	private static void loginUser(String environment, WebDriver driver) throws InterruptedException {

		driver.get(environment + SeleniumTestConstants.INTEGRATION_APP + "login");

		driver.findElement(By.name("merchantId")).clear();
		driver.findElement(By.name("merchantId")).sendKeys(SeleniumTestConstants.ADMIN_MERCHANT_ID);
		
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(SeleniumTestConstants.TEST_ENVIRONMENT_USERNAME);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(SeleniumTestConstants.TEST_ENVIRONMENT_PASSWORD);

		driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
		
	}
	
}