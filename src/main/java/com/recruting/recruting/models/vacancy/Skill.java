package com.recruting.recruting.models.vacancy;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Skill {
    @Id
    private long id;

    @Column
    private String name;

    @Column
    private int parentId;
}
