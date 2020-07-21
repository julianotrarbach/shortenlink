package com.neueda.shortenlink.models;


public class Formulario {
	private String shortLink;
	private String realLink;
	private String message;
	public String getShortLink() {
		return shortLink;
	}
	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}
	public String getRealLink() {
		return realLink;
	}
	public void setRealLink(String realLink) {
		this.realLink = realLink;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
