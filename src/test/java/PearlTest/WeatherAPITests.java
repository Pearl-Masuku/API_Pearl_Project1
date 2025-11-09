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
        registerStations(generateTestData.testGenerateFakerId(), "MASUKU", 37.76, -122.43, 150).
                then().
                log().all().
                assertThat().
                statusCode(create_success_status_code);
//                    body("data.firstName",equalTo(firstName)).
//                    body("data.lastName",equalTo(lastName)).
//                    body("data.id",notNullValue()).
//                    body("data.createdAt",notNullValue());
    }


//
//        // Check required keys
//        assertTrue(payload.containsKey("ID"));
//        assertTrue(payload.containsKey("user_id"));
//        assertTrue(payload.containsKey("created_at"));
//        assertTrue(payload.containsKey("updated_at"));
//        assertTrue(payload.containsKey("external_id"));
//        assertTrue(payload.containsKey("name"));
//        assertTrue(payload.containsKey("latitude"));
//        assertTrue(payload.containsKey("longitude"));
//        assertTrue(payload.containsKey("altitude"));
//
//        // Check values
//        assertEquals(externalId, payload.get("external_id"));
//        assertEquals(stationName, payload.get("name"));
//        assertEquals(latitude, (double) payload.get("latitude"), 0.0001);
//        assertEquals(longitude, (double) payload.get("longitude"), 0.0001);
//        assertEquals(altitude, (int) payload.get("altitude"));
//
//        // Check ID and timestamps are non-empty strings
//        assertNotNull(payload.get("ID"));
//        assertNotNull(payload.get("user_id"));
//        assertNotNull(payload.get("created_at"));
//        assertNotNull(payload.get("updated_at"));
//    }


}
