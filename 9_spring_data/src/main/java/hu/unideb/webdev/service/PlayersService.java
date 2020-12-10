package hu.unideb.webdev.service;

import hu.unideb.webdev.DTO.PlayersDTO;
import hu.unideb.webdev.repository.PlayersRepository;
import hu.unideb.webdev.repository.entity.Players;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayersService {

    @Autowired
    private PlayersRepository playersRepository;

    public List<PlayersDTO> getAllPlayers() {
        return playersRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public PlayersDTO getPlayerById(final Integer id) {
        return playersRepository.findByPid(id).map(this::mapToDTO).orElseThrow();
    }

    public PlayersDTO savePlayer(final PlayersDTO player) {
        Players entity = mapFromDTO(player);
        return mapToDTO(playersRepository.save(entity));
    }

    public PlayersDTO updatePlayer(final PlayersDTO player, final Integer id) {
        Players entity = mapFromDTO(player);
        return playersRepository.findByPid(id)
                .map(update -> {
                    update = entity;
                    return mapToDTO(playersRepository.save(update));
                }).orElseThrow();
    }

    public void deleteById(final Integer id) {
        playersRepository.deleteById(id);
    }

    PlayersDTO mapToDTO(final Players entity) {
        final PlayersDTO dto = new PlayersDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    Players mapFromDTO(final PlayersDTO dto) {
        Players entity = new Players();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
