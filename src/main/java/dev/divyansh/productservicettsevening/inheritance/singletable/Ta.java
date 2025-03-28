package dev.divyansh.productservicettsevening.inheritance.singletable;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Ta extends User {
    private String company;
    private int doubt_resolved;
}
