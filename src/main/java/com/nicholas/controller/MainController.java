package com.nicholas.controller;

import com.nicholas.model.LetterForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.apache.commons.lang3.time.DateUtils;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MainController {

	@GetMapping
	public String index(Model model) {
		model.addAttribute("model", new LetterForm());
		return "forms/letter";
	}

	@PostMapping
	public String submitLetter(@Valid LetterForm form, Errors result, Model model) {

		System.out.println(form);

		try {

			if (result.hasErrors()) {
				System.out.println(result);
				model.addAttribute("model", form);
				return "forms/letter";
			}
			else {

				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

				Date today = sdf.parse(sdf.format(new Date()));
				Date nextWeek = DateUtils.addWeeks(today, 1);
				Date inputDate = sdf.parse(form.getSendDate());

				if (inputDate.before(nextWeek)) {
					result.rejectValue("sendDate", "", "Send Date need at least 1 week.");
				}
			}
		}
		catch (Exception e) {

		}

		model.addAttribute("model", form);
		return "forms/letter";
	}
}
