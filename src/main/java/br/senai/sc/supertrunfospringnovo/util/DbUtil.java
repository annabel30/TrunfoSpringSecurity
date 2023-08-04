package br.senai.sc.supertrunfospringnovo.util;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.business.repository.PlayerRepository;
import br.senai.sc.supertrunfospringnovo.security.model.User;
import br.senai.sc.supertrunfospringnovo.security.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
@AllArgsConstructor
public class DbUtil {

    private UserRepository userRepository;

    @PostConstruct
    public void fillDb(){

        userRepository.deleteAll();

        Player player = new Player();

        player.setIdPlayer(1);
        player.setName("annabel");
        player.setAge(19);
        player.setGender('F');
        player.setRegion("Sumeru");
        player.setElement("Hydro");
        player.setWeapon("Sword");

        User user = new User();

        user.setPassword(new BCryptPasswordEncoder().encode("123"));
        user.setPlayer(player);
        user.setEnabled(true);
        user.setAccountNonLocked(true);
        user.setCredentialsNonExpired(true);
        user.setAccountNonExpired(true);
        user.setAuthorities(new ArrayList<>());

        userRepository.save(user);
    }
}