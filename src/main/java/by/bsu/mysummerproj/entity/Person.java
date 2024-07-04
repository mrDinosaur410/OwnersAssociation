package by.bsu.mysummerproj.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surname;
    @Column
    private String patronymic;
    @Column
    private Date birthdate;
    @Column(unique=true)
    private String contact;
    @OneToMany
    private Set<Flat> flats;
    @OneToMany
    private List<Topic> topics;
    @OneToMany
    private List<Comment> comments;
    @Column
    private Role role;
    @Column(unique=true)
    private String username;
    @Column
    private String password;
}
