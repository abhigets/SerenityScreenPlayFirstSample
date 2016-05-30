package protocols.tasks;


import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import protocols.ui.AdisHomePage;

public class OpenAdisApplication implements Task{

    AdisHomePage adisHomePage;

    @Override
    public <T extends Actor> void performAs(T actor){
        actor.attemptsTo(
                Open.browserOn().the(adisHomePage)
        );
    }
}
