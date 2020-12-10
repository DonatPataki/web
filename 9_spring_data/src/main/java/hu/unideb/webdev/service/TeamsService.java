package hu.unideb.webdev.service;

import hu.unideb.webdev.DTO.TeamsDTO;
import hu.unideb.webdev.repository.TeamsRepository;
import hu.unideb.webdev.repository.entity.Teams;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamsService {

    @Autowired
    private TeamsRepository teamsRepository;

    public List<TeamsDTO> getAllTeams() {
        return teamsRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public TeamsDTO getTeamById(Integer id) {
        return teamsRepository.findById(id).map(this::mapToDTO).orElseThrow();
    }

    public TeamsDTO saveTeam(final TeamsDTO team) {
        Teams entity = mapFromDTO(team);
        return mapToDTO(teamsRepository.save(entity));
    }

    public TeamsDTO updateTeam(final TeamsDTO team, final Integer id) {
        Teams entity = mapFromDTO(team);
        return teamsRepository.findById(id)
                .map(update -> {
                    update = entity;
                    return mapToDTO(teamsRepository.save(update));
                }).orElseThrow();
    }

    public void deleteById(final Integer id) {
        teamsRepository.deleteById(id);
    }

    /**
     * Entity -> DTO conversion
     * @param entity Teams
     * @return TeamsDTO
     */
    TeamsDTO mapToDTO(final Teams entity) {
        final TeamsDTO dto = new TeamsDTO();
        BeanUtils.copyProperties(entity, dto);
        return dto;
    }

    /**
     * DTO -> entity conversion
     * @param dto TeamsDTO
     * @return Teams
     */
    Teams mapFromDTO(final TeamsDTO dto) {
        Teams entity = new Teams();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
