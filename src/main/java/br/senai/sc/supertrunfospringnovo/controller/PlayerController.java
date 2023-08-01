package br.senai.sc.supertrunfospringnovo.controller;

import br.senai.sc.supertrunfospringnovo.model.DTO.PlayerDTO;
import br.senai.sc.supertrunfospringnovo.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.service.PlayerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/player")
@CrossOrigin
public class PlayerController {

    PlayerService playerService;

    @PostMapping("/create")
    public ResponseEntity<Player> create(@RequestBody PlayerDTO playerDTO){
        Player player = new Player();
        BeanUtils.copyProperties(playerDTO, player);
        return ResponseEntity.ok(playerService.create(player));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Player>> readAll(){
        return ResponseEntity.ok(playerService.readAll());
    }

    @GetMapping("/specific/{idPlayer}")
    public ResponseEntity<Player> readSpecific(@PathVariable Integer idPlayer){
        return ResponseEntity.ok(playerService.readSpecific(idPlayer));
    }

    @GetMapping("/name/{namePlayer}")
    public ResponseEntity<Player> searchByName(@PathVariable String namePlayer){
        Integer idPlayer = 0;
        List<Player> list = playerService.readAll();
        for (Player player : list){
            if (player.getName().equals(namePlayer)){
                idPlayer = player.getIdPlayer();
            }
        }
        return ResponseEntity.ok(playerService.readSpecific(idPlayer));
    }

    @GetMapping("login/{namePlayer}/{password}")
    public ResponseEntity<Player> verifyLogin(@PathVariable String namePlayer, @PathVariable String password){
        List<Player> list = playerService.readAll();
        for (Player player : list){
            if (player.getName().equals(namePlayer)){
                if (player.getPassword().equals(password)){
                    return ResponseEntity.ok(player);
                }
            }
        }
        throw new RuntimeException();
    }

    @PutMapping("/edit/{idPlayer}")
    public ResponseEntity<Player> edit(@PathVariable Integer idPlayer, @RequestBody PlayerDTO playerDTO){
        Player player = playerService.readSpecific(idPlayer);
        BeanUtils.copyProperties(playerDTO, player);
        return ResponseEntity.ok(playerService.update(player));
    }

    @DeleteMapping("/delete/{idPlayer}")
    public ResponseEntity<Player> delete(@PathVariable Integer idPlayer){
        Player player = new Player();
        playerService.delete(idPlayer);
        return ResponseEntity.ok(player);
    }
}
