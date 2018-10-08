package com.nicholas.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class LetterForm {

	@Email
	@NotNull
	private String email;

	@NotNull
	private String content;

	@NotNull
	private String sendDate;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	@Override
	public String toString() {
		return "LetterForm{" +
			"email='" + email + '\'' +
			", content='" + content + '\'' +
			", sendDate='" + sendDate + '\'' +
			'}';
	}
}
