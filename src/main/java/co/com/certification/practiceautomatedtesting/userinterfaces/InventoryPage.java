package co.com.certification.practiceautomatedtesting.userinterfaces;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InventoryPage {
    public static final Target INVENTORY_ITEMS = Target.the("Lista de productos en vitrina")
            .located(By.cssSelector("div[data-test='inventory-item']"));
}