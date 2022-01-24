import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUsersAll {

    @Test
    public void createMaleUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 39856e05ce7d1e8b73a9e56bdd5becb67ff2d4bf89faff36950d1a7ff258663d")
                .body("{\n" +
                        "\t\"name\":\"Philip Boston\",\n" +
                        "\t\"email\": \"philip25@gmail.com\",\n" +
                        "\t\"gender\": \"male\",\n" +
                        "\t\"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Philip Boston"))
                .body("data.email", Matchers.equalTo("philip25@gmail.com"));
    }

    @Test
    public void createFemaleUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 39856e05ce7d1e8b73a9e56bdd5becb67ff2d4bf89faff36950d1a7ff258663d")
                .body("{\n" +
                        "\t\"name\":\"Dua Lipa\",\n" +
                        "\t\"email\": \"dualipa25@gmail.com\",\n" +
                        "\t\"gender\": \"female\",\n" +
                        "\t\"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Dua Lipa"))
                .body("data.email", Matchers.equalTo("dualipa25@gmail.com"));
    }
}
