package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.HomePage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

public class IsApplicationOpen implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        return actor.asksFor(Visibility.of(HomePage.HOME_PAGE));
    }

    public static IsApplicationOpen isOpen() {
        return new IsApplicationOpen();
    }
}
