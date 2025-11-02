package PayloadBuilder;

import com.fasterxml.jackson.databind.util.JSONPObject;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.sql.PreparedStatement;

public class WeatherPayloadBuilder {

    public static JSONObject registerPayload(String external_id, String stationName,double latitude,double longitude, int altitude) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", external_id);
        jsonObject.put("name", stationName);
        jsonObject.put("latitude", latitude);
        jsonObject.put("longitude", longitude);
        jsonObject.put("altitude", altitude);

        return jsonObject;
    }

    //Update User Payload
    public  static JSONObject UpdateUserPayload(String fullName, String email) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("full_name", fullName);
        jsonObject.put("email", email);

        return jsonObject;
    }



}
