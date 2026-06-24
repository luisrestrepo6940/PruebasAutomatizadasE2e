package co.com.certification.practiceautomatedtesting.tasks;

import co.com.certification.practiceautomatedtesting.interactions.Enter;
import co.com.certification.practiceautomatedtesting.interactions.Click;
import co.com.certification.practiceautomatedtesting.userinterfaces.CheckoutInformationPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class FillCheckout implements Task {
    private final String firstName;
    private final String lastName;
    private final String postalCode;

    @Override
    @Step("{0} the user completes the purchase form with: '#firstName' - '#lastName' - '#postalCode'")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(firstName, CheckoutInformationPage.FIRST_NAME),
                Enter.theValue(lastName, CheckoutInformationPage.LAST_NAME),
                Enter.theValue(postalCode, CheckoutInformationPage.POSTAL_CODE)
        );
        actor.attemptsTo(
                Click.on(CheckoutInformationPage.CONTINUE_BUTTON)
        );
    }

    public static FillCheckout withInformation(String firstName, String lastName, String postalCode) {
        return instrumented(FillCheckout.class, firstName, lastName, postalCode);
    }

}
