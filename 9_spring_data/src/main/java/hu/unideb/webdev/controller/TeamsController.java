package hu.unideb.webdev.controller;

import hu.unideb.webdev.DTO.TeamsDTO;
import hu.unideb.webdev.controller.api.TeamsClientIf;
import hu.unideb.webdev.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "team")
public class TeamsController implements TeamsClientIf {

    @Autowired
    private TeamsService teamsService;

    @Override
    @GetMapping("/all")
    public List<TeamsDTO> getAllTeams() {
        return teamsService.getAllTeams();
    }

    @Override
    @GetMapping("/{id}")
    public TeamsDTO getTeamById(@PathVariable(value = "id") final Integer id) {
        return teamsService.getTeamById(id);
    }

    @Override
    @PostMapping
    public TeamsDTO saveTeam(@RequestBody final TeamsDTO team) {
        return teamsService.saveTeam(team);
    }

    @Override
    @PutMapping("/{id}")
    public TeamsDTO updateTeam(@PathVariable(value = "id") final Integer id, @RequestBody final TeamsDTO team) {
        return teamsService.updateTeam(team, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable(value = "id") final Integer id) {
        teamsService.deleteById(id);
    }
}
