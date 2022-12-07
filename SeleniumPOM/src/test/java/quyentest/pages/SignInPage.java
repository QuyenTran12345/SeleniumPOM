package quyentest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import quyentest.base.ValidateHelper;

public class SignInPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By emailInput = By.xpath("//input[@placeholder='Email']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By loginSubmitBtn = By.xpath("//button[@id='login']");

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);

    }
    public void SignIn(String email, String password) {
        validateHelper.waitForPageLoaded();
        validateHelper.setText(emailInput, email);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(loginSubmitBtn);
    }
}
