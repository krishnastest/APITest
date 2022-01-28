import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClient;
import users.create.CreateUserRequestBody;

import java.util.UUID;

public class DeleteUserTest {

    //1. Arrange
    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void deleteUserTest(){

        //2. Act
        usersClient.deleteUsers()
                .then()

        //3. Assert
                .statusCode(204)
                .log().body();
    }
}
