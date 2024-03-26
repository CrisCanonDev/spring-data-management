package com.ccdev.springdatajpa.testing;

import com.ccdev.springdatajpa.entities.entity5.Player;
import com.ccdev.springdatajpa.entities.entity5.Team;
import com.ccdev.springdatajpa.repositories.repository5.PlayerRepository;
import com.ccdev.springdatajpa.repositories.repository5.TeamRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class testing5 implements CommandLineRunner {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;
    @Override
    public void run(String... args) throws Exception {
        Team team = new Team();
        team.setName("FC Barcelona");

        Player player1 = new Player();
        player1.setName("Pedri");
        player1.setTshirtNumber(8);

        Player player2 = new Player();
        player2.setName("Lewandowski");
        player2.setTshirtNumber(9);

        team.getPlayers().add(player1);
        team.getPlayers().add(player2);

        teamRepository.save(team);

        //Read team and players
        Team teamSaved = teamRepository.findById(team.getId()).orElse(null);
        if(teamSaved != null){
            System.out.println("Team: "+ teamSaved.getName());
            System.out.println("Team's players (LAZY)");
            System.out.println(teamSaved);

            //Update player
            Player playerUpdate = teamSaved.getPlayers().get(0);
            playerUpdate.setName("Ter Stegen");
            playerUpdate.setTshirtNumber(1);


            //Delete a player
            teamSaved.getPlayers().remove(1);

            for (Player player: team.getPlayers()){
                System.out.println("* "+player.getName() + " - #"+player.getTshirtNumber());
            }

            teamRepository.delete(teamSaved);
        }

        //Verify if team has been deleted
        Team teamDeleted = teamRepository.findById(team.getId()).orElse(null);
        if(teamDeleted == null){
            System.out.println("Team deleted successfully");
        }
    }
}
