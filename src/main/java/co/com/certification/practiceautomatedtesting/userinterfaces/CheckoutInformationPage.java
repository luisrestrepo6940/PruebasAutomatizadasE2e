package co.com.certification.practiceautomatedtesting.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CheckoutInformationPage extends PageObject {
    public static final Target FIRST_NAME = Target.the("First name input").located(By.cssSelector(
            "input[data-test='firstName']"));
    public static final Target LAST_NAME = Target.the("Last name input").located(By.cssSelector(
            "input[data-test='lastName']"));
    public static final Target POSTAL_CODE = Target.the("Postal code input").located(By.cssSelector(
            "input[data-test='postalCode']"));
    public static final Target CONTINUE_BUTTON = Target.the("continue button").located(By.cssSelector(
            "input[data-test='continue']"));

}
