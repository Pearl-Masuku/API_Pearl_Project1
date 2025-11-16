package PayloadBuilder;

import org.json.simple.JSONObject;



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

    //Update Station Payload
    public static JSONObject updateStationPayload(String newExternal_id, String newStationName, double newLatitude, double newLongitude, int newAltitude) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("external_id", newExternal_id);
        jsonObject.put("name", newStationName);
        jsonObject.put("latitude", newLatitude);
        jsonObject.put("longitude", newLongitude);
        jsonObject.put("altitude", newAltitude);

        return jsonObject;
    }

}
