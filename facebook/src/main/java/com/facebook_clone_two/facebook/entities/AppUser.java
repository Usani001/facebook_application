package com.facebook_clone_two.facebook.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table

public class  AppUser {
    @Id
    @SequenceGenerator(
            name = "app_user_sequence",
            sequenceName = "app_user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "app_user_sequence"
    )
    @Column(
            name = "id",
            updatable = false
    )
    private Long id;
    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT",
           length = 20
    )
    private String firstName;
    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT",
            length = 20
    )
    private String lastName;

    @Column(
            name = "email_address",
            nullable = false,
            columnDefinition = "TEXT",
            length = 50,
            unique = true
    )
    private String email;

    @Column(
            name = "date_of_birth",
            columnDefinition = "DATE",
            length = 20
    )
    private LocalDate dateOfBirth;
    @Transient
    private Integer age;

    @Column(
            name = "country",
            nullable = false,
            columnDefinition = "TEXT",
            length = 20
    )
    private String country;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT",
            length = 20
    )
    private String password;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "appUser", cascade = CascadeType.ALL)
//    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private List<Post> post;



    public AppUser(String firstName, String lastName, String email, LocalDate dateOfBirth, String country, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.password= password;
    }






    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }
    public Integer getAge() {
        return Period.between(this.dateOfBirth, LocalDate.now()).getYears();
    }




}
