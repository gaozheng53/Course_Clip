package test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class ManageCommentTest {
WebDriver driver;
//add comment which comment_id = 1 for delete1
//add comment which comment_id = 2,3,4 for edit
@Before
public void testCourseClip() throws InterruptedException{
	System.setProperty("webdriver.chrome.driver","chromedriver");
	driver = new ChromeDriver();
	driver.get("http://localhost:8080/OOAD-Project/login.jsp");
	Assert.assertEquals("Login", driver.getTitle());
}


@Test
public void testDeleteComment() throws InterruptedException{
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement deleteId = driver.findElement(By.id("delete1"));
	deleteId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@Test
public void testEditContentAddFile() throws InterruptedException{	
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement editId = driver.findElement(By.id("edit2"));
	editId.click();
	Thread.sleep(3000);
	Assert.assertEquals("Edit Comment", driver.getTitle());
	WebElement editcontent = driver.findElement(By.id("commentcontent"));
	editcontent.clear();
	Thread.sleep(3000);
	editcontent.sendKeys("This is edited comment");
	Thread.sleep(3000);
	WebElement file = driver.findElement(By.xpath("//input[@type='file']"));
	file.sendKeys("/Users/shengyidan/Downloads/dress.jpeg");
	Thread.sleep(3000);
	WebElement submitbutton = driver.findElement(By.id("submitbutton"));	
	submitbutton.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@Test
public void testEditContentDeleteFile() throws InterruptedException{
	
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement editId = driver.findElement(By.id("edit3"));
	editId.click();
	Thread.sleep(3000);
	Assert.assertEquals("Edit Comment", driver.getTitle());
	WebElement editcontent = driver.findElement(By.id("commentcontent"));
	editcontent.clear();
	Thread.sleep(3000);
	editcontent.sendKeys("This is edited comment2");	
	Thread.sleep(3000);
	WebElement clear = driver.findElement(By.id("clearComment"));	
	clear.click();
	Thread.sleep(3000);
	WebElement submitbutton = driver.findElement(By.id("submitbutton"));	
	submitbutton.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@Test
public void testDeleteContentDeleteFile() throws InterruptedException{	
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
	WebElement userId = driver.findElement(By.id("user2"));
	Thread.sleep(3000);
	userId.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
	WebElement editId = driver.findElement(By.id("edit4"));
	editId.click();
	Thread.sleep(3000);
	Assert.assertEquals("Edit Comment", driver.getTitle());
	WebElement editcontent = driver.findElement(By.id("commentcontent"));
	editcontent.clear();
	Thread.sleep(3000);
	editcontent.sendKeys("");	
	Thread.sleep(3000);
	WebElement clear = driver.findElement(By.id("clearComment"));	
	clear.click();
	Thread.sleep(3000);
	WebElement submitbutton = driver.findElement(By.id("submitbutton"));	
	submitbutton.click();
	Thread.sleep(3000);
	Assert.assertEquals("User Profile", driver.getTitle());
}

@After
public void closePage(){
	driver.quit();
}
}