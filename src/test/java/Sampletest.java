import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class Sampletest {
    @Test
    public void shouldGetAllUsers(){
        //Arrange
        //Act
        //Assert

        given()
                .when()
                .get("https://gorest.co.in/public/v1/users")
                .then()
                .statusCode(200)
                .log().body();
    }

    @Test
    public void createUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 39856e05ce7d1e8b73a9e56bdd5becb67ff2d4bf89faff36950d1a7ff258663d")
                .body("{\n" +
                        "\t\"name\":\"Philip Boston\",\n" +
                        "\t\"email\": \"philip17@gmail.com\",\n" +
                        "\t\"gender\": \"male\",\n" +
                        "\t\"status\": \"active\"\n" +
                        "}")
                .when()
                    .post("https://gorest.co.in/public/v1/users")
                .then()
                    .statusCode(201)
                    .log().body();
    }
}
