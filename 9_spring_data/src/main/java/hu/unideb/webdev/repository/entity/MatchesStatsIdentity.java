package hu.unideb.webdev.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class MatchesStatsIdentity implements Serializable {

    @OneToOne
    private Matches mid;

    @OneToOne
    private Players pid;
}
