package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.ProductsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class IsApplicationAccessible implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(ProductsPage.PRODUCTS_TITLE));
    }

    public static IsApplicationAccessible isAccessible() {
        return new IsApplicationAccessible();
    }
}
