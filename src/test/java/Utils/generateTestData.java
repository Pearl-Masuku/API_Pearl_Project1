package Utils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;


public class generateTestData {

    static Faker faker = new Faker();

    //NDOSI TEST DATA
    public static String firstName = faker.name().firstName();
    public static String lastName = faker.name().lastName();
    public static String email = firstName + "." + lastName + "@gmail.com";

    public static String newFirstName = faker.name().firstName();
    public static String newLastName = faker.name().lastName();
    public static String fullName = newFirstName + " " + newLastName;

    public static String password = faker.internet().password(8, 16, true, true, true);

    @Test
    public void generateData() {
        System.out.println(fullName);
    }


    //WEATHER TEST DATA
    public static String generateFakerId(String prefix, String label, int number) {
        return String.format("%s_%s%03d", prefix, label, number);
    }

    public static String testGenerateFakerId() {
        return generateFakerId("SF", "TEST", 1);

    }

    public static String generateStationName() {
        String city = faker.address().city();
        return city + " Test Station";

    }

    public static float latitude = Float.parseFloat(faker.address().latitude());
    public static float longitude = Float.parseFloat(faker.address().longitude());
    public static Integer altitude = faker.number().numberBetween(50, 500);

//UPDATE Weather TEST DATA
    public static String generateNewFakerId(String prefix, String label, int number) {
        return String.format("%s_%s%03d", prefix, label, number);
    }

    public static String testGenerateNewFakerId() {
        return generateNewFakerId("SF", "UPD", 1);
    }

    public static String generateNewStationName() {
        String city = faker.address().city();
        return city + " Test Station";

    }

    public static float newLatitude = Float.parseFloat(faker.address().latitude());
    public static float newLongitude = Float.parseFloat(faker.address().longitude());
    public static Integer newAltitude = faker.number().numberBetween(50, 500);


}
