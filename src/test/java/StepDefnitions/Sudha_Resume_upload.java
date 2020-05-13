package StepDefnitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Sudha_Resume_upload{
	WebDriver driver=null;
	String projectPath=null;
	Pages.NaukariProfilePage npp;
	String username=null;
	String password = null;
	@Before
	public void setup() {
		projectPath = System.getProperty("user.dir");
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("start-maximized");
		opt.addArguments("--incognito");
		driver = new ChromeDriver(opt);
		npp = new Pages.NaukariProfilePage(driver);
		username = System.getProperty("username");
		password = System.getProperty("password");
	}
	@Test
	public void test_01() throws IOException, InterruptedException{
		driver.get("https://www.naukri.com/mnjuser/profile?id=&altresid");

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		npp.login(username,password);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/span/div/div/div/div/div/div[2]/div[2]/div/div/ul/li[2]/a")).click();
		WebElement updateresume =  driver.findElement(npp.UpdateResume);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", updateresume);
		Thread.sleep(1000);

		Runtime.getRuntime().exec(projectPath+"\\src\\test\\resources\\AutoitFiles\\uploadExecutables\\Sudha_.exe");
		Thread.sleep(10000);
		System.out.println("Resume last updated on :"+driver.findElement(By.xpath("//*[@id=\"lazyAttachCV\"]/div/div/div[2]/div[1]/div[1]/div[1]/div/span")).getText());
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(npp.Mynaukari)).build().perform();
		Thread.sleep(1500);
		driver.findElement(npp.Logout).click();
	}
	@After
	public void teardown() {
		driver.close();
		driver.quit();
		
	}
}
