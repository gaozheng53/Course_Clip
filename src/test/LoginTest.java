package test;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
public class LoginTest {
WebDriver driver;
@Before
public void openWikipediaEnglishPage() throws InterruptedException{
System.setProperty("webdriver.chrome.driver","chromedriver");
driver = new ChromeDriver();
driver.get("http://localhost:8080/OOAD-Project/login.jsp");
Assert.assertEquals("Login", driver.getTitle());
}
@Test
public void usernameBox() throws InterruptedException{
WebElement username = driver.findElement(By.id("username"));
username.sendKeys("gaozheng");
Thread.sleep(5000);
WebElement password = driver.findElement(By.id("password"));
password.sendKeys("111111");
Thread.sleep(5000);
WebElement login = driver.findElement(By.id("login"));
login.submit();
Thread.sleep(5000);
Assert.assertEquals("Course Management", driver.getTitle());
}
@After
public void closePage(){
driver.quit();
}
}
