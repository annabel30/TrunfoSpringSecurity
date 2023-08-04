package br.senai.sc.supertrunfospringnovo.security.repository;

import br.senai.sc.supertrunfospringnovo.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByPlayer_Name(String user);
}
