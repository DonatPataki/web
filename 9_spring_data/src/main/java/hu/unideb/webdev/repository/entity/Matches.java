package hu.unideb.webdev.repository.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@Entity
@Audited
@Table(name = "matches")
@Access(value = AccessType.FIELD)
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer mid;

    @Column
    private Integer season;

    @Column
    private String round;

    @OneToOne
    @JoinColumn
    private Teams tid1;

    @OneToOne
    @JoinColumn
    private Teams tid2;

    @Column
    private String tid1_loc;

    @Column
    private String tid2_loc;

    @Column(name = "start_dt")
    private Instant startDt;

    @Column
    private String venue;

    @Column
    private Integer att;

    @Column
    private Integer margin;

    @Column(name = "win_score")
    private Integer winScore;

    @Column(name = "win_tid")
    private Integer wIntegerid;

    @Column(name = "win_loc")
    private String winLoc;

    @Column(name = "lose_score")
    private Integer loseScore;

    @Column(name = "lose_loc")
    private String loseLoc;

    @Column(name = "lose_tid")
    private Integer loseTid;

    @Column(name = "h_tid")
    private Integer hTid;

    @Column(name = "h_score")
    private Integer hScore;

    @Column(name = "h_q1g")
    private Integer hQ1g;

    @Column(name = "h_q2g")
    private Integer hQ2g;

    @Column(name = "h_q3g")
    private Integer hQ3g;

    @Column(name = "h_q4g")
    private Integer hQ4g;

    @Column(name = "h_etg")
    private Integer hEtg;

    @Column(name = "h_q1b")
    private Integer hQ1b;

    @Column(name = "h_q2b")
    private Integer hQ2b;

    @Column(name = "h_q3b")
    private Integer hQ3b;

    @Column(name = "h_q4b")
    private Integer hQ4b;

    @Column(name = "h_etb")
    private Integer hEtb;

    @Column(name = "a_tid")
    private Integer aTid;

    @Column(name = "a_score")
    private Integer aScore;

    @Column(name = "a_q1g")
    private Integer aQ1g;

    @Column(name = "a_q2g")
    private Integer aQ2g;

    @Column(name = "a_q3g")
    private Integer aQ3g;

    @Column(name = "a_q4g")
    private Integer aQ4g;

    @Column(name = "a_etg")
    private Integer aEtg;

    @Column(name = "a_q1b")
    private Integer aQ1b;

    @Column(name = "a_q2b")
    private Integer aQ2b;

    @Column(name = "a_q3b")
    private Integer aQ3b;

    @Column(name = "a_q4b")
    private Integer aQ4b;

    @Column(name = "a_etb")
    private Integer aEtb;

    @Column
    private Integer target;
}
