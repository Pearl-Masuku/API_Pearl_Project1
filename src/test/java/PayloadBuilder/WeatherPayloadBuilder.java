package PayloadBuilder;

import org.json.simple.JSONObject;
import java.util.UUID;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;


public class WeatherPayloadBuilder {

//Register Station Payload
    public static JSONObject registerStationPayload(String external_id, String stationName, double latitude, double longitude, int altitude) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", external_id);
        jsonObject.put("name", stationName);
        jsonObject.put("latitude", latitude);
        jsonObject.put("longitude", longitude);
        jsonObject.put("altitude", altitude);

        return jsonObject;
    }

//    public static Map<String, Object> registerStationPayload(String external_id, String stationName, double latitude, double longitude, int altitude) {
//        String id = UUID.randomUUID().toString().replace("-", "");
//        String userId = UUID.randomUUID().toString().replace("-", "");
//        String createdAt = Instant.now().toString();
//        String updatedAt = Instant.now().toString();
//        String rank = UUID.randomUUID().toString();
//        String source_type = UUID.randomUUID().toString();
//
//        Map<String, Object> jsonObject = new HashMap<>();
//        jsonObject.put("ID", id);
//        jsonObject.put("user_id", userId);
//        jsonObject.put("created_at", createdAt);
//        jsonObject.put("updated_at", updatedAt);
//        jsonObject.put("external_id", external_id);
//        jsonObject.put("name", stationName);
//        jsonObject.put("latitude", latitude);
//        jsonObject.put("longitude", longitude);
//        jsonObject.put("altitude", altitude);
//        jsonObject.put("rank", rank);
//        jsonObject.put("source_type", source_type);
//
//        return jsonObject;
//    }

}
