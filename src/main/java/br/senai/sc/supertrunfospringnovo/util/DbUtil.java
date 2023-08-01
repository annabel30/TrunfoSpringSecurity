package br.senai.sc.supertrunfospringnovo.util;

import br.senai.sc.supertrunfospringnovo.repository.PlayerRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DbUtil {

    private PlayerRepository playerRepository;

    @PostConstruct
    public void fillDb(){

        playerRepository.deleteAll();

        

    }
}
