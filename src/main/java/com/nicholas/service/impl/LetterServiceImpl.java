package com.nicholas.service.impl;

import com.nicholas.dao.LetterJpaRepository;
import com.nicholas.dao.entity.Letter;
import com.nicholas.model.LetterForm;
import com.nicholas.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

@Service
public class LetterServiceImpl implements LetterService {

	@Autowired
	private LetterJpaRepository letterJpaRepository;

	@Override
	public List<Letter> getLetterToSend() {
		return letterJpaRepository.getLetterToSend();
	}

	@Override
	public Letter save(LetterForm form) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Letter letter = new Letter();
		letter.setRecipient(form.getEmail());
		letter.setContent(form.getContent());
		letter.setSendDate(sdf.parse(form.getSendDate()));
		letter.setIsSent(false);

		return letterJpaRepository.save(letter);
	}

	@Override
	public Letter save(Letter letter) {
		return letterJpaRepository.save(letter);
	}

	public void update(Letter letter) {
		//letterJpaRepository.save()
	}

}
