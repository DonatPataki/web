package hu.unideb.webdev.service;

import hu.unideb.webdev.DTO.MatchesDTO;
import hu.unideb.webdev.repository.MatchesRepository;
import hu.unideb.webdev.repository.entity.Matches;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchesService {

    @Autowired
    private MatchesRepository matchesRepository;

    @Autowired
    private TeamsService teamsService;

    public List<MatchesDTO> getAllMatches() {
        return matchesRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public MatchesDTO getMatchById(final Integer id) {
        return matchesRepository.findByMid(id).map(this::mapToDTO).orElseThrow();
    }

    public MatchesDTO saveMatch(final MatchesDTO match) {
        Matches entity = mapFromDTO(match);
        return mapToDTO(matchesRepository.save(entity));
    }

    public MatchesDTO updateMatch(final MatchesDTO match, final Integer id) {
        Matches entity = mapFromDTO(match);
        return matchesRepository.findByMid(id)
                .map(update -> {
                    update = entity;
                    return mapToDTO(matchesRepository.save(update));
                }).orElseThrow();
    }

    public void deleteById(final Integer id) {
        matchesRepository.deleteById(id);
    }

    /**
     * entity -> DTO conversion
     * @param entity Matches
     * @return MatchesDTO
     */
    MatchesDTO mapToDTO(final Matches entity) {
        final MatchesDTO dto = new MatchesDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setTid1(teamsService.mapToDTO(entity.getTid1()));
        dto.setTid2(teamsService.mapToDTO(entity.getTid2()));
        return dto;
    }

    /**
     * DTO -> entity conversion
     * @param dto MatchesDTO
     * @return Matches
     */
    Matches mapFromDTO(final MatchesDTO dto) {
        Matches entity = new Matches();
        BeanUtils.copyProperties(dto, entity);
        entity.setTid1(teamsService.mapFromDTO(dto.getTid1()));
        entity.setTid2(teamsService.mapFromDTO(dto.getTid2()));
        return entity;
    }
}
