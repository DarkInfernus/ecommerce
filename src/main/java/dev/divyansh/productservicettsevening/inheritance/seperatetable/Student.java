package dev.divyansh.productservicettsevening.inheritance.seperatetable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student extends User {
    private double psp;
    @Column(name = "student_rank")
    private int rank;
}
