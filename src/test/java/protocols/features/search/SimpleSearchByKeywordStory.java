package protocols.features.search;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import protocols.tasks.OpenAdisApplication;
import protocols.tasks.OpenTheApplication;
import protocols.tasks.Search;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.*;
import static org.hamcrest.Matchers.containsString;

@RunWith(SerenityRunner.class)
public class SimpleSearchByKeywordStory {

    Actor anna = Actor.named("Anna");

    @Managed(uniqueSession = true,driver = "phantomjs")
    public WebDriver herBrowser;

    @Steps
    OpenAdisApplication openAdisApplication;

    @Before
    public void annaCanBrowseTheWeb() {
        anna.can(BrowseTheWeb.with(herBrowser));
        herBrowser.manage().window().setSize(new Dimension(1280, 1024));
    }

    @Test
    public void seach_results_should_show_the_search_term_in_the_title() {

        givenThat(anna).wasAbleTo(openAdisApplication);

        when(anna).attemptsTo(Search.forTheTerm("Indication","Cancer"));

        then(anna).should(eventually(seeThat(TheWebPage.title(), containsString("Search Results - AdisInsight"))));

    }
}