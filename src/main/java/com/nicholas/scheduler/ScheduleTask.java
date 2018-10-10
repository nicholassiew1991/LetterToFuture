package com.nicholas.scheduler;

import com.nicholas.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class ScheduleTask {

	@Autowired
	private LetterService letterService;

	@Scheduled(cron = "0 0 0 * * ?")
	public void sendLetters() {
		System.out.println(letterService.getLetterToSend());
	}
}
