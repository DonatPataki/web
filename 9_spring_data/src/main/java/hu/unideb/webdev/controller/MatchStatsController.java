package hu.unideb.webdev.controller;

import hu.unideb.webdev.DTO.MatchStatsDTO;
import hu.unideb.webdev.DTO.MatchesStatsIdentityDTO;
import hu.unideb.webdev.DTO.request.MatchStatsUpdateRequest;
import hu.unideb.webdev.controller.api.MatchStatsClientIf;
import hu.unideb.webdev.service.MatchStatsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "match/stats")
public class MatchStatsController implements MatchStatsClientIf {

    @Autowired
    private MatchStatsService matchStatsService;

    /**
     * Returns all MatchStats
     * @return List<MatchStatsDTO></>
     */
    @Override
    @GetMapping("/all")
    public List<MatchStatsDTO> getAllMatchStats() {
        return matchStatsService.getAllMatchStats();
    }

    /**
     * Returns MatchStats with given id
     * @param id id of MatchStats
     * @return MatchStatsDTO
     */
    @Override
    @GetMapping("/id")
    public MatchStatsDTO getMatchStatsById(@RequestBody MatchesStatsIdentityDTO id) {
        return matchStatsService.getMatchStatsById(id);
    }

    /**
     * Save MatchStats
     * @param stats MatchStatsDTO to save
     * @return MatchStatsDTO
     */
    @Override
    @PostMapping
    public MatchStatsDTO saveMatchStats(@RequestBody final MatchStatsDTO stats) {
        return matchStatsService.saveMatchStats(stats);
    }

    /**
     * Updates MatchStats
     * @param updateRequest updateRequest
     * @return MatchStatsDTO
     */
    @Override
    @PutMapping
    public MatchStatsDTO updateMatchStats(@RequestBody final MatchStatsUpdateRequest updateRequest) {
        return matchStatsService.updateMatchStats(updateRequest);
    }

    /**
     * Deletes MatchStats
     * @param id id of MatchStats
     */
    @Override
    public void deleteMatchStats(MatchesStatsIdentityDTO id) {
        matchStatsService.deleteMatchStats(id);
    }
}
