package co.com.certification.practiceautomatedtesting.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutOverviewPage extends PageObject {
    public static final Target ITEM_PRICES = Target.the("List of item prices")
            .located(By.cssSelector("div[data-test='inventory-item-price']"));
    public static final Target SUB_TOTAL_LABEL = Target.the("Item total subtotal label")
            .located(By.cssSelector("div[data-test='subtotal-label']"));
    public static final Target FINISH_PURCHASE = Target.the("Finish purchase").located(
            By.cssSelector("button[data-test='finish']"));

}
