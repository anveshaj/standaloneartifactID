package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NaukariProfilePage {
	WebDriver driver = null;
	public By loginButton = By.xpath("//*[@id=\"login_Layer\"]/div");
//	By username = By.xpath("//*[@id=\"usernameField\"]");
	By username = By.id("usernameField");
	By password = By.xpath("//*[@id=\"passwordField\"]");
	By signIn = By.xpath("//*[@id=\"loginForm\"]/div[3]/div[3]/div/button[1]");
	public	By resumeheadline = By.xpath("/html/body/div[2]/div/div/span/div/div/div/div/div/div[2]/div[2]/div/div/ul/li[3]/span");
	public	By rsumeedit = By.xpath("/html/body/div[2]/div/div[1]/span/div/div/div/div/div/div[2]/div[3]/div[2]/div/div/div/div[1]/span[2]");
	public By displayedemail = By.xpath("//*[@id=\"root\"]/div/div[1]/span/div/div/div/div/div/div[1]/div[1]/div/div[1]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/span[2]");
	public By Mynaukari= By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/a/div[2]") ;
	public By Logout = By.xpath("/html/body/div[1]/div/div/ul[2]/li[2]/div/ul[2]/li[5]/a");
	public By UpdateResume = By.id("attachCV");
	

	public NaukariProfilePage(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	//chandu.siddhapuram@gmail.com
	//Chandu@55
	public void login(String usrname, String pswd) {
		driver.findElement(username).sendKeys(usrname);
		driver.findElement(password).sendKeys(pswd);
		driver.findElement(signIn).click();
	}
	public void clickonResumeHradline() {
		driver.findElement(resumeheadline).click();
	}
}
