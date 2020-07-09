package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

@Generated(value = "src/main/resources/com/company/compTest2.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start", groups = { "default" })
public class compTest2Impl extends ExecutionContext implements compTest2 {

	public final static Path MODEL_PATH = Paths.get("com/company/compTest2.json");

	File file = new File("chromedriver.exe");
	String location = file.getAbsolutePath();
	String merchantApp = SeleniumConstants.MERCHANT_APP;
	Integer acquirerIdCounter = 0;
    int paymentCounter = 0;
	String orderId = null;
	List <PaymentRequest> paymentRequestList = new ArrayList<>();
	WebDriver driver= null;
	WebDriverWait waiter = null;
	static String environment = SeleniumConstants.COMPAY_TEST_ENVIRONMENT;
	SoftAssert softAssertion= new SoftAssert();
	Boolean checkState = false;

	@Override
	public void e_Refund() {
		System.out.println("Executing:e_Refund");
		
	}

	@Override
	public void v_Havale() {
		System.out.println("Executing:v_Havale");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement webElementState = driver.findElement(By.name("Response"));
 		String response = webElementState.getAttribute("value");
 		
 		Assert.assertEquals(response,"Approved");
	}

	@Override
	public void e_initiateState() {
		System.out.println("Executing:e_initiateState");
		
		driver.get("https://test.compaypayment.com/integration/app/admin/viewPaymentLogs");
		driver.findElement(By.name("orderId")).sendKeys(paymentRequestList.get(paymentCounter-1).getPaymentRequestId());
		driver.findElement(By.xpath("//*[@id=\"command\"]/div/div/div/div[1]/div[8]/div/button")).click();
		
		if(!driver.findElements(By.xpath("//*[@id=\"command\"]/div/div/div/div[2]/table/tbody/tr[1]/td[1]")).isEmpty()) {
			driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr/td[1]/a")).click();
		}
	}

	@Override
	public void e_HizliKredi() {
		System.out.println("Executing:e_HizliKredi");
		
		Select dropdownPayment = new Select(driver.findElement(By.name("productType")));
		dropdownPayment.selectByVisibleText("Hızlı Kredi");
		driver.findElement(By.name("submit")).click();
		paymentRequestList.get(paymentCounter-1).setState("CREDIT_INIT");
	}

