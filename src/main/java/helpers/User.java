package helpers;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zipCode;
    private String telephone;
    private String ssn;
    private String username;
    private String password;
}