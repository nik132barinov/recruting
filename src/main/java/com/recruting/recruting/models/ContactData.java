package com.recruting.recruting.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class ContactData {
    @Id
    private long id;

    @Enumerated(EnumType.STRING)
    private ContactType type;

    private String value;
}
