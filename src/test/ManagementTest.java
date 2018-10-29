// 每次测试前删掉 name = "test" - number = "1111"条，加上一条 id=30的课
package test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import dao.CourseDAO;
public class ManagementTest {
	WebDriver driver;
	@Before
	public void openWikipediaEnglishPage() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/OOAD-Project/login.jsp");
	Assert.assertEquals("Login", driver.getTitle());
	}
	@Test
	public void loginManagement() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login"));
		login.submit();
		Thread.sleep(2000);
		Assert.assertEquals("Course Management", driver.getTitle());
	}
	
	@Test
	public void editCourse() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login"));
		login.submit();
		Thread.sleep(2000);
		Assert.assertEquals("Course Management", driver.getTitle());
		WebElement edit = driver.findElement(By.id("edit2"));
		edit.click();
		Thread.sleep(2000);
		WebElement description = driver.findElement(By.id("courseDescription"));
		description.clear();
		description.sendKeys("modified");
		Thread.sleep(2000);
		WebElement submit = driver.findElement(By.id("submitEdit"));
		submit.click();
		Assert.assertEquals("Course Management", driver.getTitle());
	}
	
	
	@Test
	public void addCourse() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login"));
		login.submit();
		Thread.sleep(2000);
		Assert.assertEquals("Course Management", driver.getTitle());
		WebElement addCourse = driver.findElement(By.id("addCourse"));
		addCourse.click();
		WebElement name = driver.findElement(By.id("name"));
		name.sendKeys("test");
		WebElement number = driver.findElement(By.id("number"));
		number.sendKeys("1111");
		WebElement description = driver.findElement(By.id("description"));
		description.sendKeys("content.");
		WebElement addSubmit = driver.findElement(By.id("addSubmit"));
		addSubmit.click();
		Assert.assertEquals("Course Management", driver.getTitle());
	}
	
	@Test
	public void deleteCourse() throws InterruptedException{
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("gaozheng");
		WebElement password = driver.findElement(By.id("password"));
		password.sendKeys("111111");
		Thread.sleep(2000);
		WebElement login = driver.findElement(By.id("login"));
		login.submit();
		Thread.sleep(2000);
		Assert.assertEquals("Course Management", driver.getTitle());
		WebElement delete = driver.findElement(By.id("delete30"));
		delete.click();
		Thread.sleep(2000);
		Assert.assertEquals("Course Management", driver.getTitle());
	}
	
	@After
	public void closePage(){
	driver.quit();
	}
}
