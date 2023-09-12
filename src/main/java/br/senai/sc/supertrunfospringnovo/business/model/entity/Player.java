package br.senai.sc.supertrunfospringnovo.business.model.entity;

import br.senai.sc.supertrunfospringnovo.business.model.enums.Element;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Region;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Weapon;
import br.senai.sc.supertrunfospringnovo.security.model.enums.Profile;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlayer;

    private String username;

    private Integer age;
    private char gender;

    @Enumerated(EnumType.STRING)
    private Region region;
    @Enumerated(EnumType.STRING)
    private Weapon weapon;
    @Enumerated(EnumType.STRING)
    private Element element;

    private Integer defeats = 0;
    private Integer victories = 0;

    public void setDefeats() {
        this.defeats++;
    }
    public void setVictories() {
        this.victories++;
    }
}