package com.nicholas.scheduler;

import com.nicholas.service.LetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduleTask {

	@Autowired
	private LetterService letterService;

	@Autowired
	private JavaMailSender mailSender;

	@Value("${spring.mail.username}")
	private String sender;

	@Scheduled(cron = "0 0 0 * * ?")
	public void sendLetters() {

		letterService.getLetterToSend().forEach(x -> {
			try {

				SimpleMailMessage smm = new SimpleMailMessage();
				smm.setFrom(sender);
				smm.setTo(x.getRecipient());
				smm.setSubject("Letter from the past");
				smm.setText(x.getContent());
				mailSender.send(smm);

				x.setIsSent(true);
				letterService.save(x);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
