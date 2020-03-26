package com.recruting.recruting.models.user;

import com.recruting.recruting.models.Company;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@ToString
public class JobSeeker {
    @Id
    private long id;

    @OneToOne
    private User user;
}
