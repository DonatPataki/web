package hu.unideb.webdev.controller.api;

import hu.unideb.webdev.DTO.PlayersDTO;

import java.util.List;

public interface PlayersClientIf {

    List<PlayersDTO> getAllPlayers();

    PlayersDTO getPlayerById(Integer id);

    PlayersDTO savePlayer(PlayersDTO player);

    PlayersDTO updatePlayer(PlayersDTO player, Integer id);

    void deletePlayer(Integer id);
}
