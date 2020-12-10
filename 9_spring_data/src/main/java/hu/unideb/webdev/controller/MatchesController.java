package hu.unideb.webdev.controller;

import hu.unideb.webdev.DTO.MatchesDTO;
import hu.unideb.webdev.controller.api.MatchesClientIf;
import hu.unideb.webdev.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "match")
public class MatchesController implements MatchesClientIf {

    @Autowired
    private MatchesService matchesService;

    @Override
    @GetMapping("/all")
    public List<MatchesDTO> getAllMatches() {
        return matchesService.getAllMatches();
    }

    @Override
    @GetMapping("/{id}")
    public MatchesDTO getMatchById(@PathVariable(value = "id") final Integer id) {
        return matchesService.getMatchById(id);
    }

    @Override
    @PostMapping
    public MatchesDTO saveMatch(@RequestBody final MatchesDTO match) {
        return matchesService.saveMatch(match);
    }

    @Override
    @PutMapping("/{id}")
    public MatchesDTO updateMatch(@RequestBody final MatchesDTO match, @PathVariable(value = "id") final Integer id) {
        return matchesService.updateMatch(match, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable(value = "id") final Integer id) {
        matchesService.deleteById(id);
    }
}
