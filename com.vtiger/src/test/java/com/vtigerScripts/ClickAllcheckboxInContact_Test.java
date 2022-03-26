package com.vtigerScripts;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickAllcheckboxInContact_Test {
	@Test
	
	public  void clickAll() {
		int count=0;
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("root");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		List<WebElement> wb = driver.findElements(By.xpath("//tr[@bgcolor=\"white\"]/descendant::input[@type=\"checkbox\"]"));
		for (WebElement webElement : wb) {
			
			webElement.click();
			
		}
		 List<WebElement> wb1 = driver.findElements(By.xpath("//table[@class=\"lvt small\"]"));
		 for (WebElement webElement : wb1) {
			
			 System.out.println(webElement.getText()+"   ");
			 count++;
			 System.out.println(count);

		}

	}

}
