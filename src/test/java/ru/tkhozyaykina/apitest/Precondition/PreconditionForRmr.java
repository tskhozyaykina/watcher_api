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
        Response response = given().param("id_token", "eyJhbGciOiJSUzI1NiIsImtpZCI6ImM2YWY3Y2FhMDg5NWZkMDFlNzc4ZGNlYWE3YTc5ODgzNDdkOGYyNWMifQ.eyJhenAiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJhdWQiOiI4NjUxOTQzMjEwOTUtMTJiYnFpN3YxNjlvcGp1ZGIwdGlyb2diZmNocDc0ZjUuYXBwcy5nb29nbGV1c2VyY29udGVudC5jb20iLCJzdWIiOiIxMDAxMTAwMDk3MzYxNjY5MzgzNzQiLCJoZCI6InJlZG1hZHJvYm90LmNvbSIsImVtYWlsIjoidC5raG96eWF5a2luYUByZWRtYWRyb2JvdC5jb20iLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwiYXRfaGFzaCI6IlZLYlRnWkFCZ2c0WmJuT3hNM20xekEiLCJleHAiOjE1MzIyOTE0MDksImlzcyI6ImFjY291bnRzLmdvb2dsZS5jb20iLCJqdGkiOiJkZWY1ZGExNmRlN2Y1ODIwOTFkNmEzYzA2NThjZTAxNDlmYTMwNmY5IiwiaWF0IjoxNTMyMjg3ODA5LCJuYW1lIjoiVGF0eWFuYSBLaG96eWF5a2luYSIsInBpY3R1cmUiOiJodHRwczovL2xoMy5nb29nbGV1c2VyY29udGVudC5jb20vLWRJZEVvR0dHM2pVL0FBQUFBQUFBQUFJL0FBQUFBQUFBQUEwL1FhMW8xUklvdHJJL3M5Ni1jL3Bob3RvLmpwZyIsImdpdmVuX25hbWUiOiJUYXR5YW5hIiwiZmFtaWx5X25hbWUiOiJLaG96eWF5a2luYSIsImxvY2FsZSI6InJ1In0.XkP4tXPoHgqTq6QsFIL40ueUx_6DoVOMwukc0xlzdHpVoY8moHicR_bEi6JSZvFu755c4XtrPmNqu-1uoOtdrMNcVuxy2iFkXW_ctz0xXJ8NLxrI8vfyT7USt7JUy1bSjOVNOJX7vqV88nCPzkLn_joGesXFcEcyLNqpZi2MLSQPSO4e_pBgjot3JdP95pW89tOYLQ7oSWX5yUKXSGJrhaWDDs_uL9XxOxnqF-_5PH2SZpVnG5321z6B8qGKiCDn-2FWeP13gWe4dtkYi5zTMdfZgPwUDnAcFf7ftnDYD9UvrOYX-JKyn2NuP4EHHrjEiGzU1AMUA2HL6QivlG2GcA").post(url);
        response.then().statusCode(200);
        auth = response.andReturn().cookie("access_token");
    }
}


