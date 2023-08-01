package br.senai.sc.supertrunfospringnovo.business.repository;

import br.senai.sc.supertrunfospringnovo.business.model.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {
}
