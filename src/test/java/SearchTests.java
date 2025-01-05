import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchTests {

    @Test
    void SuccessfulSearchTest_Firefox() {
        Configuration.browser = "firefox";
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("selenide.org"));
    }

    @Test
    void successfulSearchTest_Selenide() {
        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldBe(visible, Duration.ofMillis(35000)).shouldHave(text("selenide.org"));
    }

    @Test
    void successfulSearchTest_MosRu() {
        open("https://www.google.com/");
        $("[name=q]").setValue("mos.ru").pressEnter();
        $("[id=search]").shouldBe(visible, Duration.ofMillis(35000)).shouldHave(text("mos.ru"));
    }
}
