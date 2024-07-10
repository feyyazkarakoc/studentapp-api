package com.tpe.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Userrequest {

    @NotBlank(message = "Please provide first name")
    private String firstName;

    @NotBlank(message = "Please provide last name")
    private String lastName;

    @NotBlank(message = "Please provide user name")
    @Size(min = 5,max = 10,message = "Please provide a user name(${'validatedValue'}) min={min},max={max} chars long")
    private String userName;

    @NotBlank(message = "Please provide password")
    private String password;
}
