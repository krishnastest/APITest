import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUsersAll {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void createMaleUser(){

        //1. Arrange
        String email= String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "\t\"name\":\"Philip Boston\",\n" +
                "\t\"email\": \"%s\",\n" +
                "\t\"gender\": \"male\",\n" +
                "\t\"status\": \"active\"\n" +
                "}", email);

        //2. Act
        usersClient.createUser(body)
                .then()

        //3. Assert
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Philip Boston"))
                .body("data.email", Matchers.equalTo(email));
    }

    @Test
    public void createFemaleUser(){
        //1. Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "\t\"name\":\"Dua Lipa\",\n" +
                "\t\"email\": \"%s\",\n" +
                "\t\"gender\": \"female\",\n" +
                "\t\"status\": \"active\"\n" +
                "}", email);

        //2. Act
        usersClient.createUser(body)
                .then()

        //3. Assert
                .statusCode(201)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                .body("data.name", Matchers.equalTo("Dua Lipa"))
                .body("data.email", Matchers.equalTo(email));
    }



}
