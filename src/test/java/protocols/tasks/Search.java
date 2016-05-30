package protocols.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

import protocols.ui.SearchBox;

public class Search implements Task  {

    private final String searchType;
    private final String searchTerm;

    protected Search(String searchType, String searchTerm) {
        this.searchType = searchType;
        this.searchTerm = searchTerm;
    }

    @Step("Search for #searchTerm")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(SearchBox.DROP_DOWN)
                //Click.on(SearchBox.dropDownOption(searchType))
                );
        /*actor.attemptsTo(Enter.theValue(searchTerm)
                .into(SearchBox.SEARCH_FIELD)
                .thenHit(ENTER));*/
    }

    public static Search forTheTerm(String searchType, String searchTerm) {
        return instrumented(Search.class, searchType, searchTerm);
    }

}
