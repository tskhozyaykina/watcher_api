package ru.tkhozyaykina.apitest.Precondition;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class PreconditionForAutstaff {
    @BeforeClass(description = "Включаю слушатель AllureRestAssured")
    public void beforeClass() {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.baseURI = "https://watcher.dev.redmadrobot.com/api/v1";
    }
}
