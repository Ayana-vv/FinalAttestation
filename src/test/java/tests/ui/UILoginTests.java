package tests.ui;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Авторизация")
//@Story("Проверка авторизации пользователей")
//@Owner("Ayana Baazan")
@Tag("UI-тесты")

public class UILoginTests {

    WebDriver driver;
    public static final String baseUrl = "https://www.saucedemo.com/";

    @BeforeEach
    public void setUp() {
        FirefoxOptions options = new FirefoxOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new FirefoxDriver(options);
        driver.manage().window().setPosition(new Point(200, 0));
        driver.get(baseUrl);
    }

    @Test
    @DisplayName("Успешная авторизация пользователя")
    public void successfulLoginTest() {
        String username = "standard_user";
        String password = "secret_sauce";

        new LoginPage(driver).enterUserName(username).enterPassword(password).clickButtonLogin();
        assertTrue(driver.getCurrentUrl().endsWith("/inventory.html"),
                "Ожидали /inventory.html, но перешли на " + driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Авторизация заблокированного пользователя")
    public void blockedUserLoginTest() {
        String username = "locked_out_user";
        String password = "secret_sauce";

        new LoginPage(driver).enterUserName(username).enterPassword(password).clickButtonLogin();

        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        assertEquals("Epic sadface: Sorry, this user has been locked out.", errorMessage, "Сообщение об ошибке не совпадает.");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
