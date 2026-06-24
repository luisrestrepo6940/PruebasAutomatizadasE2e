package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.ProductsPage;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

@AllArgsConstructor
public class ProductName implements Question<String> {
    private final String product;

    @Override
    public String answeredBy(Actor actor) {
        return actor.asksFor(Text.of(ProductsPage.PRODUCT_NAME.of(product)));
    }

    public static ProductName ofIndex(String product) {
        return new ProductName(product);
    }
}
