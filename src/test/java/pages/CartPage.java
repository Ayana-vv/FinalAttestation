package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private final WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

//    @Step("Проверка, что в корзине {count} товара(ов)")
    public CartPage checkCart(int count) {
        int actualCount = driver.findElements(By.xpath("//div[@class='cart_item']")).size();
        Assertions.assertEquals(count, actualCount, "Неверное количество товаров в корзине");
        return this;
    }

//    @Step("Нажатие кнопки Checkout")
    public CheckoutPage clickButtonCheckout() {
        driver.findElement(By.xpath("//button[@id='checkout']")).click();
        return new CheckoutPage(driver);
    }
}
