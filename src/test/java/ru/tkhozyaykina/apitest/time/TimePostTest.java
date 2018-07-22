package ru.tkhozyaykina.apitest.time;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.tkhozyaykina.apitest.Precondition.PreconditionForRmr;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
@Feature("Cписание часов")
@Story("На примере Т.Хозяйкиной")

public class TimePostTest extends PreconditionForRmr {
    @Test(description = "Списать часы")
    public void postTime() {
        String url = RestAssured.baseURI + "/logged_time";
        Map <String, Object> params = new HashMap<>();
        params.put("project_id", 6);
        params.put("minutes_spent", 60);
        params.put("date", "2018-07-17");
        params.put("description", "Тестирование списания часов");
        params.put("user_id",410);

        Response response = given().cookie("access_token", auth)
                .body(params)
                .post(url);
        response.then().statusCode(200);
        response.prettyPrint();
    }
}
