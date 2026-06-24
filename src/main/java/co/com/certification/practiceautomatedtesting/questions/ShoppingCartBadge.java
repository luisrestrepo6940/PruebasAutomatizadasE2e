package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.CartPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

public class ShoppingCartBadge implements Question<String> {
    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(CartPage.QUANTITY_PRODUCTS));
    }

    public static ShoppingCartBadge value() {
        return new ShoppingCartBadge();
    }
}
