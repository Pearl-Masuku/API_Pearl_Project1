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

@Feature("Weather API")
@Story("Register Stations")

public class WeatherAPITests {
    static String externalId = generateTestData.testGenerateFakerId();
    static String stationName = generateTestData.generateStationName();


     //Registration Test
    @Description("As a user i want to be able to register Stations on Weather API")
    @Test
    public void registerTests() {

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

    //Get Station Test
    @Description("As a user i want to be able to get registered Stations on Weather API")
    @Test
    public void getStationsTests() {
        getStationResponse().
                then().
                log().all().
                assertThat().
                statusCode(success_status_code).
                body("id",notNullValue()).
                body("created_at",notNullValue()).
                body("updated_at",notNullValue()).
                body("external_id",equalTo(externalId)).
                body("name",equalTo(stationName)).
                body("latitude",equalTo(latitude)).
                body("longitude",equalTo(longitude)).
                body("altitude",equalTo(altitude)).
                body("rank",notNullValue());

    }

    //Update Test
    @Description("As a user i want to be able to update Stations on Weather API")
    @Test
    public void updateTests() {
        String newExternalId = generateTestData.testGenerateNewFakerId();
        String newStationName = generateTestData.generateNewStationName();
        float newLatitude = generateTestData.newLatitude;
        float newLongitude = generateTestData.newLongitude;
        Integer newAltitude = generateTestData.newAltitude;
        updateStationResponse(newExternalId,newStationName,newLatitude,newLongitude,newAltitude).
                then().
                log().all().
                assertThat().
                statusCode(success_status_code).
                body("id",notNullValue()).
                body("created_at",notNullValue()).
                body("updated_at",notNullValue()).
                body("external_id",equalTo(newExternalId)).
                body("name",equalTo(newStationName)).
                body("latitude",equalTo(newLatitude)).
                body("longitude",equalTo(newLongitude)).
                body("altitude",equalTo(newAltitude)).
                body("rank",notNullValue());

    }





}