	@Override
	public void v_MerchantRefund() {
		System.out.println("Executing:v_MerchantRefund");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void e_MerchantState() {
		System.out.println("Executing:e_MerchantState");
	}

	@Override
	public void e_Start() {
		System.out.println("Executing:e_Start");
		driver.get("https://test.compaypayment.com/merchant/app/compayPayment");
	}

	@Override
	public void e_StartNewPaymentAfterRefund() {
		System.out.println("Executing:e_StartNewPaymentAfterRefund");
		driver.get("https://test.compaypayment.com/merchant/app/compayPayment");
	}

	@Override
	public void e_initiateRefund() {
		System.out.println("Executing:e_initiateRefund");
		driver.get("https://test.compaypayment.com/integration/app/searchPayments");
		driver.findElement(By.name("orderId")).sendKeys(paymentRequestList.get(paymentCounter-1).getPaymentRequestId());
		driver.findElement(By.xpath("//*[@id=\"command\"]/div/div/div/div[1]/div[8]/div/button")).click();
		
		if(!driver.findElements(By.xpath("//*[@id=\"command\"]/div/div/div/div[2]/table/tbody/tr[1]/td[1]")).isEmpty()) {
			String state = paymentRequestList.get(paymentCounter-1).getState();
			if(SeleniumTestUtility.nullTrim(state).equals(""))
			{
				WebElement webElementState = driver.findElement(By.xpath("//*[@id=\"command\"]/div/div/div/div[2]/table/tbody/tr/td[6]"));
				state = webElementState.getText();
				paymentRequestList.get(paymentCounter-1).setState(state);
			}
			driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr/td[1]/a")).click();
		}
		
		if(driver.findElements(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div/table[1]/tbody/tr[23]/td[2]/a")).size() > 0)
		{
			if(driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div/table[1]/tbody/tr[23]/td[2]/a")).getText().equals("İade"))
			{
				driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[3]/div/div/div/div/table[1]/tbody/tr[23]/td[2]/a")).click();
				driver.findElement(By.name("refundAmount")).sendKeys("1");
				driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/form/div[6]/button")).click();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void v_MotesPayment() {
		System.out.println("Executing:v_MotesPayment");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void v_Iptal() {
		System.out.println("Executing:v_Iptal");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement webElementState = driver.findElement(By.name("Response"));
 		String response = webElementState.getAttribute("value");
 		Assert.assertEquals(response,"Error");
	
	}

	@Override
	public void v_PanelRefund() {
		System.out.println("Executing:v_PanelRefund");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void v_HizliKredi() {
		System.out.println("Executing:v_HizliKredi");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement webElementState = driver.findElement(By.name("Response"));
 		String response = webElementState.getAttribute("value");
 		
 		Assert.assertEquals(response,"Pending");
	}


	@Override
	public void e_CheckState() {
		System.out.println("Executing:e_CheckState");
		
		checkState = true ;
		
	}

	@Override
	public void v_SeleniumAdmin() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executing:v_SeleniumAdmin");
	}

	@Override
	public void e_Kredi() {
		System.out.println("Executing:e_Kredi");
		Select dropdownPayment = new Select(driver.findElement(By.name("productType")));
		dropdownPayment.selectByVisibleText("Kredi");
		driver.findElement(By.name("submit")).click();
	}

	@Override
	public void v_Refund() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executing:v_Refund");
	}

	@Override
	public void e_Havale() {
		System.out.println("Executing:e_Havale");
		Select dropdownPayment = new Select(driver.findElement(By.name("productType")));
		dropdownPayment.selectByVisibleText("Havale");
		driver.findElement(By.name("submit")).click();
	}

	@Override
	public void v_State() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executing:v_State");
		if(!checkState)
		{
			
		}
	}

	@Override
	public void v_Kredi() {
		System.out.println("Executing:v_Kredi");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement webElementState = driver.findElement(By.name("Response"));
 		String response = webElementState.getAttribute("value");
 		
 		Assert.assertEquals(response,"Approved");
	}

	@Override
	public void e_MerchantRefund() {
		System.out.println("Executing:e_MerchantRefund");
		
		driver.get("https://test.compaypayment.com/merchant/app/compayRefund");
		
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("****");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("*****");
		driver.findElement(By.name("orderId")).clear();
		driver.findElement(By.name("orderId")).sendKeys(paymentRequestList.get(paymentCounter-1).getPaymentRequestId());
		driver.findElement(By.name("orgOrderId")).clear();
		driver.findElement(By.name("orgOrderId")).sendKeys(paymentRequestList.get(paymentCounter-1).getPaymentRequestId());
		
		driver.findElement(By.name("save")).click();
	}

	@Override
	public void e_State() {
		System.out.println("Executing:e_State");
	}

	@Override
	public void v_MotesBank() {
		System.out.println("Executing:v_MotesBank");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void e_MotesBank() {
		System.out.println("Executing:e_MotesBank");
		
		PaymentRequest paymentRequest = new PaymentRequest();
		WebElement webElementOrderId = driver.findElement(By.name("orderId"));
		paymentRequest.setPaymentRequestId(webElementOrderId.getAttribute("value"));
		paymentRequest.setAcquirerId("0");
		paymentRequestList.add(paymentRequest);
		paymentCounter++;
		driver.findElement(By.name("acquirerId")).sendKeys("0");
		driver.findElement(By.name("amount")).clear();
		driver.findElement(By.name("amount")).sendKeys("155");
		
		driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();
		
		driver.findElement(By.name("submit")).click(); //Login To Bank
	}

	@Override
	public void e_DigitalBank() {
		System.out.println("Executing:e_DigitalBank");
		
//		if(acquirerIdCounter == SeleniumConstants.BANK_ACQUIRER_IDS.length) {
//			acquirerIdCounter = 0;
//		}
		driver.get("https://test.compaypayment.com/merchant/app/compayPayment");
		int currentAcquirerId = SeleniumConstants.BANK_ACQUIRER_IDS[acquirerIdCounter];
		CompletePayment(currentAcquirerId);
		acquirerIdCounter++;
		paymentCounter++;
		
	}

	@Override
	public void e_StartNewPaymentAfterStatusChecked() {
		System.out.println("Executing:e_StartNewPaymentAfterStatusChecked");
		
		driver.get("https://test.compaypayment.com/merchant/app/compayPayment");
	}

	@Override
	public void v_MerchantState() {
		System.out.println("Executing:v_MerchantState");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void v_DigitalBank() {
		System.out.println("Executing:v_DigitalBank");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void e_Iptal() {
		System.out.println("Executing:e_Iptal");
		driver.findElement(By.name("cancel_payment")).click();
	}

	@Override
	public void v_Start() {
		System.out.println("Executing:v_Start");
	}

	@Override
	public void e_Login() throws InterruptedException {
		System.out.println("Executing:e_Login");
		
		loginUser(environment,driver);
	}

	@Override
	public void v_PanelState() throws InterruptedException {
		System.out.println("Executing:v_PanelState");
		Thread.sleep(1000);
	}

	@Override
	public void e_StartRefund() {
		System.out.println("Executing:e_StartRefund");
	}
	
	private void CompletePayment(int currentAcquirerId) {
		
		PaymentRequest paymentRequest = new PaymentRequest();
		WebElement webElementOrderId = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[1]"));
		paymentRequest.setPaymentRequestId(webElementOrderId.getAttribute("value")); 
		paymentRequest.setAcquirerId(String.valueOf(currentAcquirerId));
		paymentRequestList.add(paymentRequest);
		if(currentAcquirerId == (0))
		{
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[13]")).sendKeys("0");
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).clear();
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).sendKeys("155");
			driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();
			//driver.findElement(By.name("submit")).click();
	
		} else if(currentAcquirerId == (33))
		{
			
			WebElement webElementCount1 = driver.findElement(By.name("count1"));
			WebElement webElementProdAmount1 = driver.findElement(By.name("amount1"));
			Integer count1 = Integer.parseInt(webElementCount1.getAttribute("value")); 
			Integer prodAmount1 = Integer.parseInt(webElementProdAmount1.getAttribute("value"));
			Integer totalAmount = count1 * prodAmount1;
			
			if(driver.findElements(By.name("count2")).size() != 0 ) {
			
				WebElement webElementCount2 = driver.findElement(By.name("count2"));
				WebElement webElementProdAmount2 = driver.findElement(By.name("amount2"));
				Integer count2 = Integer.parseInt(webElementCount2.getAttribute("value"));
				Integer prodAmount2 = Integer.parseInt(webElementProdAmount2.getAttribute("value"));
				
				totalAmount = count1 * prodAmount1 + count2 * prodAmount2 ;
			}
			
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[13]")).sendKeys("33");
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).clear();
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).sendKeys(totalAmount.toString());
			driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();

		} else
		{			
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[13]")).sendKeys(Integer.toString(currentAcquirerId));
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).clear();
			driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[5]")).sendKeys("155");
			driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();
		}
		
	}

	@org.graphwalker.java.annotation.BeforeExecution
	public void _beforeExecution() {
		System.out.println("Executing: _beforeExecution");
		System.setProperty("webdriver.chrome.driver",location);
		driver= new ChromeDriver();
	}

	@org.graphwalker.java.annotation.AfterExecution
	public void _afterExecution() {
		System.out.println("Executing: _afterExecution");
		driver.quit();
	}
	
	private static void loginUser(String environment, WebDriver driver) throws InterruptedException {

		driver.get(environment + SeleniumConstants.INTEGRATION_APP + "login");

		driver.findElement(By.name("merchantId")).clear();
		driver.findElement(By.name("merchantId")).sendKeys(SeleniumConstants.ADMIN_MERCHANT_ID);
		
		driver.findElement(By.name("username")).clear();
		driver.findElement(By.name("username")).sendKeys(SeleniumConstants.TEST_ENVIRONMENT_USERNAME);
		
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys(SeleniumConstants.TEST_ENVIRONMENT_PASSWORD);

		driver.findElement(By.xpath("/html/body/div/div/form/button")).click();
		
	}
	
}


