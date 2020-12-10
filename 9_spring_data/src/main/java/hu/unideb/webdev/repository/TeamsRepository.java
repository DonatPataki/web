package hu.unideb.webdev.repository;

import hu.unideb.webdev.repository.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeamsRepository extends JpaRepository<Teams, Integer> {

    Optional<Teams> findById(Integer id);

    void deleteById(Integer id);
}
