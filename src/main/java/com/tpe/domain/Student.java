package com.tpe.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotNull(message = "First name can not be null")
    @NotBlank(message = "First name can not be  white space")
    @Size(min = 2,max = 25,message = "First name '${validated value}' must be between {min} and {max} chars")
    @Column(nullable = false,length = 25)
    private String name;

    @Column(nullable = false,length = 25)
    private  String lastName;

    @Column
    private Integer grade;

    @Column(nullable = false,length = 50,unique = true)
    @Email(message = "Provide valid mail")
    private String email;

    private String phoneNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "MM/dd/yyyy HH:mm:ss",timezone = "Turkey")
    @Setter(AccessLevel.NONE)
    private LocalDateTime createDate = LocalDateTime.now();


}

