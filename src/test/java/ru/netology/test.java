package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Configuration.*;
import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selenide.*;

public class test {

    public String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    @Test
    void test() {
        String planningDate = generateDate(3);

        holdBrowserOpen = true;
        open("http://localhost:9999/");
        $("span[data-test-id=city] input").setValue("Санкт-Петербург");
        $("span[data-test-id=date] input").doubleClick().sendKeys(Keys.DELETE);
        $("span[data-test-id=date] input").sendKeys(planningDate);
        $("span[data-test-id=name] input").setValue("Иванов Сергей");
        $("span[data-test-id=phone] input").setValue("+79967878484");
        $("label[data-test-id=agreement]").click();
        $x("//span[contains(text(), 'Забронировать')]").click();
        $("div[data-test-id=notification]").should(appear, Duration.ofMillis(15000));




    }
}
