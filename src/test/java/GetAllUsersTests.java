import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

public class GetAllUsersTests {
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
                .log().body()
                .body("data", Matchers.hasSize(20))
                .body("data", Matchers.hasItem(Matchers.hasEntry("gender", "male")));
    }

}
