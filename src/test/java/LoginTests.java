import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {

    @AfterEach
    public void logout(){
        Selenide.closeWebDriver();
    }

    @BeforeEach
    public void beforeEach(){
        Configuration.pageLoadStrategy ="eager";
    }


    @Test
    void successfulloginTestMosRuByPhone() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible).closest("button").click();
        $("[name=login]").setValue("+7(944)944-07-95").pressEnter();
        $("[name=password]").setValue("Gfhjkm%1234").pressEnter();
        $("[id=mos-dropdown-user]").shouldHave(text(new String("Роман Тестовый".getBytes(), StandardCharsets.UTF_8)));


    }

    @Test
    void successfulloginTestMosRuByEmail() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible).closest("button").click();
        $("[name=login]").setValue("test795@test.krlb.ru").pressEnter();
        $("[name=password]").setValue("Gfhjkm%1234").pressEnter();
        $("[id=mos-dropdown-user]").shouldHave(text("Роман Тестовый"));

    }

    @Test
    void unsuccessfulLoginTestByEmail() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible).closest("button").click();
        $("[name=login]").setValue("test79@test.krlb.ru").pressEnter();
        $("[name=password]").setValue("Gfhjkm%1234").pressEnter();
        $("[class=blockquote-danger]").shouldHave(text("Введен некорректный логин или пароль"));

    }
    @Test
    void successfulLoginTestPasswordRequired() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible).closest("button").click();
        $("[name=login]").setValue("test79@test.krlb.ru");
        $("[id=bind]").click();
        $("[class=parsley-required]").shouldHave(text(new String("Введите пароль".getBytes(), StandardCharsets.UTF_8)));



    }
}
