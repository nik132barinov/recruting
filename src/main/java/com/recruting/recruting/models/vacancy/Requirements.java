package com.recruting.recruting.models.vacancy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Requirements {
    @Id
    private long id;

    @OneToOne
    private Skill skill;

    private int value;
}
