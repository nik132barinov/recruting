package com.recruting.recruting.models;

import com.recruting.recruting.models.user.User;
import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class CV {
    @Id
    private long id;

    @ManyToOne
    private User user;

    @ManyToMany
    @PrimaryKeyJoinColumn
    @LazyCollection(LazyCollectionOption.FALSE)
    private Set<ContactData> contactData;

    private String mainInformation;

    //todo% подумать об иерархии
    @Transient
    private String preferredPosition;

    //todo% подумать об иерархии
    @Transient
    private String skills;

    private int minimumSalary;
}
