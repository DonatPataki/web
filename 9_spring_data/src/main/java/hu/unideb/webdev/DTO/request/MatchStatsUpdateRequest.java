package hu.unideb.webdev.DTO.request;

import hu.unideb.webdev.DTO.MatchStatsDTO;
import hu.unideb.webdev.DTO.MatchesStatsIdentityDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MatchStatsUpdateRequest {

    private MatchStatsDTO matchStatsDTO;

    private MatchesStatsIdentityDTO matchesStatsIdentityDTO;
}
