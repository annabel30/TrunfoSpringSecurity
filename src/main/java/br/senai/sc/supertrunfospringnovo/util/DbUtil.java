package br.senai.sc.supertrunfospringnovo.util;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.business.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Element;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Region;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Weapon;
import br.senai.sc.supertrunfospringnovo.business.repository.CardRepository;
import br.senai.sc.supertrunfospringnovo.business.repository.PlayerRepository;
import br.senai.sc.supertrunfospringnovo.security.model.enums.Profile;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DbUtil {

    private PlayerRepository userRepository;
    private CardRepository cardRepository;

    @PostConstruct
    public void fillDb(){

        userRepository.deleteAll();
        cardRepository.deleteAll();

//       --------- user ---------
        Player admin = new Player();

        admin.setUsername("admin");
        admin.setAge(100);
        admin.setGender('M');
        admin.setRegion(Region.Fontaine);
        admin.setElement(Element.Hydro);
        admin.setWeapon(Weapon.Catalyst);

        admin.setAuthorities(List.of(Profile.ADMIN));
        admin.setEnabled(true);
        admin.setAccountNonLocked(true);
        admin.setAccountNonExpired(true);
        admin.setCredentialsNonExpired(true);
        admin.setPassword(new BCryptPasswordEncoder().encode("123"));
        userRepository.save(admin);

        Player player = new Player();

        player.setUsername("annabel");
        player.setAge(19);
        player.setGender('F');
        player.setRegion(Region.Sumeru);
        player.setElement(Element.Dendro);
        player.setWeapon(Weapon.Sword);

        player.setAuthorities(List.of(Profile.PLAYER));
        player.setEnabled(true);
        player.setAccountNonLocked(true);
        player.setAccountNonExpired(true);
        player.setCredentialsNonExpired(true);
        player.setPassword(new BCryptPasswordEncoder().encode("123"));
        userRepository.save(player);

//       --------- card ---------
        Card zhongli = new Card();

        zhongli.setName("Zhongli");
        zhongli.setAtk(1700);
        zhongli.setCriticalRate(70);
        zhongli.setCriticalDamage(120);
        zhongli.setElementalMastery(70);
        zhongli.setEnergyRecharge(120);
//        zhongli.setImage();
        zhongli.setElement(Element.Geo);
        zhongli.setRegion(Region.Liyue);
        cardRepository.save(zhongli);
    }
}