package co.com.certification.practiceautomatedtesting.stepdefinitions;

import co.com.certification.practiceautomatedtesting.questions.ConfirmationMessage;
import co.com.certification.practiceautomatedtesting.questions.IsApplicationOpen;
import co.com.certification.practiceautomatedtesting.tasks.AddProductsToCart;
import co.com.certification.practiceautomatedtesting.tasks.CompleteCheckout;
import co.com.certification.practiceautomatedtesting.tasks.LoginWith;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import static co.com.certification.practiceautomatedtesting.utils.Constants.CONFIRMATION_MESSAGE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class BuyProductsWebsite {

    @Given("the user accesses to the website")
    public void theUserAccessesToTheWebsite() {
        theActorInTheSpotlight().attemptsTo(
                Open.browserOn().thePageNamed("base.url"),
                Ensure.that(IsApplicationOpen.isOpen()).isTrue());
    }

    @And("the user logs in with username {string} and password {string}")
    public void theUserLogsInWithUsernameAndPassword(String user, String password) {
        theActorInTheSpotlight().attemptsTo(LoginWith.authenticating(user, password));
    }

    @When("the user adds {string} products to the cart")
    public void theUserAddsProductsToTheCart(String productsQuantity) {
        theActorInTheSpotlight().attemptsTo(AddProductsToCart.quantity(Integer.parseInt(productsQuantity)));
    }

    @Then("user should be able to complete the purchase successfully")
    public void userShouldBeAbleToCompleteThePurchaseSuccessfully(DataTable dataTable) {
        List<Map<String, String>> mapList = dataTable.asMaps(String.class, String.class);
        theActorInTheSpotlight().attemptsTo(CompleteCheckout.withData(mapList.getFirst()), Ensure.that(
                ConfirmationMessage.displayed(mapList.getFirst().get(CONFIRMATION_MESSAGE))).isTrue()
        );
    }
}