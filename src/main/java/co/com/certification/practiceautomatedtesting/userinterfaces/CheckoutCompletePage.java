package co.com.certification.practiceautomatedtesting.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutCompletePage extends PageObject {
    public static final Target THANK_YOU_ORDER = Target.the("Complete header").located(By.cssSelector(
            "h2[data-test='complete-header']"));
}
