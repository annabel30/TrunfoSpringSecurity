package br.senai.sc.supertrunfospringnovo.util;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.business.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Element;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Region;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Weapon;
import br.senai.sc.supertrunfospringnovo.business.repository.CardRepository;
import br.senai.sc.supertrunfospringnovo.business.repository.PlayerRepository;
import br.senai.sc.supertrunfospringnovo.security.model.entity.User;
import br.senai.sc.supertrunfospringnovo.security.model.enums.Profile;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

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
        admin.setPassword(new BCryptPasswordEncoder().encode("123"));
        admin.setAge(100);
        admin.setGender('M');
        admin.setRegion(Region.Fontaine);
        admin.setElement(Element.Hydro);
        admin.setWeapon(Weapon.Catalyst);
        admin.setAuthorities(List.of(Profile.ADMIN));
        userRepository.save(admin);

        Player player = new Player();

        player.setUsername("annabel");
        player.setPassword(new BCryptPasswordEncoder().encode("123"));
        player.setAge(19);
        player.setGender('F');
        player.setRegion(Region.Sumeru);
        player.setElement(Element.Dendro);
        player.setWeapon(Weapon.Sword);
        player.setAuthorities(List.of(Profile.ADMIN));
        userRepository.save(player);

//       --------- card ---------
        Card zhongli = new Card();

        zhongli.setName("Zhongli");
        zhongli.setAtk(1700);
        zhongli.setCriticalRate(70);
        zhongli.setCriticalDamage(120);
        zhongli.setElementalMastery(70);
        zhongli.setEnergyRecharge(120);
        zhongli.setImage("https://d3ugyf2ht6aenh.cloudfront.net/stores/001/167/768/products/chocolate-barra-hersheys-tab-87g-ao-leit1-3628db9f27e63be46815944038711957-1024-1024.jpg");
        zhongli.setElement(Element.Geo);
        zhongli.setRegion(Region.Liyue);
        cardRepository.save(zhongli);

        Card kazuha = new Card();

        kazuha.setName("Kazuha");
        kazuha.setAtk(1139);
        kazuha.setCriticalRate(37);
        kazuha.setCriticalDamage(157);
        kazuha.setElementalMastery(623);
        kazuha.setEnergyRecharge(140);
        kazuha.setImage("https://d3ugyf2ht6aenh.cloudfront.net/stores/001/167/768/products/chocolate-barra-hersheys-tab-87g-ao-leit1-3628db9f27e63be46815944038711957-1024-1024.jpg");
        kazuha.setElement(Element.Anemo);
        kazuha.setRegion(Region.Inazuma);
        cardRepository.save(kazuha);

        Card alhaitham = new Card();

        alhaitham.setName("Alhaitham");
        alhaitham.setAtk(1570);
        alhaitham.setCriticalRate(63);
        alhaitham.setCriticalDamage(172);
        alhaitham.setElementalMastery(447);
        alhaitham.setEnergyRecharge(173);
        alhaitham.setImage("https://d3ugyf2ht6aenh.cloudfront.net/stores/001/167/768/products/chocolate-barra-hersheys-tab-87g-ao-leit1-3628db9f27e63be46815944038711957-1024-1024.jpg");
        alhaitham.setElement(Element.Dendro);
        alhaitham.setRegion(Region.Sumeru);
        cardRepository.save(alhaitham);
    }
}