package com.nicholas.service;

import com.nicholas.model.LetterForm;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestLetterService {

	@Autowired
	private LetterService service;

	@Test
	public void testSave() throws Exception {
		LetterForm form = new LetterForm();
		form.setEmail("nicholassiew1991@hotmail.com");
		form.setContent("abc");
		form.setSendDate("2018-10-20");
		service.save(form);
	}
}
