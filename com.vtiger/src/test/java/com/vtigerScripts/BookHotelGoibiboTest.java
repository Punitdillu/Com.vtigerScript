package com.vtigerScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookHotelGoibiboTest {
	@Test
	public void ibibo() throws Throwable {
		
		String month_year="April 2022";
		String Entrydate= "5";
		String month_year1="April 2022";
		String exitdate= "7";
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click();
		driver.findElement(By.xpath("//a[text()='Hotels']")).click();
		driver.findElement(By.name("CountryType")).click();
		WebElement wb = driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']"));
		WebDriverWait wait= new WebDriverWait(driver,20);
		driver.findElement(By.xpath("//input[@data-testid='home-autosuggest-input']")).sendKeys("Bengaluru");
		wait.until(ExpectedConditions.elementToBeClickable(wb));
		Thread.sleep(1000);
		Robot r= new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath("//div[text()='Check-in']")).click();
		driver.findElement(By.xpath("//span[text()='"+month_year+"']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='"+Entrydate+"']")).click();
		driver.findElement(By.xpath("//span[text()='"+month_year1+"']/ancestor::div[@class='dcalendar-newstyles__CalenderMonthContainer-sc-1i003by-2 kCupBq']/descendant::span[text()='"+exitdate+"']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).click();
		for(int i=1;i<=3;i++) {
		driver.findElement(By.xpath("//div[@class=\"dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr\" ]/following-sibling::div[2]/div/span[2]")).click();
		}
//		driver.findElement(By.xpath("//div[@class=\"dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr\" ]/following-sibling::div[2]/div/span[2]")).click();
//		driver.findElement(By.xpath("//div[@class=\"dwebCommonstyles__CenteredDivWrap-sc-112ty3f-1 PaxWidgetstyles__ContentItemWrapperDiv-sc-gv3w6r-2 ibYPGm fAmNIr\" ]/following-sibling::div[2]/div/span[2]")).click();
		driver.findElement(By.xpath("//h4[text()='Select']/ancestor::div[@class=\"PaxWidgetstyles__ContentWrapperDiv-sc-gv3w6r-1 gwNJlK\"]/div[4]/div")).click();
		driver.findElement(By.xpath("//li[text()='1']")).click();
		driver.findElement(By.xpath("//h4[text()='Select']/ancestor::div[@class=\"PaxWidgetstyles__ContentWrapperDiv-sc-gv3w6r-1 gwNJlK\"]/div[5]/div")).click();
		driver.findElement(By.xpath("//li[text()='2']")).click();
		driver.findElement(By.xpath("//h4[text()='Select']/ancestor::div[@class=\"PaxWidgetstyles__ContentWrapperDiv-sc-gv3w6r-1 gwNJlK\"]/div[6]/div")).click();
		driver.findElement(By.xpath("//li[text()='3']")).click();
		driver.findElement(By.xpath("//button[text()='Done']")).click();
		driver.findElement(By.xpath("//button[text()='Search Hotels']")).click();
		List<WebElement> wb1 = driver.findElements(By.xpath("//div[@class=\"infinite-scroll-component \"]/div/div/div/div/div/div/div[2]/h4"));
		for (WebElement webElement : wb1) {
			System.out.println(webElement.getText());
			 
		}
		System.out.println("hello");
			driver.quit();
		}
	}
