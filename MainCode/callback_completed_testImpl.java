package com.company;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.annotation.Generated;

import org.graphwalker.core.machine.ExecutionContext;
import org.graphwalker.java.annotation.GraphWalker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

@Generated(value = "src/main/resources/com/company/callback_completed_test.json")
@GraphWalker(value = "random(edge_coverage(100))", start = "v_Start", groups = { "default" })
public class callback_completed_testImpl extends ExecutionContext implements callback_completed_test {

	public final static Path MODEL_PATH = Paths.get("com/company/callback_completed_test.json");
	
	File file = new File("chromedriver.exe");
	String location = file.getAbsolutePath();
	String merchantApp = SeleniumConstants.MERCHANT_APP;
	Integer acquirerIdCounter = 0;
	String orderId = null;
	WebDriver driver= null;
	WebDriverWait waiter = null;
	PaymentRequest paymentRequest = new PaymentRequest();
	static String environment = SeleniumConstants.COMPAY_TEST_ENVIRONMENT;
	String viewPaymentUrl = null;
	SoftAssert softAssertion= new SoftAssert();

	@Override
	public void e_Refund() {
		System.out.println("Executing:e_Refund");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://test.compaypayment.com/merchant/app/compayRefund");
		
		driver.findElement(By.name("name")).clear();
		driver.findElement(By.name("name")).sendKeys("****");
		driver.findElement(By.name("password")).clear();
		driver.findElement(By.name("password")).sendKeys("*****");
		driver.findElement(By.name("orderId")).clear();
		driver.findElement(By.name("orderId")).sendKeys(paymentRequest.getPaymentRequestId());
		driver.findElement(By.name("orgOrderId")).clear();
		driver.findElement(By.name("orgOrderId")).sendKeys(paymentRequest.getPaymentRequestId());
		
		driver.findElement(By.name("save")).click();
	}

	@Override
	public void e_Credit() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Executing:e_Credit");
		Select dropdownPayment = new Select(driver.findElement(By.name("productType")));
		dropdownPayment.selectByVisibleText("Kredi");
		driver.findElement(By.name("submit")).click();
	}

	@Override
	public void e_MobesPayment() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executing:e_MobesPayment");
		driver.get("https://test.compaypayment.com/merchant/app/compayPayment");
	}

	@Override
	public void v_Transfer() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Executing:v_Transfer");
		
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
		
		System.out.println("Executing:v_Refund");
	}

	@Override
	public void v_Credit() {
		System.out.println("Executing:v_Credit");
	
	}

	@Override
	public void v_MobesPayment() {
		System.out.println("Executing:v_MobesPayment");
	}

	@Override
	public void e_Callback() throws InterruptedException {
		System.out.println("Executing:e_Callback");
		
		
		loginUser(environment,driver);
		
		driver.get("https://test.compaypayment.com/integration/app/searchPayments");
		driver.findElement(By.name("orderId")).sendKeys(paymentRequest.getPaymentRequestId());
		driver.findElement(By.xpath("//*[@id=\"command\"]/div/div/div/div[1]/div[8]/div/button")).click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(!driver.findElements(By.xpath("//*[@id=\"command\"]/div/div/div/div[2]/table/tbody/tr[1]/td[1]")).isEmpty()) {
			driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr/td[1]/a")).click();
			driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/table/tbody/tr[22]/td[2]/a")).click();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.get("https://test.compaypayment.com/integration/app/searchPayments");
		driver.findElement(By.name("orderId")).sendKeys(paymentRequest.getPaymentRequestId());
		driver.findElement(By.xpath("//*[@id=\"command\"]/div/div/div/div[1]/div[8]/div/button")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/form/div/div/div/div[2]/table/tbody/tr/td[1]/a")).click();
		
	}

	@Override
	public void e_GoToMobesBank() {
		System.out.println("Executing:e_GoToMobesBank");
		
		WebElement webElementOrderId = driver.findElement(By.name("orderId"));
		this.paymentRequest.setPaymentRequestId(webElementOrderId.getAttribute("value"));
		this.paymentRequest.setAcquirerId("0");
		driver.findElement(By.name("acquirerId")).sendKeys("0");
		driver.findElement(By.name("amount")).clear();
		driver.findElement(By.name("amount")).sendKeys("155");
		
		driver.findElement(By.xpath("//*[@id=\"myForm\"]/input[12]")).click();
		
		driver.findElement(By.name("submit")).click(); //Login To Bank
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void e_GoToDigitalBank() {
		System.out.println("Executing:e_GoToDigitalBank");
		driver.get("https://test.compaypayment.com/merchant/app/compayPayment");
		int currentAcquirerId = SeleniumConstants.BANK_ACQUIRER_IDS[acquirerIdCounter];
		CompletePayment(currentAcquirerId);
		acquirerIdCounter++;
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void e_Complete() {
		System.out.println("Executing:e_Complete");
		if(!driver.findElements(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/table/tbody/tr[23]/td[2]/a")).isEmpty())
		{
			driver.findElement(By.xpath("/html/body/div[2]/div/div[3]/div/div/div/div/table/tbody/tr[23]/td[2]/a")).click();
		}
	}

	@Override
	public void e_Cancel() {
		System.out.println("Executing:e_Cancel");
		driver.findElement(By.name("cancel_payment")).click();
	}

	@Override
	public void v_MobesBank() {
		System.out.println("Executing:v_MobesBank");
	}

	@Override
	public void e_FastCredit() {
		System.out.println("Executing:e_FastCredit");
		Select dropdownPayment = new Select(driver.findElement(By.name("productType")));
		dropdownPayment.selectByVisibleText("Hızlı Kredi");
		driver.findElement(By.name("submit")).click();
		paymentRequest.setState("CREDIT_INIT");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void e_Transfer() {
		System.out.println("Executing:e_Transfer");
		Select dropdownPayment = new Select(driver.findElement(By.name("productType")));
		dropdownPayment.selectByVisibleText("Havale");
		driver.findElement(By.name("submit")).click();
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
	}

	@Override
	public void v_FastCredit() {
		System.out.println("Executing:v_FastCredit");
	}

	@Override
	public void e_CallbackResult() {
		System.out.println("Executing:e_CallbackResult");
	}

	@Override
	public void v_Start() {
		System.out.println("Executing:v_Start");
	}

	@Override
	public void v_Cancel() {
		System.out.println("Executing:v_Cancel");
	}

	@Override
	public void v_Callback() {
		System.out.println("Executing:v_Callback");
	}

	@Override
	public void v_Completed() {
		System.out.println("Executing:v_Completed");
	}

	@Override
	public void v_CallbackResult() {
		System.out.println("Executing:v_CallbackResult");
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
	
	private void CompletePayment(int currentAcquirerId) {
		
			WebElement webElementOrderId = driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div/div/div/div/form/input[1]"));
			this.paymentRequest.setPaymentRequestId(webElementOrderId.getAttribute("value")); 
			this.paymentRequest.setAcquirerId(String.valueOf(currentAcquirerId));
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
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
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
	
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


}
