package ru.tkhozyaykina.apitest.project;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.tkhozyaykina.apitest.Precondition.PreconditionForRmr;
import static io.restassured.RestAssured.given;

public class ProjectTest extends PreconditionForRmr {
    @Test(description = "Cписок проектов пользователя")
    public void projectList() {
        String url = RestAssured.baseURI + "/projects/";
        Response response = given().cookie("access_token", auth).queryParam("recent", true).get(url);
         response.then().statusCode(200);
         response.prettyPrint();


    }
}
