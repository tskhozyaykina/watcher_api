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
        Response response = given().param("id_token", "eyJhbGciOiJSUzI1NiIsImtpZCI6IjQwYzZiMDliNDQ5NjczNDUzYzNkYTY5OWUyZGY1NTI3ZjkxZTY4MDMifQ.eyJhenAiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDAxMTAwMDk3MzYxNjY5MzgzNzQiLCJoZCI6InJlZG1hZHJvYm90LmNvbSIsImVtYWlsIjoidC5raG96eWF5a2luYUByZWRtYWRyb2JvdC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6Ii1kMU9uMEpXNkhzcFdkOXFYemgzUUEiLCJleHAiOjE1MzMyMTAwMjMsImlzcyI6ImFjY291bnRzLmdvb2dsZS5jb20iLCJqdGkiOiJmOTU1ZGNkNjQ1MWExMzg0Yjk0MWRlYWI1NzdkODdlZDAxOGY3ZTg4IiwiaWF0IjoxNTMzMjA2NDIzLCJuYW1lIjoiVGF0eWFuYSBLaG96eWF5a2luYSIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vLWRJZEVvR0dHM2pVL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUEwL1FhMW8xUklvdHJJL3M5Ni1jL3Bob3RvLmpwZyIsImdpdmVuX25hbWUiOiJUYXR5YW5hIiwiZmFtaWx5X25hbWUiOiJLaG96eWF5a2luYSIsImxvY2FsZSI6InJ1In0.LJJgM35n7ITOUxwVP6XqHEYlsP-WJQrd91jDjTS0yZ8AIzSSxHevTuyfX3k926g-7x6OW5u6f2HlshOGbMQGzO6XtgATcnPDyTlfJEUyspKrypWpjtsSFJlojmmgX4LnOYugHayxR9_u10FX9c2WVi2wdlpMyKOM4UpxdB5fxh-PXygJ-qvqZ1_1eL6pKf8FFY57z94Zn_j_tAWZq19N-4jhcNI_NB8vVW3QH5BgU4xL-UeAylsT8p77Y2iicOTFUoxv3diq3D05vNYAlIzZ5C8bvghf-BFLQ72yMJFhIcFUMQAZcUkTnz7hXZOTXtOHZmUGDG087gvvWJSIyWHDGw")
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

