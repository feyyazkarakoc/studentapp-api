package com.tpe.domain;


import com.tpe.domain.enums.UserRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tbl_role")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Role{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Enumerated(EnumType.STRING)
    @Column(length = 30,nullable = false)
    private UserRole name;


    @Override
    public String toString() {
        return "Role{" +
                "name=" + name +
                '}';
    }
}
