package ru.redmadrobot.apitest;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.testng.Assert;

public class Check {

    @Step("{stepToAllure}")
    public static synchronized void stepToAllure(String step) {
    }


    @Step("Ожидаемый statusCode: '{statusCodeExpected}', реальный: '{statusCodeActual}'")
    public static synchronized void statusCode(int statusCodeActual, int statusCodeExpected) {
        Assert.assertEquals(statusCodeActual, statusCodeExpected);
    }

    @Step("Проверяю что response body соответсвует: '{expectedBody}'")
    public static synchronized void body(Response response, String expectedBody) {
        String body = response.getBody().print();
        stepToAllure("expected: " + expectedBody);
        stepToAllure("actual: " + body);
        Assert.assertEquals(body, expectedBody);
    }

    @Step("Проверяю что по ключу '{key}' value совпадает с ожидаемым")
    public static synchronized void value(String key, String expectedValue, String actualValue) {
        Assert.assertEquals(actualValue, expectedValue);
    }


    @Step("Проверяю что Object равны")
    static public void assertEquals(Object actual, Object expected) {
        org.testng.Assert.assertEquals(actual, expected);
    }


}
// @Step("Получаю значение header:'{keyHeader}'")
// public static synchronized String getValueHeader(Response response, String keyHeader) {
// return response.getHeader(keyHeader);
// }

// @Step("Ожидаемый contentType: '{contentTypeExpected}', реальный: '{contentTypeActual}'")
// public static synchronized void contentType(String contentTypeActual, String contentTypeExpected) {
// Assert.assertEquals(contentTypeActual, contentTypeExpected);
// }
//
// @Step("Проверяю что значение по ключу: '{jsonParam}' соотвествует '{expectedResult}'")
// public static synchronized void bodyEqualTo(Response response, String jsonParam, Matcher<?> expectedResult) {
// response.then().body(jsonParam, expectedResult);
// }
//
// @Step("Ожидаемый размер массива '{name}' :'{expectedCount}' реальный: '{actualCount}'")
// public static synchronized void arrayLength(String name, int expectedCount, int actualCount) {
// Assert.assertEquals(actualCount, expectedCount);
// }

