import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

public class CreateUsersNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void createUserFailForInvalidEmail(){
        //1. Arrange
        String name = "Dua Lipa";
        String email = "dua.lipa.33";
        String gender = "female";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, email, gender, status);
        //2. Act
        usersClient.createUser(requestBody)
                .then()
                .log().body()

                //3. Assert
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));
    }

}
