package com.nicholas.dao;

import com.nicholas.dao.entity.Letter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LetterJpaRepository extends JpaRepository<Letter, Long> {

	@Query("FROM Letter l WHERE l.isSent = false AND l.sendDate <= CURRENT_DATE")
	List<Letter> getLetterToSend();
}
