package co.com.certification.practiceautomatedtesting.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;


public class ProductsPage extends PageObject {
    public static final Target PRODUCTS_TITLE = Target.the("Products tittle").located(By.cssSelector(
            "span[data-test='title']"));
    public static final Target SHOPPING_CART = Target.the("Shopping cart").located(By.cssSelector(
            "a[data-test='shopping-cart-link']"));

    public static final Target ADD_TO_CART = Target.the("Add product to the shopping cart: {0}")
            .locatedBy("css:button[data-test='add-to-cart-{0}']");
    public static final Target PRODUCT_NAME = Target.the("Product added to cart: {0}")
            .locatedBy("(//div[@data-test='inventory-item-name'])[{0}]");
}
