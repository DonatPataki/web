package hu.unideb.webdev.controller.api;

import hu.unideb.webdev.DTO.TeamsDTO;

import java.util.List;

public interface TeamsClientIf {

    List<TeamsDTO> getAllTeams();

    TeamsDTO getTeamById(Integer id);

    TeamsDTO saveTeam(TeamsDTO team);

    TeamsDTO updateTeam(Integer id, TeamsDTO team);

    void deleteTeam(Integer id);
}
