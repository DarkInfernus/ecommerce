package dev.divyansh.productservicettsevening.inheritance.seperatetable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Instructor extends User {
    private double rating;
    private int total_sessions;
}
