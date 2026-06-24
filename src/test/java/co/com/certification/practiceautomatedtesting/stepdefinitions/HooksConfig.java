package co.com.certification.practiceautomatedtesting.stepdefinitions;

import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import static co.com.certification.practiceautomatedtesting.utils.Constants.USER;

public class HooksConfig {
    @Before
    public void setUp() {
        OnStage.setTheStage(new OnlineCast());
        OnStage.theActorCalled(USER);
    }
}