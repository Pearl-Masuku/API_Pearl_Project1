package RequestBuilder;

import io.restassured.response.Response;

import static Common.BasePaths.*;
import static PayloadBuilder.WeatherPayloadBuilder.registerStationPayload;
import static PayloadBuilder.WeatherPayloadBuilder.updateStationPayload;
import static io.restassured.RestAssured.given;

public class WeatherRequestBuilder {
    public static String stationID;

    public static Response registerStations(String external_id, String stationName,float latitude,float longitude, int altitude) {
        Response response =  given()
                .baseUri(WeatherBaseURl)
                .basePath("/data/3.0/stations")
                .queryParam("appid", "91fff73dbb4e35034699d5cbe7e30228")
                .contentType("application/json")
                .body(registerStationPayload(external_id, stationName, latitude, longitude, altitude))
                .log().all()
                .post()
                .then()
                .log().all()
                .extract().response();
        stationID = response.jsonPath().getString("ID");

        return response;
    }

    // Update the Weather Station API Request
    public static Response updateStationResponse(String newExternal_id, String newStationName,float newLatitude,float newLongitude, int newAltitude) {
        return given().
                baseUri(WeatherBaseURl).
                basePath("/data/3.0/stations/" + stationID).
                queryParam("appid", "91fff73dbb4e35034699d5cbe7e30228").
                contentType("application/json").
                //header("Authorization", "Bearer " + apiToken).
                body(updateStationPayload(newExternal_id, newStationName,newLatitude,newLongitude,newAltitude)).
                log().all().
                put().
                then().
                log().all().
                extract().response();
    }

    // Get registered Weather Station API Request
    public static Response getStationResponse() {
        return given().
                baseUri(WeatherBaseURl).
                basePath("/data/3.0/stations/" + stationID).
                queryParam("appid", "91fff73dbb4e35034699d5cbe7e30228").
                contentType("application/json").
                log().all().
                get().
                then().
                log().all().
                extract().response();
    }
}
