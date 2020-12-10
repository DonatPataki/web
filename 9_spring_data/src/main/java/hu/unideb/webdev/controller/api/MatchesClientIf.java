package hu.unideb.webdev.controller.api;

import hu.unideb.webdev.DTO.MatchesDTO;

import java.util.List;

public interface MatchesClientIf {

    List<MatchesDTO> getAllMatches();

    MatchesDTO getMatchById(Integer id);

    MatchesDTO saveMatch(MatchesDTO match);

    MatchesDTO updateMatch(MatchesDTO match, Integer id);

    void deleteMatch(Integer id);
}
