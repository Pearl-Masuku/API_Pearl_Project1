package PearlTest;

import io.qameta.allure.Description;
import org.testng.annotations.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;


import static Common.commonTestData.*;
import static RequestBuilder.NdosiAPIRequestBuilder.*;
import static RequestBuilder.NdosiAPIRequestBuilder.updateUserProfileResponse;
import static Utils.generateTestData.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;


@Test
@Feature("Ndosi API")
@Story("Login")
public class NdosiAPITests {

    private static String token;

    //Registration Test
    @Description("As a user i want to be able to register to Ndosi API")

    public void registerTests() {
        registerResponse(firstName,lastName,email,password,password).
                then().
                log().all().
                assertThat().
                statusCode(create_success_status_code).
                body(containsString("data")).
                body("success",equalTo(true)).
                body("message",equalTo("User registered successfully")).
                body("data.email",equalTo(email)).
                body("data.firstName",equalTo(firstName)).
                body("data.lastName",equalTo(lastName)).
                body("data.id",notNullValue()).
                body("data.createdAt",notNullValue());
    }

    //Login Test
    @Description("As a user i want to be able to login to Ndosi API")
    @Test(dependsOnMethods = "registerTests")
    public void loginTests() {
        loginResponse(email,password).
                then().
                log().all().
                assertThat().
                statusCode(success_status_code);


    }

    //Update User Profile Test
    @Description("As a user i want to be able to update my profile on Ndosi API")
    @Test(dependsOnMethods = "loginTests")
    public void updateProfileTests() {
        updateUserProfileResponse( fullName, email).
                then().
                log().all().
                assertThat().
                statusCode(success_status_code).
                body(containsString("data")).
                body("success",equalTo(true)).
                body("message",equalTo("Profile updated successfully")).
                body("data.FirsName",equalTo(newFirstName)).
                body("data.LastName",equalTo(newLastName)).
                body("data.updatedAt",notNullValue());
    }


}
