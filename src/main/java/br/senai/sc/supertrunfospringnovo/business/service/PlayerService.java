package br.senai.sc.supertrunfospringnovo.business.service;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.business.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    private PlayerRepository playerRepository;

    public Player create(Player player){
        return playerRepository.save(player);
    }

    public List<Player> readAll(){
        return  playerRepository.findAll();
    }

    public Player readSpecific(Integer idPlayer){
        Optional<Player> optionalPlayer = playerRepository.findById(idPlayer);
        if (optionalPlayer.isPresent()){
            return optionalPlayer.get();
        } else {
            throw new RuntimeException("\nJogador não encontrado!");
        }
    }

    public Player update(Player player){
        return create(player);
    }

    public void delete(Integer idPlayer){
        playerRepository.deleteById(idPlayer);
    }
}
