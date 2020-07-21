package com.neueda.shortenlink.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<LinkModel, String> {
	
	
}
