package quyentest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import quyentest.base.ValidateHelper;

public class DashboardPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    private By emailInput = By.xpath("//input[@placeholder='Email']");
    private By passwordInput = By.xpath("//input[@placeholder='Password']");
    private By loginBtn = By.xpath("//button[@id='login']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);

    }
    public void SignIn(String email, String password    ) {
        validateHelper.setText(emailInput, email);
        validateHelper.setText(passwordInput, password);
        validateHelper.clickElement(loginBtn);
    }
}
