package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOverviewPage {

    private final WebDriver driver;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
    }

//    @Step("Проверка суммы заказа: {expectedTotal}")
    public CheckoutOverviewPage checkTotalPrice(String expectedTotal) {
        String totalPrice = driver.findElement(By.xpath("//div[@class='summary_total_label']")).getText();
        Assertions.assertTrue(totalPrice.contains(expectedTotal),
                "Ожидаемая сумма " + expectedTotal + ", но получилось: " + totalPrice);
        return this;
    }

//    @Step("Нажатие кнопки Finish")
    public void clickButtonFinish() {
        driver.findElement(By.xpath("//button[@data-test='finish']")).click();
    }
}
