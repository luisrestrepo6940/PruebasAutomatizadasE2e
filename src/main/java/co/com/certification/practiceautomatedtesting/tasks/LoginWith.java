package co.com.certification.practiceautomatedtesting.tasks;

import co.com.certification.practiceautomatedtesting.exceptions.BaseException;
import co.com.certification.practiceautomatedtesting.interactions.Enter;
import co.com.certification.practiceautomatedtesting.interactions.Click;
import co.com.certification.practiceautomatedtesting.questions.IsApplicationAccessible;
import co.com.certification.practiceautomatedtesting.userinterfaces.LoginPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.certification.practiceautomatedtesting.utils.Constants.PRODUCTS;
import static net.serenitybdd.screenplay.Tasks.instrumented;


@AllArgsConstructor
public class LoginWith implements Task {
    private final String username;
    private final String password;
    private static final String ACCESS_ERROR_MESSAGE = "ERROR CRITICO: EL INICIO DE SESION FALLO. NO FUE POSIBLE ACCEDER A LA PANTALLA DE %s";

    @Step("{0} the user logs in with username '#username' and password")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(username, LoginPage.USER_NAME),
                Enter.theValue(password, LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN_BUTTON)
        );
        validateApplicationAccess(actor);
    }

    private void validateApplicationAccess(Actor actor) {
        String currentAccess = actor.asksFor(IsApplicationAccessible.isAccessible());
        if (!currentAccess.equals(PRODUCTS)) {
            throw new BaseException(ACCESS_ERROR_MESSAGE.formatted(PRODUCTS));
        }
    }

    public static LoginWith authenticating(String username, String password) {
        return instrumented(LoginWith.class, username, password);
    }
}
