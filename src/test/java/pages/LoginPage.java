package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

//    @Step("Ввод логина: {username}")
    public LoginPage enterUserName(String username) {
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys(username);
        return this;
    }

//    @Step("Ввод пароля")
    public LoginPage enterPassword(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
        return this;
    }

//    @Step("Нажатие кнопки Login")
    public LoginPage clickButtonLogin() {
        driver.findElement(By.xpath("//input[@id='login-button']")).click();
        return this;
    }
}
