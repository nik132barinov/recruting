package com.recruting.recruting.models.user;

import com.recruting.recruting.models.Company;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class JobRecruiter {
    @Id
    private long id;

    @OneToOne
    private User user;

    @ManyToOne
    private Company company;
}
