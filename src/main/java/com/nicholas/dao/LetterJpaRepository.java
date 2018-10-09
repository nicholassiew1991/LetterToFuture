package com.nicholas.dao;

import com.nicholas.dao.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LetterJpaRepository extends JpaRepository<Letter, Long> {
}
