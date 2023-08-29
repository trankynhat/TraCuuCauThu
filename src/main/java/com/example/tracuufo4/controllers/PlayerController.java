package com.example.tracuufo4.controllers;


import com.example.tracuufo4.models.Player;
import com.example.tracuufo4.models.ResponseObject;
import com.example.tracuufo4.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/v1/Players")
public class PlayerController {
    //this link is http://localhost:8080/api/v1/Players
    @Autowired
    private PlayerRepository repository;

    @GetMapping("")
    List<Player> getAllPlayer() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<ResponseObject> findById(@PathVariable Long id) {
        Optional<Player> foundedPlayer = repository.findById(id);
        if (foundedPlayer.isPresent()) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Success", foundedPlayer)
            );
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("fail", "not found player", id));
        }
    }
    @PutMapping("/{id}")
    ResponseEntity<ResponseObject> updatePlayer(@PathVariable Long id, @RequestBody Player updatedPlayer) {
        Optional<Player> existingPlayerOptional = repository.findById(id);

        if (existingPlayerOptional.isPresent()) {
            Player existingPlayer = existingPlayerOptional.get();

            // Update the fields of the existing player with the new values
            existingPlayer.setPlayerName(updatedPlayer.getPlayerName());
            existingPlayer.setAge(updatedPlayer.getAge());
            existingPlayer.setPrice(updatedPlayer.getPrice());
            // You can update other fields similarly

            // Save the updated player
            repository.save(existingPlayer);

            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Update player successfully", ""));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Player not found", "")
            );
        }
    }
    @PostMapping("/insert")
    ResponseEntity<ResponseObject> insertPlayer(@RequestBody Player newPlayer) {
        List<Player> foundPlayers = repository.findByPlayerName(newPlayer.getPlayerName().trim());
        if (!foundPlayers.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "Player's name already use", "")
            );
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Insert player success", repository.save(newPlayer))
        );
    }


    @DeleteMapping("/{id}")
    ResponseEntity<ResponseObject> deletePlayer(@PathVariable Long id) {
        boolean exist = repository.existsById(id);
        if (exist) {
            repository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("ok", "Delete player successfully", ""));
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("failed", "Can't find player", "")
        );

    }

}
