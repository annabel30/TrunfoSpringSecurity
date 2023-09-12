package br.senai.sc.supertrunfospringnovo.security.model.entity;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.security.model.enums.Profile;
import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

@Data
@NoArgsConstructor
public class User implements UserDetails {

    private Player player;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public User(Player player) {
        this.player = player;
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    public String getUsername() {
        return player.getUsername();
    }
    public String getPassword() {
        return player.getPassword();
    }
    public List<Profile> getAuthorities() {
        return player.getAuthorities();
    }
}