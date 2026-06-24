package co.com.certification.practiceautomatedtesting.tasks;

import co.com.certification.practiceautomatedtesting.interactions.Click;
import co.com.certification.practiceautomatedtesting.userinterfaces.CartPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class BeginCheckout implements Task {

    @Override
    @Step("{0} the user should see products added to the shopping cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(CartPage.CHECKOUT_BUTTON));
    }

    public static BeginCheckout now() {
        return instrumented(BeginCheckout.class);
    }
}
