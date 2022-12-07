package quyentest.base;

import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.function.Predicate;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private final int timeoutWaitForPageLoaded = 20;
    JavascriptExecutor js;
    public ValidateHelper(WebDriver driver) // hamf build
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        js = (JavascriptExecutor) driver;
    }

    public void setText(By element, String value)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }

    public void clickElement(By element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
        // click cuar js
//        js.executeScript("args[0].click[0]", driver.findElement(element));
    }

    public void selectOptionByText(By element, String text)
    {
        // Chuyen tu doi tuong By sang WebElement thi them driver.findElement
        Select select = new Select(driver.findElement(element));
        select.selectByVisibleText(text);
    }

    public void selectOptionByValue(By element, String value)
    {
        Select select = new Select(driver.findElement(element));
        select.selectByValue(value);
    }

   public void waitForPageLoaded()
   {
       ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
           public Boolean apply(WebDriver driver) {
               return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
           }
       };
       try {
           WebDriverWait wait1 = new WebDriverWait(driver, timeoutWaitForPageLoaded);
           wait1.until(expectation);
       } catch (Throwable error) {
           Assert.fail("Time out waiting for Page Load request");
       }
   }
}
