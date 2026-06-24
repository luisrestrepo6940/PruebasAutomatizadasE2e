package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.CheckoutCompletePage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

@AllArgsConstructor
public class ConfirmationMessage implements Question<Boolean> {
    private final String message;

    @Override
    public Boolean answeredBy(Actor actor) {
        String actualMessage = actor.asksFor(Text.of(CheckoutCompletePage.THANK_YOU_ORDER));
        return actualMessage.trim().equalsIgnoreCase(message.trim());
    }

    public static ConfirmationMessage displayed(String confirmationMessage) {
        return new ConfirmationMessage(confirmationMessage);
    }
}
