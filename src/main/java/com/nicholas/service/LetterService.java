package com.nicholas.service;

import com.nicholas.dao.entity.Letter;
import com.nicholas.model.LetterForm;

import java.util.List;

public interface LetterService {

	Letter save(LetterForm form) throws Exception;

	List<Letter> getLetterToSend();
}
