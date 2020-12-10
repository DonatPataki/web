package hu.unideb.webdev.DTO;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class PlayersDTO {

    private int pid;

    private Timestamp dob;

    private String firstName;

    private String lastName;

    private int height;

    private int weight;
}
