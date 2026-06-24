package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.CartPage;
import co.com.certification.practiceautomatedtesting.utils.SessionVariables;
import lombok.AllArgsConstructor;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Visibility;

import java.util.stream.IntStream;

@AllArgsConstructor
public class AreAllProductsVisible implements Question<Boolean> {
    private final int quantity;

    @Override
    public Boolean answeredBy(Actor actor) {
        return IntStream.rangeClosed(1, quantity)
                .allMatch(i -> {
                    String indexString = String.valueOf(i);
                    String productName = Serenity.sessionVariableCalled(
                            SessionVariables.SESSION_PRODUCT.getValue().concat(indexString)
                    );
                    return productName != null && actor.asksFor(
                            Visibility.of(CartPage.PRODUCT_TITLE_IN_CART.of(productName))
                    );
                });
    }

    public static AreAllProductsVisible forThe(int quantity) {
        return new AreAllProductsVisible(quantity);
    }
}