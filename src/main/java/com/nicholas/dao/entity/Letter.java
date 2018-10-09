package com.nicholas.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "letter")
public class Letter {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long letterId;

	private String recipient;

	private String content;

	private Date sendDate;

	private boolean isSent;

	public long getLetterId() {
		return letterId;
	}

	public void setLetterId(long letterId) {
		this.letterId = letterId;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public boolean isSent() {
		return isSent;
	}

	public void setIsSent(boolean sent) {
		isSent = sent;
	}
}
