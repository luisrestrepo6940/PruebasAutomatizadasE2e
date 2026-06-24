package co.com.certification.practiceautomatedtesting.tasks;

import co.com.certification.practiceautomatedtesting.userinterfaces.ProductsPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class AddProduct implements Task {
    private final String productName;

    @Override
    @Step("{0} add the product '#productName' to the cart")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ProductsPage.ADD_TO_CART.of(productName)));
    }

    public static AddProduct withName(String productName) {
        return instrumented(AddProduct.class, productName);
    }
}
