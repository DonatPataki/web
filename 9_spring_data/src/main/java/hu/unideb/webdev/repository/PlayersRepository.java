package hu.unideb.webdev.repository;

import hu.unideb.webdev.repository.entity.Players;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayersRepository extends JpaRepository<Players, Integer> {

    Optional<Players> findByPid(Integer pid);
}
