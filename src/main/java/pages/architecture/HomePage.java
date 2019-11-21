package pages.architecture;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import pages.GeneralPage;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class HomePage extends GeneralPage {
    public SelenideElement pageHeader = $(".mainheading");
    public HomePage open() {
        Selenide.open("book.theautomatedtester.co.uk");
        return this;
    }

    public Chapter1Page clickOnChapter1Link() {
        $(byText("Chapter1")).click();
        return new Chapter1Page();
    }
}
