package hu.unideb.webdev.repository;

import hu.unideb.webdev.repository.entity.MatchStats;
import hu.unideb.webdev.repository.entity.MatchesStatsIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchStatsRepository extends JpaRepository<MatchStats, MatchesStatsIdentity> {

}
