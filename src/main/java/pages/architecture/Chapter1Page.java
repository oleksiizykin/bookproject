package pages.architecture;

import com.codeborne.selenide.conditions.ExactText;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class Chapter1Page {
    public Chapter1Page shouldSeeAssertText() {
        $("#divontheleft").shouldHave(new ExactText("Assert that this text is on the page"));
        return this;
    }

    public HomePage clickOnHomePageLink() {
        $(byText("Home Page")).click();
        return new HomePage();
    }
}
