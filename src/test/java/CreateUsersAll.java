import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

import static io.restassured.RestAssured.given;

public class CreateUsersAll {

    @Test
    public void createMaleUser(){

        //1. Arrange
        String body = "{\n" +
                "\t\"name\":\"Philip Boston\",\n" +
                "\t\"email\": \"philip31@gmail.com\",\n" +
                "\t\"gender\": \"male\",\n" +
                "\t\"status\": \"active\"\n" +
                "}";

        //2. Act
        new UsersClient().createUser(body)
                .then()

        //3. Assert
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Philip Boston"))
                .body("data.email", Matchers.equalTo("philip31@gmail.com"));
    }

    @Test
    public void createFemaleUser(){
        //1. Arrange
        String body = "{\n" +
                "\t\"name\":\"Dua Lipa\",\n" +
                "\t\"email\": \"dualipa34@gmail.com\",\n" +
                "\t\"gender\": \"female\",\n" +
                "\t\"status\": \"active\"\n" +
                "}";

        //2. Act
        new UsersClient().createUser(body)
                .then()

        //3. Assert
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Dua Lipa"))
                .body("data.email", Matchers.equalTo("dualipa34@gmail.com"));
    }



}
