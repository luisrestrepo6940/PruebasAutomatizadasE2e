package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.CheckoutOverviewPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class SubtotalPrice implements Question<Double> {

    @Override
    public Double answeredBy(Actor actor) {
        return Double.parseDouble(CheckoutOverviewPage.SUB_TOTAL_LABEL.resolveFor(actor).
                getText().replaceAll("[^0-9.]", "")
        );
    }

    public static SubtotalPrice displayed() {
        return new SubtotalPrice();
    }
}