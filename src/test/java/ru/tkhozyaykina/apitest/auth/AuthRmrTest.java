package ru.tkhozyaykina.apitest.auth;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import ru.redmadrobot.apitest.Check;
import ru.tkhozyaykina.apitest.Precondition.PreconditionForRmr;
import ru.tkhozyaykina.apitest.pojo.auth.response.errorToken.ErrorToken;
import ru.tkhozyaykina.apitest.pojo.auth.response.errorValidation.ErrorValidation;

import static io.restassured.RestAssured.given;

@Feature("Авторизация через Google ID")
@Story("Все сценарии")
public class AuthRmrTest extends PreconditionForRmr {

    @Test(description = "Проверка ошибки валидации - 400")
    public void authErrorValidation() {
        String url = RestAssured.baseURI + "/auth/google-sign-in/";
        Response response = given().post(url);
        ErrorValidation errorResponse = response.as(ErrorValidation.class);
        String errorResponseActual = errorResponse.getError().getCode();
        String errorResponseExpected = "validation_error";
        Check.assertEquals(errorResponseActual, errorResponseExpected);
        Check.statusCode(response.statusCode(), 400);
    }

    @Test(description = "Проверка истекшего токена - 401")
    public void authBadToken() {
        String url = RestAssured.baseURI + "/auth/google-sign-in/";
        Response response = given().param("id_token", "eyJhbGciOiJSUzI1NiIsImtpZCI6ImM2YWY3Y2FhMDg5NWZkMDFlNzc4ZGNlYWE3YTc5ODgzNDdkOGYyNWMifQ.eyJhenAiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDAxMTAwMDk3MzYxNjY5MzgzNzQiLCJoZCI6InJlZG1hZHJvYm90LmNvbSIsImVtYWlsIjoidC5raG96eWF5a2luYUByZWRtYWRyb2JvdC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6Ilo1M1B4Yk5OeEpQMDdwWVg4MXFiSEEiLCJleHAiOjE1MzIyODQ4NjcsImlzcyI6ImFjY291bnRzLmdvb2dsZS5jb20iLCJqdGkiOiIzOWIwOTc3MDI3NjcyMmU4YmUwYzU0NjU2NWJlMTZkY2U2ODA3Mzc5IiwiaWF0IjoxNTMyMjgxMjY3LCJuYW1lIjoiVGF0eWFuYSBLaG96eWF5a2luYSIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vLWRJZEVvR0dHM2pVL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUEwL1FhMW8xUklvdHJJL3M5Ni1jL3Bob3RvLmpwZyIsImdpdmVuX25hbWUiOiJUYXR5YW5hIiwiZmFtaWx5X25hbWUiOiJLaG96eWF5a2luYSIsImxvY2FsZSI6InJ1In0.Rq-n1sOzf-RV6d-WVuwvkxqqIDypI1l4w6DrOhII_pIVV-MNJxy8NnDIkydNk0dybEhzDqstL6HDMaUlvPQEieBZ22mhY7IW0-P_IsEK7YjfIi2DroGP0fSU3TLInJJJf_EheylH5m0CEmV2QZ84ut2buaP2d0vI1u4cj1gimdmDjVfQZJ4ED_W1PNwYH2c0q8mZUgBnK-Av1mPMhSmlNE_x8HywKgqO2gaKhMs7XpLoupz60myaPcGLPQ9bl7jwBllOxB-0NNbmL7APTvqp0Zt4aK8kQK-aOhWDLRG2SKzAXWs2-WY2AdInPQwFI0D1xAXmBPDtaF66rqxNOG2Rsg")
                .post(url);
        ErrorToken tokenError = response.as(ErrorToken.class);

        String tokenResponseActual = tokenError.getError().getCode();
        String tokenResponseExpected = "invalid_token";
        Check.assertEquals(tokenResponseActual, tokenResponseExpected);
        Check.statusCode(response.statusCode(), 401);

    }


    @Test(description = "Проверка аутентификации")
    public void checkAuth() {
        String url = RestAssured.baseURI + "/auth/check/";
        Response response = given().cookie("access_token", auth).get(url);
        response.then().statusCode(200);
    }


}

