package com.example.tracuufo4.repositories;

import com.example.tracuufo4.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player,Long> {
    List<Player> findByPlayerName(String playerName);


}
