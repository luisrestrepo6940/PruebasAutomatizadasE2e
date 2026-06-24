package co.com.certification.practiceautomatedtesting.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {

    public static final Target USER_NAME = Target.the("Username input").located(By.cssSelector(
            "input[data-test='username']"));
    public static final Target PASSWORD = Target.the("password input").located(By.cssSelector(
            "input[data-test='password']"));
    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.cssSelector(
            "input[data-test='login-button']"));
}
