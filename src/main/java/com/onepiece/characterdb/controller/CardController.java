package com.onepiece.characterdb.controller;

import com.onepiece.characterdb.model.Card;
import com.onepiece.characterdb.repository.CardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cards")
@CrossOrigin(origins = "*")
public class CardController {

    private final CardRepository repository;

    public CardController(CardRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Card> getAllCards() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Card getCard(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Card addCard(@RequestBody Card card) {
        return repository.save(card);
    }

    @PutMapping("/{id}")
    public Card updateCard(@PathVariable Long id, @RequestBody Card updatedCard) {
        Optional<Card> optional = repository.findById(id);
        if (optional.isPresent()) {
            Card card = optional.get();
            card.setName(updatedCard.getName());
            card.setCardType(updatedCard.getCardType());
            card.setColor(updatedCard.getColor());
            card.setAttribute(updatedCard.getAttribute());
            card.setPower(updatedCard.getPower());
            card.setCost(updatedCard.getCost());
            card.setEffect(updatedCard.getEffect());
            card.setImageUrl(updatedCard.getImageUrl());
            return repository.save(card);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteCard(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
