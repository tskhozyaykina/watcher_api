package ru.tkhozyaykina.apitest.auth;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.redmadrobot.apitest.Check;
import ru.tkhozyaykina.apitest.Precondition.PreconditionForAutstaff;
import ru.tkhozyaykina.apitest.pojo.authStaff.profile.Profile;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static ru.redmadrobot.apitest.GenerateEmail.getRandomEmail;


@Feature("Регистрация с логином и паролем")
@Story("Все сценарии")
public class AuthStaffTest extends PreconditionForAutstaff {


    @Test(description = "Регистрация с логином и паролем")
    public void checkInLoginPassword() {


        String url = RestAssured.baseURI + "/auth/sign-up/";

        Map<String, String> params = new HashMap<>();
        params.put("first_name", "Иван");
        params.put("password", "Qwerty!4");
        params.put("last_name", "Иванов");

        Response response = given().params(params).param("email", getRandomEmail()).post(url);

        Check.statusCode(response.statusCode(), 200);
    }

    @Test(description = "Аутентификация с логином/паролем")
    public void authInLoginPassword() {

        String randomEmail = getRandomEmail();
        String url1 = RestAssured.baseURI + "/auth/sign-up/";
        String url = RestAssured.baseURI + "/auth/sign-in/";
        Map<String, String> params = new HashMap<>();
        params.put("first_name", "Иван");
        params.put("password", "Qwerty!4");
        params.put("last_name", "Иванов");
        Response responseauth = given().params(params).param("email", randomEmail).post(url1);
        Check.statusCode(responseauth.statusCode(), 200);

        Response response = given().params(params).param("email", randomEmail).post(url);
        Profile profile = response.as(Profile.class);
        String roleActual = profile.getData().getUser().getRole();
        String roleExpected = "employee";
        Check.assertEquals(roleActual, roleExpected);
        Check.statusCode(response.statusCode(), 200);
        response.prettyPrint();
    }
}
