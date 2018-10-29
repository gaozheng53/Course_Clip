package test;

import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class SubscribeTest{
	WebDriver driver;
	@Before
	public void openWikipediaEnglishPage() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://localhost:8080/OOAD-Project/login.jsp");
		Assert.assertEquals("Login", driver.getTitle());
	}
	@Test
	public void subscribe() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("xiaohuang");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Thread.sleep(2000);
		Assert.assertEquals("Homepage", driver.getTitle());
		WebElement OOADcourse = driver.findElement(By.id("course1"));
		Thread.sleep(500);
		OOADcourse.click();
		Thread.sleep(500);
		Assert.assertEquals("Course Detail", driver.getTitle());
		Thread.sleep(500);
		WebElement sub = driver.findElement(By.id("subscribe"));
		Thread.sleep(500);
		sub.click();
		Thread.sleep(500);
		Assert.assertEquals("Course Detail", driver.getTitle());
		Thread.sleep(500);
		String submes = driver.findElement(By.id("alertm")).getText();
		Thread.sleep(500);
		Assert.assertEquals("Subscribe Success!", submes);
		Thread.sleep(500);
	}//每次重启test前要删库！！！！！
	@Test
	public void mutisub() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("xiaohuang");
		Thread.sleep(2000);
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login"));
		login.click();
		Thread.sleep(2000);
		Assert.assertEquals("Homepage", driver.getTitle());
		WebElement OOADcourse = driver.findElement(By.id("course1"));
		Thread.sleep(500);
		OOADcourse.click();
		Thread.sleep(500);
		Assert.assertEquals("Course Detail", driver.getTitle());
		Thread.sleep(500);
		WebElement sub = driver.findElement(By.id("subscribe"));
		Thread.sleep(500);
		sub.click();
		Thread.sleep(500);
		Assert.assertEquals("Course Detail", driver.getTitle());
		Thread.sleep(500);
		String submes = driver.findElement(By.id("alertm")).getText();
		Thread.sleep(500);
		Assert.assertEquals("You can not subscribe one course twice.", submes);
		Thread.sleep(500);
	}//每次重启test前要删库！！！！！
	
	
	@After
	public void closePage(){
		driver.quit();
	}
}
