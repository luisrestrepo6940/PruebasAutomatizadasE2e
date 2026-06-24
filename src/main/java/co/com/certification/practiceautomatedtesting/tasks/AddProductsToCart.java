package co.com.certification.practiceautomatedtesting.tasks;

import co.com.certification.practiceautomatedtesting.exceptions.BaseException;
import co.com.certification.practiceautomatedtesting.interactions.Click;
import co.com.certification.practiceautomatedtesting.questions.ProductName;
import co.com.certification.practiceautomatedtesting.questions.TheInventoryItems;
import co.com.certification.practiceautomatedtesting.userinterfaces.ProductsPage;
import co.com.certification.practiceautomatedtesting.utils.SessionVariables;
import co.com.certification.practiceautomatedtesting.utils.Utils;
import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;


@AllArgsConstructor
public class AddProductsToCart implements Task {
    private final int products;
    private static final String EXCEPTION_MESSAGE = "CANTIDAD DE PRODUCTOS NO VALIDA (%s). DEBE SER MAYOR A ".concat(
            "0 Y MENOR O IGUAL AL STOCK DISPONIBLE (%s).");

    @Step("{0} the user adds products '#products' to the cart")
    public <T extends Actor> void performAs(T actor) {
        int totalProducts = actor.asksFor(TheInventoryItems.displayedCount());
        checkProductRange(totalProducts);
        for (int i = 1; i <= products; i++) {
            String indexString = String.valueOf(i);
            String productName = actor.asksFor(ProductName.ofIndex(indexString));
            String sessionKey = SessionVariables.SESSION_PRODUCT.getValue().concat(indexString);
            Serenity.setSessionVariable(sessionKey).to(productName);
            actor.attemptsTo(
                    AddProduct.withName(Utils.formatToLowerCaseSlug(productName))
            );
        }
        actor.attemptsTo(Click.on(ProductsPage.SHOPPING_CART));
    }

    private void checkProductRange(int totalProducts) {
        if (products <= 0 || products > totalProducts) {
            throw new BaseException(EXCEPTION_MESSAGE.formatted(products, totalProducts));
        }
    }

    public static AddProductsToCart quantity(int products) {
        return instrumented(AddProductsToCart.class, products);
    }
}
