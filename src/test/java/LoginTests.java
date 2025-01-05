import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;
import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class LoginTests {


    @Test
    void successfulloginTestMosRuByPhone() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible, Duration.ofMillis(5000)).closest("button").click();
        $("[name=login]").setValue("+7(944)944-07-95").pressEnter();
        $("[name=password]").setValue("Gfhjkm%1234").pressEnter();
        sleep(5000);
    }

    @Test
    void successfulloginTestMosRuByEmail() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible, Duration.ofMillis(5000)).closest("button").click();
        $("[name=login]").setValue("test795@test.krlb.ru").pressEnter();
        $("[name=password]").setValue("Gfhjkm%1234").pressEnter();
        sleep(5000);
    }

    @Test
    void unsuccessfulLoginTestByEmail() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible, Duration.ofMillis(5000)).closest("button").click();
        $("[name=login]").setValue("test79@test.krlb.ru").pressEnter();
        $("[name=password]").setValue("Gfhjkm%1234").pressEnter();
        $("[class=blockquote-danger]").shouldHave(text("Введен некорректный логин или пароль"));

    }
    @Test
    void successfulLoginTestPasswordRequired() {
        open("https://www.mos.ru/");
        $("[class^='User_icon']").shouldBe(visible, Duration.ofMillis(5000)).closest("button").click();
        $("[name=login]").setValue("test79@test.krlb.ru");
        $("[id=bind]").click();
        $("[class=parsley-required]").shouldHave(text(new String("Введите пароль".getBytes(), StandardCharsets.UTF_8)));



    }
}
