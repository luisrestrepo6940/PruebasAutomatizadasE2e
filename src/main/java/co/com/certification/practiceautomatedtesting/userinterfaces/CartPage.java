package co.com.certification.practiceautomatedtesting.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CartPage extends PageObject {
    public static final Target QUANTITY_PRODUCTS = Target.the("Quantity products").located(
            By.cssSelector("span[data-test='shopping-cart-badge']"));
    public static final Target PRODUCT_TITLE_IN_CART = Target.the("Product in the shopping cart: {0}")
            .locatedBy("//div[@data-test='inventory-item-name' and normalize-space(text())='{0}']");
    public static final Target CHECKOUT_BUTTON = Target.the("Checkout button").located(
            By.cssSelector("button[data-test='checkout']"));
}
