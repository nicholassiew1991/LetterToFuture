package com.nicholas.controller;

import com.nicholas.model.LetterForm;
import com.nicholas.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {

	private static final String MODEL = "model";

	@Autowired
	private LetterService letterService;

	@GetMapping
	public String index(Model model) {
		model.addAttribute(MODEL, new LetterForm());
		return "forms/letter";
	}

	@PostMapping
	public String submitLetter(@ModelAttribute(MODEL) LetterForm form, Errors result, Model model) {

		try {

			if (result.hasErrors()) {
				return "forms/letter";
			}
			else {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Date today = sdf.parse(sdf.format(new Date()));
				Date nextWeek = DateUtils.addWeeks(today, 1);
				Date inputDate = sdf.parse(form.getSendDate());

				if (inputDate.before(nextWeek)) {
					result.rejectValue("sendDate", "", "Send Date need at least 1 week.");
					return "forms/letter";
				}

				letterService.save(form);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return "forms/letter";
	}
}
