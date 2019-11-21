package pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.conditions.Visible;

public class GeneralPage {

    public <T> T waitUntilElementShouldBeVisible(T page, SelenideElement element, Long timeout) {
        element.waitUntil(new Visible(), timeout);
        return page;
    }
}
