import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.matchText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class GoogleSearchTest {

    @Test(description = "Check number of car search results by Google")
    public void searchCar() {
        Selenide.open("https://www.google.com/?hl=en");
        $(".RNNXgb").$("textarea").setValue("car");
        $(".gNO89b").click();
        $$("#rso>div").filterBy(text("car"))
                .shouldHave(size(10));
    }

    @Test(description = "Check Result stats in search by Google")
    public void guitarCar() {
        Selenide.open("https://www.google.com/?hl=en");
        $(".RNNXgb").$("textarea").setValue("guitar");
        $(".gNO89b").click();
        $("#result-stats").should(matchText("About [0-9,]+ results \\([0-9.]+ seconds\\) "));
    }


}
