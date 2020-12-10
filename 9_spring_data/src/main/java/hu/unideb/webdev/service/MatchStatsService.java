package hu.unideb.webdev.service;

import hu.unideb.webdev.DTO.MatchStatsDTO;
import hu.unideb.webdev.DTO.MatchesDTO;
import hu.unideb.webdev.DTO.MatchesStatsIdentityDTO;
import hu.unideb.webdev.DTO.request.MatchStatsUpdateRequest;
import hu.unideb.webdev.repository.MatchStatsRepository;
import hu.unideb.webdev.repository.entity.MatchStats;
import hu.unideb.webdev.repository.entity.Matches;
import hu.unideb.webdev.repository.entity.MatchesStatsIdentity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatchStatsService {

    @Autowired
    private MatchStatsRepository matchStatsRepository;

    @Autowired
    private TeamsService teamsService;

    @Autowired
    private PlayersService playersService;

    @Autowired
    private MatchesService matchesService;

    public List<MatchStatsDTO> getAllMatchStats() {
        return matchStatsRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    public MatchStatsDTO getMatchStatsById(final MatchesStatsIdentityDTO id) {
        MatchesStatsIdentity entityId = identityFromDTO(id);
        return matchStatsRepository.findById(entityId).map(this::mapToDTO).orElseThrow();
    }

    public MatchStatsDTO saveMatchStats(final MatchStatsDTO stats) {
        MatchStats entity = mapFromDTO(stats);
        return mapToDTO(matchStatsRepository.save(entity));
    }

    public MatchStatsDTO updateMatchStats(final MatchStatsUpdateRequest request) {
        MatchesStatsIdentity entityId = identityFromDTO(request.getMatchesStatsIdentityDTO());
        MatchStats entity = mapFromDTO(request.getMatchStatsDTO());
        return matchStatsRepository.findById(entityId)
                .map(update -> {
                    update = entity;
                    return mapToDTO(matchStatsRepository.save(update));
                }).orElseThrow();
    }

    public void deleteMatchStats(final MatchesStatsIdentityDTO id) {
        MatchesStatsIdentity entityId = identityFromDTO(id);
        matchStatsRepository.deleteById(entityId);
    }

    /**
     * Entity -> DTO conversion
     * @param entity MatchesStatsIdentity
     * @return MatchesStatsidentityDTO
     */
    MatchesStatsIdentityDTO identityToDTO(MatchesStatsIdentity entity) {
        final MatchesStatsIdentityDTO dto = new MatchesStatsIdentityDTO();
        dto.setMid(matchesService.mapToDTO(entity.getMid()));
        dto.setPid(playersService.mapToDTO(entity.getPid()));
        return dto;
    }

    /**
     * DTO -> entity conversion
     * @param dto MatchesStatsIdentityDTO
     * @return MatchesStatsidentity
     */
    MatchesStatsIdentity identityFromDTO(MatchesStatsIdentityDTO dto) {
        MatchesStatsIdentity entity = new MatchesStatsIdentity();
        entity.setMid(matchesService.mapFromDTO(dto.getMid()));
        entity.setPid(playersService.mapFromDTO(dto.getPid()));
        return entity;
    }

    /**
     * Entity -> DTO conversion
     * @param entity MatchStats
     * @return MatchStatsDTO
     */
    MatchStatsDTO mapToDTO(final MatchStats entity) {
        final MatchStatsDTO dto = new MatchStatsDTO();
        BeanUtils.copyProperties(entity, dto);
        dto.setMatchesStatsIdentity(identityToDTO(entity.getMatchesStatsIdentity()));
        dto.setTid(teamsService.mapToDTO(entity.getTid()));
        return dto;
    }

    /**
     * DTO -> entity conversion
     * @param dto MatchStatsDTO
     * @return MatchStats
     */
    MatchStats mapFromDTO(final MatchStatsDTO dto) {
        MatchStats entity = new MatchStats();
        BeanUtils.copyProperties(dto, entity);
        entity.setMatchesStatsIdentity(identityFromDTO(dto.getMatchesStatsIdentity()));
        entity.setTid(teamsService.mapFromDTO(dto.getTid()));
        return entity;
    }
}
