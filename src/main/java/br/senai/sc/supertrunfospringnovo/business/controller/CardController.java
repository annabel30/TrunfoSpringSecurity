package br.senai.sc.supertrunfospringnovo.business.controller;

import br.senai.sc.supertrunfospringnovo.business.model.DTO.CardDTO;
import br.senai.sc.supertrunfospringnovo.business.model.entity.Card;
import br.senai.sc.supertrunfospringnovo.business.service.CardService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/card")
public class CardController {

    private CardService cardService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Card> create(@RequestBody CardDTO cardDTO){
        Card card = new Card();
        BeanUtils.copyProperties(cardDTO, card);
        return ResponseEntity.ok(cardService.create(card));
    }

    @GetMapping("/all")
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<Card>> readAll(){
        return ResponseEntity.ok(cardService.readAll());
    }

    @GetMapping("/pageReadAll")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Page<Card>> readAll(@RequestParam(name = "page") int page, @RequestParam int size) {
        return ResponseEntity.status(HttpStatus.OK).body(cardService.pageReadAll(page, size));
    }

    @GetMapping("/specific/{idCard}")
    @PreAuthorize("permitAll()")
    public ResponseEntity<Card> readSpecific(@PathVariable Integer idCard){
        return ResponseEntity.ok(cardService.readSpecific(idCard));
    }

    @PutMapping("/edit/{idCard}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Card> edit(@PathVariable Integer idCard, @RequestBody CardDTO cardDTO){
        Card card = cardService.readSpecific(idCard);
        BeanUtils.copyProperties(cardDTO, card);
        return ResponseEntity.ok(cardService.updateCard(card));
    }

    @DeleteMapping("/delete/{idCard}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Card> deleteCard(@PathVariable Integer idCard){
        Card card = new Card();
        cardService.deleteCard(idCard);
        return ResponseEntity.ok(card);
    }
}