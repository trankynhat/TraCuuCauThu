package com.example.tracuufo4.database;

import com.example.tracuufo4.models.Player;
import com.example.tracuufo4.repositories.PlayerRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.slf4j.Logger;
@Configuration
public class Database {
    private static final Logger logger;

    static {
        logger = (Logger) LoggerFactory.getLogger(Database.class);
    }

    @Bean
    CommandLineRunner initDatabase(PlayerRepository playerRepository){

        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                //Player player1 = new Player( "Reece James", 22, 100D,"");
                //Player player2 = new Player( "Kyle Walker", 33, 40D,"");
                //logger.info("insert data "+playerRepository.save(player1));
                //logger.info("insert data "+playerRepository.save(player2));
            }
        };
    }
}
