import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class UpdateUserTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void updateUserTest(){

        //1. Arrange
        String email= String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Philip Boston").email(email)
                .gender("male").status("active").build();

        //2. Act
        usersClient.updateUser(requestBody)
                .then()

                //3. Assert
                .statusCode(200)
                .log().body()
                .body("data.id", Matchers.notNullValue())
                //.body("data.name", Matchers.equalTo("Philip Boston"))
                .body("data.email", Matchers.equalTo(email));


    }
}
