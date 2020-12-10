package hu.unideb.webdev.repository;

import hu.unideb.webdev.repository.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MatchesRepository extends JpaRepository<Matches, Integer> {

    Optional<Matches> findByMid(Integer mid);
}
