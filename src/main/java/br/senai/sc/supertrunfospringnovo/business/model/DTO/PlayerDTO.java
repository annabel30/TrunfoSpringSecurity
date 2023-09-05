package br.senai.sc.supertrunfospringnovo.business.model.DTO;

import br.senai.sc.supertrunfospringnovo.business.model.enums.Element;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Region;
import br.senai.sc.supertrunfospringnovo.business.model.enums.Weapon;
import br.senai.sc.supertrunfospringnovo.security.model.enums.Profile;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    private String username;
    private String password;

    private Integer age;
    private char gender;
    private Region region;
    private Weapon weapon;
    private Element element;

    @Enumerated(EnumType.STRING)
    private List<Profile> authorities;
}