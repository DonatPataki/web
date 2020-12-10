package hu.unideb.webdev.repository.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Audited
@Table(name = "players")
@Access(value = AccessType.FIELD)
public class Players {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer pid;

    @Column
    private Instant dob;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column
    private Integer height;

    @Column
    private Integer weight;
}
