package com.sequoia.shorturl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @Description:  JSR 380 validation framework.
 * @Author: usr1999
 * @Create: 2021/9/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="user")
public class User {

    @NotNull(message = "Name cannot be null")
    private String name;

    @AssertTrue
    private boolean working;

    @Size(min = 10, max = 200, message
            = "About Me must be between 10 and 200 characters")
    private String aboutMe;

    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 150, message = "Age should not be greater than 150")
    private int age;

    @Email(message = "Email should be valid")
    private String email;

    private String address;

    private Date time;

    public User(String name){
        this.name = name;
    }

}
