package co.com.certification.practiceautomatedtesting.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class Click implements Interaction {
    private final Target button;

    @Override
    @Step("{0} click on the '#button' button")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Click.on(button));
    }

    public static Click on(Target target) {
        return instrumented(Click.class, target);
    }
}
