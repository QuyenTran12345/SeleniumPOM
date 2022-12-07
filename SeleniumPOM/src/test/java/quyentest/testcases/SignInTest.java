package quyentest.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import quyentest.base.ValidateHelper;
import quyentest.pages.SignInPage;

public class SignInTest {
    WebDriver driver;
    private ValidateHelper validateHelper;
    private SignInPage signInPage;
    private By loginBtn = By.id("btn-login");
    private By selectDropdown = By.id("dropdown");
    @Test
    public void abc() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        validateHelper = new ValidateHelper((driver));
        signInPage = new SignInPage(driver);

        driver.get("https://anhtester.com");
        validateHelper.waitForPageLoaded();
        validateHelper.clickElement(loginBtn);
        signInPage.SignIn("anhtester@mailinator", "Demo@123");

        Thread.sleep(2000);
        driver.quit();
    }
}
