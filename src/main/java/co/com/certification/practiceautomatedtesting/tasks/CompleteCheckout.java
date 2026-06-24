package co.com.certification.practiceautomatedtesting.tasks;

import co.com.certification.practiceautomatedtesting.exceptions.BaseException;
import co.com.certification.practiceautomatedtesting.questions.AreAllProductsVisible;
import co.com.certification.practiceautomatedtesting.questions.ShoppingCartBadge;
import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;

import static co.com.certification.practiceautomatedtesting.utils.Constants.*;

@AllArgsConstructor
public class CompleteCheckout implements Task {
    private final Map<String, String> data;
    private static final String QUANTITY_ERROR_MESSAGE =
            "ERROR EN CHECKOUT: LA CANTIDAD DE PRODUCTOS ESPERADOS (%s) NO COINCIDE CON LOS AGREGADOS (%s).";

    private static final String VISIBILITY_ERROR_MESSAGE =
            "ERROR EN CHECKOUT: PRODUCTOS NO ESTAN VISIBLES EN EL RESUMEN DE CHECK OUT. PRODUCTOS QUE SE ESPERABA VISUALIZAR (%s)";

    @Override
    @Step("{0} completes the checkout process with the target data")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(BeginCheckout.now(),
                FillCheckout.withInformation(
                        data.get(FIRST_NAME),
                        data.get(LAST_NAME),
                        data.get(POSTAL_CODE)
                )
        );
        String expectedQuantity = data.get(PRODUCTS_QUANTITY);
        validateProductQuantity(actor, expectedQuantity);
        validateProductsVisibility(actor, expectedQuantity);
        actor.attemptsTo(NavigateToCheckout.overview());
    }

    private void validateProductQuantity(Actor actor, String expectedQuantity) {
        String currentQuantity = actor.asksFor(ShoppingCartBadge.value());
        if (!currentQuantity.equals(expectedQuantity)) {
            throw new BaseException(QUANTITY_ERROR_MESSAGE.formatted(expectedQuantity, currentQuantity));
        }
    }

    private void validateProductsVisibility(Actor actor, String expectedQuantity) {
        boolean visibleProducts = actor.asksFor(AreAllProductsVisible.forThe(Integer.parseInt(expectedQuantity)));
        if (!visibleProducts) {
            throw new BaseException(VISIBILITY_ERROR_MESSAGE.formatted(expectedQuantity));
        }
    }

    public static CompleteCheckout withData(Map<String, String> data) {
        return Tasks.instrumented(CompleteCheckout.class, data);
    }
}