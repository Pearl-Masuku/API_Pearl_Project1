package RequestBuilder;

import io.restassured.response.Response;

import static Common.BasePaths.*;
import static PayloadBuilder.WeatherPayloadBuilder.registerStationPayload;
import static io.restassured.RestAssured.given;

public class WeatherRequestBuilder {
    static String token;

    public static Response registerStations(String external_id, String stationName,double latitude,double longitude, int altitude) {
        return given()
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

        //System.out.println();
    }
}
