package users.create;

import groovy.lang.GString;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestBody {

    private String name;
    private String email;
    private String gender;
    private String status;

}
