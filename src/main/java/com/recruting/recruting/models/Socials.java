package com.recruting.recruting.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class Socials {
    @Id
    private long id;

    private String token;

    private String refreshToken;
}
