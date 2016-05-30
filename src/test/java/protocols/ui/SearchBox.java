package protocols.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SearchBox {
    public static Target DROP_DOWN = Target.the("drop down").located(By.cssSelector("#global-search .selectBox-label"));
    public static Target DROP_DOWN_OPTION;
    public static Target SEARCH_FIELD = Target.the("search field").located(By.name("q"));

    public static Target dropDownOption(String searchType) {
        DROP_DOWN_OPTION = Target.the("drop down "+searchType).located(By.cssSelector(".selectBox-dropdown-menu a[rel="+ searchType +"]"));
        return DROP_DOWN_OPTION;
    }
}
