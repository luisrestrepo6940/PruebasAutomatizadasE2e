package co.com.certification.practiceautomatedtesting.interactions;

import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class Enter implements Interaction {
    private final String value;
    private final Target target;

    @Override
    @Step("{0} enter the value '#value' into the '#target' field")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(net.serenitybdd.screenplay.actions.Enter.theValue(value).into(target));
    }

    public static Enter theValue(String value, Target target) {
        return instrumented(Enter.class, value, target);
    }
}
