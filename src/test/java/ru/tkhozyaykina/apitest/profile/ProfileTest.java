package ru.tkhozyaykina.apitest.profile;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.redmadrobot.apitest.Check;
import ru.tkhozyaykina.apitest.Precondition.PreconditionForRmr;
import ru.tkhozyaykina.apitest.pojo.auth.response.profile.Profile;

import static io.restassured.RestAssured.given;

public class ProfileTest extends PreconditionForRmr {


    @Feature("Профиль авторизованного пользователя")
    @Story("На примере Т.Хозяйкиной")
    @Test(description = "Профиль авторизованного пользователя")
    public void profileAuth() {
        String url = RestAssured.baseURI + "/auth/profile/";
        Response response = given().cookie("access_token", auth).get(url);

        Profile profile = response.as(Profile.class);
        String firstNameActual = profile.getData().getUser().getFirstName();
        String emailActual = profile.getData().getUser().getEmail();
        String roleActual = profile.getData().getUser().getRole();
        String lastNameActual = profile.getData().getUser().getLastName();
        int idActual = profile.getData().getUser().getId();
        boolean isStaffActual = profile.getData().getUser().getIsStaff();


        String firstNameExpected = "Tatyana";
        String emailExpected = "t.khozyaykina@redmadrobot.com";
        String roleExpected = "employee";
        String lastNameExpected = "Khozyaykina";
        int idExpected = 6;
        boolean isStaffExpected = false;


        Check.statusCode(response.statusCode(), 200);
        Check.assertEquals(firstNameActual, firstNameExpected);
        Check.assertEquals(emailActual, emailExpected);
        Check.assertEquals(roleActual, roleExpected);
        Check.assertEquals(lastNameActual, lastNameExpected);
        Check.assertEquals(idActual, idExpected);
        Check.assertEquals(isStaffActual, isStaffExpected);

    }

}
