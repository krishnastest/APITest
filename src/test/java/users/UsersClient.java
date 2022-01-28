package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.create.CreateUserRequestBody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(CreateUserRequestBody body) {
        return
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer 39856e05ce7d1e8b73a9e56bdd5becb67ff2d4bf89faff36950d1a7ff258663d")
                        .body(body)
                        .when()
                        .post("https://gorest.co.in/public/v1/users");
    }

    public Response getAllUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }

    public Response updateUser(CreateUserRequestBody body) {
        return
                given()
                        .accept(ContentType.JSON)
                        .contentType(ContentType.JSON)
                        .header("Authorization", "Bearer 39856e05ce7d1e8b73a9e56bdd5becb67ff2d4bf89faff36950d1a7ff258663d")
                        .body(body)
                        .when()
                        .put("https://gorest.co.in/public/v1/users/3882");
    }

    public Response deleteUsers() {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 39856e05ce7d1e8b73a9e56bdd5becb67ff2d4bf89faff36950d1a7ff258663d")
                .when()
                .delete("https://gorest.co.in/public/v1/users/3860");

    }
}
