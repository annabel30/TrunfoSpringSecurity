package br.senai.sc.supertrunfospringnovo.security.service;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Player;
import br.senai.sc.supertrunfospringnovo.business.repository.PlayerRepository;
import br.senai.sc.supertrunfospringnovo.security.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JpaService implements UserDetailsService {

    private final PlayerRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = repository.findByUsername(username);
        if (player == null) {
            throw new UsernameNotFoundException("Usuário não encontrado!");
        }
        return new User(player);
    }
}