package com.facebook_clone_two.facebook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table
public class Comment {

    @Id
    @SequenceGenerator(
            name = "post_sequence",
            sequenceName = "post_sequence",
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "post_sequence"
    )

    private Long id;
    private String commentMessage;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    @SequenceGenerator(allocationSize = 1, name = "user_sequence")
    private AppUser appUser;
    @ManyToOne
    private Post post;
}
