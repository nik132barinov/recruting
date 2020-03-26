package com.recruting.recruting.models.vacancy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Profession {
    @Id
    private long id;

    private String name;

    //todo?
    @ManyToOne
    private Profession parent;
}
