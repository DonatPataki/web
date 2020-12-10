package hu.unideb.webdev.DTO;

import hu.unideb.webdev.repository.entity.Teams;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class MatchesDTO {

    private int mid;

    private int season;

    private String round;

    private TeamsDTO tid1;

    private TeamsDTO tid2;

    private String tid1_loc;

    private String tid2_loc;

    private Timestamp startDt;

    private String venue;

    private int att;

    private int margin;

    private int winScore;

    private int winTid;

    private String winLoc;

    private int loseScore;

    private String loseLoc;

    private int loseTid;

    private int hTid;

    private int hScore;

    private int hQ1g;

    private int hQ2g;

    private int hQ3g;

    private int hQ4g;

    private int hEtg;

    private int hQ1b;

    private int hQ2b;

    private int hQ3b;

    private int hQ4b;

    private int hEtb;

    private int aTid;

    private int aScore;

    private int aQ1g;

    private int aQ2g;

    private int aQ3g;

    private int aQ4g;

    private int aEtg;

    private int aQ1b;

    private int aQ2b;

    private int aQ3b;

    private int aQ4b;

    private int aEtb;

    private int target;
}
