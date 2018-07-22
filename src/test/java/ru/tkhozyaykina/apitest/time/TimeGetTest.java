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

public class TimeGetTest extends PreconditionForRmr {






    @Test(description = "Получить списанные часы по дням во временном диапазоне")
    public void getTime() {
        String url = RestAssured.baseURI + "/logged_time/";
        Map<String, String> params = new HashMap<>();
//        params.put("from", "2018-05-11");
//        params.put("to", "2018-07-11");
        Response response = given()
                .cookie("access_token", auth)
//                .params(params)
                .get(url);
        System.out.println(response);



    }
}
