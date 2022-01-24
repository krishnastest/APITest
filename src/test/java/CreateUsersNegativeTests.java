import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClient;

public class CreateUsersNegativeTests {

    @Test
    public void createUserFailForInvalidEmail(){
        //1. Arrange
        String body ="{\n" +
                "\t\"name\":\"Dua Lipa\",\n" +
                "\t\"email\": \"dua.lipa.33\",\n" +
                "\t\"gender\": \"female\",\n" +
                "\t\"status\": \"active\"\n" +
                "}";
        //2. Act
        new UsersClient().createUser(body)
                .then()
                .log().body()

                //3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }

}
