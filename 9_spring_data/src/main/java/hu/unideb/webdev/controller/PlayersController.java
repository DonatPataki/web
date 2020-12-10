package hu.unideb.webdev.controller;

import hu.unideb.webdev.DTO.PlayersDTO;
import hu.unideb.webdev.controller.api.PlayersClientIf;
import hu.unideb.webdev.service.PlayersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "player")
public class PlayersController implements PlayersClientIf {

    @Autowired
    private PlayersService playersService;

    @Override
    @GetMapping("/all")
    public List<PlayersDTO> getAllPlayers() {
        return playersService.getAllPlayers();
    }

    @Override
    @GetMapping("/{id}")
    public PlayersDTO getPlayerById(@PathVariable(value = "id") final Integer id) {
        return playersService.getPlayerById(id);
    }

    @Override
    @PostMapping
    public PlayersDTO savePlayer(@RequestBody final PlayersDTO player) {
        return playersService.savePlayer(player);
    }

    @Override
    @PutMapping("/{id}")
    public PlayersDTO updatePlayer(@RequestBody final PlayersDTO player, @PathVariable(value = "id") final Integer id) {
        return playersService.updatePlayer(player, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable(value = "id") final Integer id) {
        playersService.deleteById(id);
    }
}
