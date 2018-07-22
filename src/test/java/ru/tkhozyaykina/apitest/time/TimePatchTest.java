package ru.tkhozyaykina.apitest.time;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.testng.annotations.Test;
import ru.tkhozyaykina.apitest.Precondition.PreconditionForRmr;
@Feature("Cписание часов")
@Story("На примере Т.Хозяйкиной")
public class TimePatchTest extends PreconditionForRmr {
    @Test(description = "Редактировать списанное время")
    public void editTime(){
        String url = RestAssured.baseURI + "/logged-time/{logged_time_id}/";
    }
}
