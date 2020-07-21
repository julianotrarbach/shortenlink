package com.neueda.shortenlink.repository;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@EnableAutoConfiguration
@Entity
@Table(name="TB_LINK", schema = "shortenlinkapi")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LinkModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")	
	private String shortLink;

	@Column( length = 100000 )
	private String realLink;
	
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



	
	
	
}
