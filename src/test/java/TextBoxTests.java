import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TextBoxTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy="eager";
        Configuration.headless=true;
    }

    @Test
    void fillFormTest() {
      open("/automation-practice-form");

       $("#firstName").setValue("Elmira");
       $("#lastName").setValue("Shaykhattarova");
       $("#userEmail").setValue("elmirailgizovna@gmail.com");
       $("#userNumber").setValue("8906123456");

        $(By.xpath("//*[contains(text(),'Female')]")).click();
        $(By.xpath("//*[contains(text(),'Reading')]")).click();
        $(By.xpath("//*[contains(text(),'Sports')]")).click();

        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").$(byText("May")).click();
        $(".react-datepicker__year-select").$(byText("1998")).click();
        $(".react-datepicker__day.react-datepicker__day--029").click();

        $("#subjectsInput").setValue("ch");
        $(byText("Chemistry")).click();

        $("#uploadPicture").uploadFromClasspath("picture.jpg");

        $("#currentAddress").setValue("Tatarstan,Kazan");
        $("#react-select-3-input").setValue("N");
        $(byText("NCR")).click();
        $("#react-select-4-input").setValue("Noi");
        $(byText("Noida")).click();


//        $(By.xpath("//*[contains(text(),'Submit')]")).click();
        $("#submit").click();




// проверка
      $("#output #firstName").shouldHave(text("Elmira"));
      $("#output #lastName").shouldHave(text("Shaykhattarova"));
      $("#output #userEmail").shouldHave(text("elmirailgizovna@gmail.com"));
      $("#output #userNumber").shouldHave(text("8906123456"));
      $("#output #currentAddress").shouldHave(text("Tatarstan,Kazan"));



  }

}