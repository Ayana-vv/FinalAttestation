package tests.ui;

import jdk.jfr.Description;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.CartPage;
import pages.LoginPage;
import pages.MainPage;

@DisplayName("E2E Покупка товаров")
//@Story("Покупка 3 товаров пользователями standard_user и performance_glitch_user")
//@Owner("Ayana Baazan")
@Tag("UI-тесты")

public class UIE2ETests {
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

    @ParameterizedTest(name = "Пользователь: {0}")
    @ValueSource(strings = {"standard_user", "performance_glitch_user"})
    @DisplayName("Заказ товаров: выбор 3 товаров и их добавление в корзину")
    @Description("Тест полной покупки для пользователей standard_user и performance_glitch_user.")
    @Tags({@Tag("Позитивный"), @Tag("e2e")})
    public void e2ePurchaseTest(String username) {
        String password = "secret_sauce";

        new LoginPage(driver).enterUserName(username).enterPassword(password).clickButtonLogin();
        new MainPage(driver).addToCart("Sauce Labs Backpack").addToCart("Sauce Labs Bolt T-Shirt")
                            .addToCart("Sauce Labs Onesie").goToCart();
        new CartPage(driver).checkCart(3).clickButtonCheckout().fullInformation("Test", "Testov", "9510")
                            .clickButtonContinue().checkTotalPrice("$58.29").clickButtonFinish();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
