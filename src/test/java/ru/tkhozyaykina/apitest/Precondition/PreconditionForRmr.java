package ru.tkhozyaykina.apitest.Precondition;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.given;

public class PreconditionForRmr {
    @BeforeClass(description = "Включаю слушатель AllureRestAssured")
    public void beforeClass() {
        RestAssured.filters(new AllureRestAssured());
        RestAssured.baseURI = "https://watcher.dev.redmadrobot.com/api/v1";
    }


    public String auth;

    @BeforeClass(description = "Получаю логин через Google ID Token - 200ОК")
    public void authTokenID() {
        String url = "https://watcher.dev.redmadrobot.com/api/v1/auth/google-sign-in/";
        Response response = given().param("id_token", "eyJhbGciOiJSUzI1NiIsImtpZCI6IjQwYzZiMDliNDQ5NjczNDUzYzNkYTY5OWUyZGY1NTI3ZjkxZTY4MDMifQ.eyJhenAiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDAxMTAwMDk3MzYxNjY5MzgzNzQiLCJoZCI6InJlZG1hZHJvYm90LmNvbSIsImVtYWlsIjoidC5raG96eWF5a2luYUByZWRtYWRyb2JvdC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6InpGYkNKRFZMMEZHTEY0YWVuY3JLU2ciLCJleHAiOjE1MzMyMTAyNTUsImlzcyI6ImFjY291bnRzLmdvb2dsZS5jb20iLCJqdGkiOiI1MDI5MzMwODBlYzE0MDA2ZDU3ODViNDU1YTMwZWVhNTBlY2E2NGI2IiwiaWF0IjoxNTMzMjA2NjU1LCJuYW1lIjoiVGF0eWFuYSBLaG96eWF5a2luYSIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vLWRJZEVvR0dHM2pVL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUEwL1FhMW8xUklvdHJJL3M5Ni1jL3Bob3RvLmpwZyIsImdpdmVuX25hbWUiOiJUYXR5YW5hIiwiZmFtaWx5X25hbWUiOiJLaG96eWF5a2luYSIsImxvY2FsZSI6InJ1In0.Ybn761eJ_Jc5JdgZuCKDTJJ2Ar_eECO8w4otoulF75H_Iej1RPsNCO1BO7egAXE09J5aqfunuxjlz_lG-Y-kt5shX2y0grU3iRfyUZh85a4b5oSslelzZMxV6alVv_9oS-OwP01Cq3mn8ufMhaaKtAuF9plfWb8eGR6FQrWRExhR40Eqr-73FBdiEZ98RGyu1mXb5fVYx7O6pQGwaDdMMzWvxNnFUJvidVxI_w15ntJED72roB-nX3KKyOPxp6SWepfrl_rvpMIQmTEHPFJpB25hNki_xqzARrN9Of34PzEmXtoW2qf9MnlqyU79M-iDbk6nqq1ff7s9eCPB2q2PIA").post(url);
        response.then().statusCode(200);
        auth = response.andReturn().cookie("access_token");
    }
}


