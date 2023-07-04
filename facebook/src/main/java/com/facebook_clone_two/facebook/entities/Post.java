package com.facebook_clone_two.facebook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.invoke.TypeDescriptor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Post {
    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "post_sequence"
    )

    private Long id;

    @Column(
            name = "postMessage",
            nullable = false,
            columnDefinition = "TEXT",
            length = 1000
    )
    private String postMessage;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comment;


    @JoinColumn( name = "app_user_id")
    @ManyToOne
    private AppUser appUser;


}
