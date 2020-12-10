package hu.unideb.webdev.controller.api;

import hu.unideb.webdev.DTO.MatchStatsDTO;
import hu.unideb.webdev.DTO.MatchesStatsIdentityDTO;
import hu.unideb.webdev.DTO.request.MatchStatsUpdateRequest;

import java.util.List;

public interface MatchStatsClientIf {

    List<MatchStatsDTO> getAllMatchStats();

    MatchStatsDTO getMatchStatsById(MatchesStatsIdentityDTO id);

    MatchStatsDTO saveMatchStats(MatchStatsDTO stats);

    MatchStatsDTO updateMatchStats(MatchStatsUpdateRequest updateRequest);

    void deleteMatchStats(MatchesStatsIdentityDTO id);
}
