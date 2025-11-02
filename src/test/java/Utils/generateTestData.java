package Utils;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;
//import org.junit.jupiter.api.Test;


public class generateTestData {

    static Faker faker = new Faker();

    //NDOSI TEST DATA
    public static String firstName=faker.name().firstName();
    public static String lastName=faker.name().lastName();
    public static String email = firstName+"."+lastName + "@gmail.com";

    public static String newFirstName=faker.name().firstName();
    public static String newLastName=faker.name().lastName();
    public static String fullName = newFirstName + " " + newLastName;

    public static String password =faker.internet().password(8, 16, true, true, true);

    @Test
    public void generateData() {
        System.out.println(fullName);}

    //WEATHER TEST DATA

        public static String generateFakerId(String prefix, String label, int number) {
            return String.format("%s_%s%03d", prefix, label, number);
        }

        @Test
        public void testGenerateFakerId() {
            String external_id = generateFakerId("SF", "TEST", 1);
            System.out.println(external_id); // Output: SF_TEST001
        }

    public static String generateStationName() {
        //Faker faker = new Faker();
        String city = faker.address().city();
        return city + " Test Station";
    }

    @Test
    public void testGenerateStationName() {
        String stationName = generateStationName();
        System.out.println(stationName);
    }



}
