package hu.unideb.webdev.repository.entity;

import lombok.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Audited
@Table(name = "match_stats")
@Access(value = AccessType.FIELD)
public class MatchStats {

    @EmbeddedId
    @Column
    private MatchesStatsIdentity matchesStatsIdentity;

    @OneToOne
    @JoinColumn
    private Teams tid;

    @Column
    private String loc;

    @Column
    private Integer KI;

    @Column
    private Integer MK;

    @Column
    private Integer HB;

    @Column
    private Integer DI;

    @Column
    private Integer GL;

    @Column
    private Integer BH;

    @Column
    private Integer HO;

    @Column
    private Integer TK;

    @Column
    private Integer RB;

    @Column
    private Integer IF;

    @Column
    private Integer CL;

    @Column
    private Integer CG;

    @Column
    private Integer FF;

    @Column
    private Integer FA;

    @Column
    private Integer BR;

    @Column
    private Integer CP;

    @Column
    private Integer UP;

    @Column
    private Integer CM;

    @Column
    private Integer MI;

    @Column(name = "1P")
    private Float P;

    @Column
    private Integer BO;

    @Column
    private Integer GA;

    @Column
    private Float PP;
}
