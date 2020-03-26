package com.recruting.recruting.models.user;

import com.recruting.recruting.models.ContactData;
import com.recruting.recruting.models.Gender;
import com.recruting.recruting.models.Socials;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
@Table(name = "userTable")
public class User {
    @Id
    private long id;

    private String login;

    private String password;

    private String email;

    private String emailCode;

    private String fullName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private LocalDate birthDate;

    @ManyToMany
    @PrimaryKeyJoinColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<Socials> socials;

    @ManyToMany
    @PrimaryKeyJoinColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ContactData> contactData;
}
