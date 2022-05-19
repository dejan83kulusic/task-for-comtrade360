package com.example.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "languages ")
public class Todo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;;
	@Column(name = "lang")
	private String lang;
	@Column(name = "messages")
	private String message;

	public Todo() {

	}

	public Todo(Integer id, String lang, String message) {
		super();
		this.id = id;
		this.lang = lang;
		this.message = message;

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", lang=" + lang + ", message=" + message + "]";
	}

}
