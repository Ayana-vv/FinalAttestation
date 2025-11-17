package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

//    @Step("Добавление товаров в корзину: {productName}")
    public MainPage addToCart(String productName) {
        String id = switch (productName) {
            case "Sauce Labs Backpack" -> "add-to-cart-sauce-labs-backpack";
            case "Sauce Labs Bolt T-Shirt" -> "add-to-cart-sauce-labs-bolt-t-shirt";
            case "Sauce Labs Onesie" -> "add-to-cart-sauce-labs-onesie";
            default -> throw new IllegalArgumentException("Неизвестный товар: " + productName);
        };
        driver.findElement(By.id(id)).click();
        return this;
    }

//    @Step("Переход в корзину")
    public void goToCart() {
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
    }
}
