package br.senai.sc.supertrunfospringnovo.service;

import br.senai.sc.supertrunfospringnovo.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.repository.CardRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CardService {

    private CardRepository cardRepository;

    public Card create(Card card){
        return cardRepository.save(card);
    }

    public List<Card> readAll(){
        return cardRepository.findAll();
    }

    public Page<Card> pageReadAll(int page, int size){
        Pageable pageable = PageRequest.of(page, size);
        return cardRepository.findAll(pageable);
    }

    public Card readSpecific(Integer idCard){
        Optional<Card> optionalCard = cardRepository.findById(idCard);
        if (optionalCard.isPresent()){
            return optionalCard.get();
        } else {
            throw new RuntimeException("\nCarta não encontrada!");
        }
    }

    public Card updateCard(Card card){
        return create(card);
    }

    public void deleteCard(Integer idCard){
        cardRepository.deleteById(idCard);
    }
}
