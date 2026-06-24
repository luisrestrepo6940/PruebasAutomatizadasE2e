package co.com.certification.practiceautomatedtesting.tasks;

import co.com.certification.practiceautomatedtesting.exceptions.BaseException;
import co.com.certification.practiceautomatedtesting.interactions.Click;
import co.com.certification.practiceautomatedtesting.questions.SubtotalPrice;
import co.com.certification.practiceautomatedtesting.questions.TotalProductsPrice;
import co.com.certification.practiceautomatedtesting.userinterfaces.CheckoutOverviewPage;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class NavigateToCheckout implements Task {
    private static final String CHECKOUT_ERROR_MESSAGE = "ERROR EN CHECKOUT: LA SUMA CALCULADA DE LOS PRODUCTOS (%s) ".concat(
            "NO COINCIDE CON EL SUBTOTAL DE LA PANTALLA (%s).");

    @Override
    @Step("{0} completes the checkout process validating the subtotal")
    public <T extends Actor> void performAs(T actor) {
        double calculatedSum = actor.asksFor(TotalProductsPrice.calculated());
        double displayedSubtotal = actor.asksFor(SubtotalPrice.displayed());
        if (calculatedSum != displayedSubtotal) {
            throw new BaseException(CHECKOUT_ERROR_MESSAGE.formatted(calculatedSum, displayedSubtotal));
        }
        actor.attemptsTo(Click.on(CheckoutOverviewPage.FINISH_PURCHASE));
    }

    public static NavigateToCheckout overview() {
        return instrumented(NavigateToCheckout.class);
    }
}
