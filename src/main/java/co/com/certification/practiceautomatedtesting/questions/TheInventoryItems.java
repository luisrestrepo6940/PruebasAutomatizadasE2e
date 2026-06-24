package co.com.certification.practiceautomatedtesting.questions;

import co.com.certification.practiceautomatedtesting.userinterfaces.InventoryPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class TheInventoryItems implements Question<Integer> {
    public Integer answeredBy(Actor actor) {
        return InventoryPage.INVENTORY_ITEMS.resolveAllFor(actor).size();
    }

    public static TheInventoryItems displayedCount() {
        return new TheInventoryItems();
    }
}