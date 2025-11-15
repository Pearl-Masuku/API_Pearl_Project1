package PearlTest;

import Utils.generateTestData;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
//import org.testng.annotations.Test;

import static Common.commonTestData.create_success_status_code;
import static Common.commonTestData.success_status_code;
import static RequestBuilder.WeatherRequestBuilder.registerStations;
import static RequestBuilder.WeatherRequestBuilder.*;
import static Utils.generateTestData.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


@Feature("Weather API")
@Story("Register Stations")

public class WeatherAPITests {


    private static String token;

    //Registration Test
    @Description("As a user i want to be able to register Stations on Weather API")
    @Test
    public void registerTests() {
        String externalId = generateTestData.testGenerateFakerId();
        String stationName = generateTestData.generateStationName();
        float latitude = generateTestData.latitude;
        float longitude = generateTestData.longitude;
        Integer altitude = generateTestData.altitude;
        registerStations(externalId, stationName,latitude, longitude, altitude).
                then().
                log().all().
                assertThat().
                statusCode(create_success_status_code).
                body("ID",notNullValue()).
                body("created_at",notNullValue()).
                body("updated_at",notNullValue()).
                body("user_id",notNullValue()).
                body("external_id",equalTo(externalId)).
                body("name",equalTo(stationName)).
                body("latitude",equalTo(latitude)).
                body("longitude",equalTo(longitude)).
                body("altitude",equalTo(altitude)).
                body("rank",notNullValue()).
                body("source_type",notNullValue());

    }



}
