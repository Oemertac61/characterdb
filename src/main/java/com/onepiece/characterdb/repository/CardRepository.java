package com.onepiece.characterdb.repository;

import com.onepiece.characterdb.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CardRepository extends JpaRepository<Card, Long> {
}
