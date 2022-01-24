import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUsersAll {

    @Test
    public void createMaleUser(){

        //1. Arrange
        String body = "{\n" +
                "\t\"name\":\"Philip Boston\",\n" +
                "\t\"email\": \"philip27@gmail.com\",\n" +
                "\t\"gender\": \"male\",\n" +
                "\t\"status\": \"active\"\n" +
                "}";

        //2. Act
        createUser(body)
                .then()

        //3. Assert
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Philip Boston"))
                .body("data.email", Matchers.equalTo("philip27@gmail.com"));
    }

    @Test
    public void createFemaleUser(){
        //1. Arrange
        String body = "{\n" +
                "\t\"name\":\"Dua Lipa\",\n" +
                "\t\"email\": \"dualipa30@gmail.com\",\n" +
                "\t\"gender\": \"female\",\n" +
                "\t\"status\": \"active\"\n" +
                "}";

        //2. Act
        createUser(body)
                .then()

        //3. Assert
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Dua Lipa"))
                .body("data.email", Matchers.equalTo("dualipa30@gmail.com"));
    }

    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 39856e05ce7d1e8b73a9e56bdd5becb67ff2d4bf89faff36950d1a7ff258663d")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

}
