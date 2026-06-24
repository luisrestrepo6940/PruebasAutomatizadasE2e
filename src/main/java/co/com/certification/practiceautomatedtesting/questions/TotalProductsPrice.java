package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.CheckoutOverviewPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TotalProductsPrice implements Question<Double> {
    @Override
    public Double answeredBy(Actor actor) {
        return CheckoutOverviewPage.ITEM_PRICES.resolveAllFor(actor)
                .texts()
                .stream()
                .map(price -> price.replace("$", ""))
                .mapToDouble(Double::parseDouble)
                .sum();
    }

    public static TotalProductsPrice calculated() {
        return new TotalProductsPrice();
    }
}