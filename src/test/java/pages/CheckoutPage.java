package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private final WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

//    @Step("Заполнение полей: {firstName} {lastName} {zipCode}")
    public CheckoutPage fullInformation(String firstName,String lastName, String zipCode) {
        driver.findElement(By.id("first-name")).sendKeys(firstName);
        driver.findElement(By.id("last-name")).sendKeys(lastName);
        driver.findElement(By.id("postal-code")).sendKeys(zipCode);
        return this;
    }

//    @Step("Нажатие кнопки Continue")
    public CheckoutOverviewPage clickButtonContinue() {
        driver.findElement(By.id("continue")).click();
        return new CheckoutOverviewPage(driver);
    }
}
