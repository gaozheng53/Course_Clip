package test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class PostCommentTest {
WebDriver driver;
@Before
public void testCourseClip() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/OOAD-Project/login.jsp");
	Assert.assertEquals("Login", driver.getTitle());
}


@Test
public void testPostEmptyComment() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(3000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(3000);
	WebElement login = driver.findElement(By.id("login"));
	login.submit();
	Thread.sleep(3000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(3000);
	OOADcourse.click();
	Thread.sleep(3000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement comment = driver.findElement(By.id("contentText"));
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(3000);
	String commenttest = "";
	comment.sendKeys(commenttest);
	submitbutton.click();
	Thread.sleep(3000);
	Alert alert = driver.switchTo().alert();
	String alertText = alert.getText();
	Thread.sleep(2000);
	Assert.assertEquals("Please enter comment content!", alertText);
}

@Test
public void testPostComment() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(3000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(3000);
	WebElement login = driver.findElement(By.id("login"));
	login.submit();
	Thread.sleep(3000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(3000);
	OOADcourse.click();
	Thread.sleep(3000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement comment = driver.findElement(By.id("contentText"));
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(3000);
	String commenttest = "This is a comment";
	comment.sendKeys(commenttest);
	submitbutton.click();
	Thread.sleep(3000);
	Assert.assertEquals("Course Detail", driver.getTitle());
}

@Test
public void testPostFile() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(3000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(3000);
	WebElement login = driver.findElement(By.id("login"));
	login.submit();
	Thread.sleep(3000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(3000);
	OOADcourse.click();
	Thread.sleep(3000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
	file.sendKeys("/Users/shengyidan/Downloads/cat.jpg");
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(3000);
	submitbutton.click();
	Thread.sleep(3000);
	Assert.assertEquals("Course Detail", driver.getTitle());
}

@Test
public void testPostCommentFile() throws InterruptedException{
	WebElement username = driver.findElement(By.id("username"));
	username.sendKeys("xiaohuang");
	Thread.sleep(3000);
	WebElement password = driver.findElement(By.id("password"));
	password.sendKeys("111111");
	Thread.sleep(3000);
	WebElement login = driver.findElement(By.id("login"));
	login.submit();
	Thread.sleep(3000);
	Assert.assertEquals("Homepage", driver.getTitle());
	WebElement OOADcourse = driver.findElement(By.id("course1"));
	Thread.sleep(3000);
	OOADcourse.click();
	Thread.sleep(3000);
	Assert.assertEquals("Course Detail", driver.getTitle());
	WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
	file.sendKeys("/Users/shengyidan/Downloads/dog.jpg");
	WebElement comment = driver.findElement(By.id("contentText"));
	Thread.sleep(3000);
	String commenttest = "This is a comment with file";
	comment.sendKeys(commenttest);
	WebElement submitbutton = driver.findElement(By.id("postcomment"));
	Thread.sleep(3000);
	submitbutton.click();
	Thread.sleep(3000);
	Assert.assertEquals("Course Detail", driver.getTitle());
}

@After
public void closePage(){
	driver.quit();
}
}