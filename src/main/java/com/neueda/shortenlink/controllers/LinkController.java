package com.neueda.shortenlink.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.neueda.shortenlink.repository.LinkModel;
import com.neueda.shortenlink.repository.LinkRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
@Api(value = "Shorten Link API - Link Management")
@CrossOrigin(origins = "*")
public class LinkController {
	@Autowired
	LinkRepository linkRepositoty;

	@GetMapping("/links")
	@ApiOperation(value = "Return all the links")
	public List<LinkModel> getLinks() {
		return linkRepositoty.findAll();
	}

	@GetMapping("/link/{id}")
	@ApiOperation(value = "Return the link by id")
	public LinkModel getLink(@PathVariable(value = "id") String id) {
		return linkRepositoty.getOne(id);
	}

	@PostMapping("/link")
	@ApiOperation(value = "Save the real link")
	public LinkModel saveLink(@RequestBody String realLink) {
		LinkModel linkModel = new LinkModel();
		linkModel.setRealLink(realLink);
		return linkRepositoty.save(linkModel);
	}

	@DeleteMapping("/link")
	@ApiOperation(value = "Delete the link")
	public void deletetLink(@RequestBody LinkModel linkModel) {
		linkRepositoty.delete(linkModel);
	}

	@DeleteMapping("/link/{id}")
	@ApiOperation(value = "Delete the link by id")
	public void deletetLinkById(@PathVariable(value = "id") String id) {
		linkRepositoty.deleteById(id);
	}

	@PutMapping("/link")
	@ApiOperation(value = "Update the link")
	public LinkModel updateLink(@RequestBody LinkModel linkModel) {
		return linkRepositoty.save(linkModel);
	}
}
