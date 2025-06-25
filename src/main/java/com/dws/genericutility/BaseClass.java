package com.dws.genericutility;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.dws.objectrepository.LoginPage;
import com.dws.objectrepository.WelcomePage;

public class BaseClass {
	
	public static WebDriver driver;
	public WelcomePage welcomeP;
	public LoginPage loginP;
	public ExcelUtility excelUtil;
	public JavaUtility javaUtil;
	
	@Parameters("browser")
	@BeforeClass
	public void launchBrowser(@Optional("chrome") String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")) {
			driver=new EdgeDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeMethod
	public void login() throws EncryptedDocumentException, IOException {
		
		excelUtil=new ExcelUtility();
		String url = excelUtil.getStringDataFromExcel("Login", 1, 0);
		
		driver.get(url);
		
		welcomeP=new WelcomePage(driver);
		welcomeP.getLoginLink().click();
		
		loginP=new LoginPage(driver);
		
		String email = excelUtil.getStringDataFromExcel("Login", 1, 1);
		String password = excelUtil.getStringDataFromExcel("Login", 1, 2);
		
		loginP.getEmailTextField().sendKeys(email);;
		loginP.getPasswordTextField().sendKeys(password);;
		loginP.getLoginButton().click();
		
		
	}

}
