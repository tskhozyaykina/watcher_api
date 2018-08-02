package ru.tkhozyaykina.apitest.project;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.tkhozyaykina.apitest.Precondition.PreconditionForRmr;
import static io.restassured.RestAssured.given;

public class ProjectTest extends PreconditionForRmr {
    @Feature("Проекты авторизованного пользователя")
    @Story("На примере Т.Хозяйкиной")
    @Test(description = "Cписок проектов пользователя")
    public void projectList() {
        String url = RestAssured.baseURI + "/projects/";
        Response response = given().cookie("access_token", auth).queryParam("recent", true).get(url);
         response.then().statusCode(200);
         response.prettyPrint();


    }
}
