package com.nicholas.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;

@Component
public class ScheduleTask {

	@Scheduled(cron = "0 0 0 * * ?")
	public void sendLetters() {
		System.out.println(Calendar.getInstance());
	}
}
