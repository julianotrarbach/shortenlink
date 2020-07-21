package com.neueda.shortenlink.controllers;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.neueda.shortenlink.repository.LinkModel;
import com.neueda.shortenlink.repository.LinkRepository;

//Prometheus counter package.
import io.prometheus.client.Counter;
//Prometheus Histogram package.
import io.prometheus.client.Histogram;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "redir")
@Api(value = "Shorten Link API - Redirect")
@CrossOrigin(origins = "*")
public class RedirectController {

	// Define a counter metric for /prometheus
	static final Counter requests = Counter.build().name("requests_total").help("Total number of requests.").register();
	// Define a histogram metric for /prometheus
	static final Histogram requestLatency = Histogram.build().name("requests_latency_seconds")
			.help("Request latency in seconds.").register();

	@Autowired
	LinkRepository linkRepositoty;

	@RequestMapping(value = "/{shortLink}", method = RequestMethod.GET)
	@ApiOperation(value="Redirect the short link to the real link")
	public void method(HttpServletResponse httpServletResponse, @PathVariable(value = "shortLink") String shortLink) {
		// Increase the counter metric
		requests.inc();
		// Start the histogram timer
		Histogram.Timer requestTimer = requestLatency.startTimer();
		try {
			LinkModel linkModel = linkRepositoty.getOne(shortLink);
			String realLink = linkModel.getRealLink();
			
			if(realLink.contains("http://") == false && realLink.contains("https://") == false)
			{
				realLink = "http://" + realLink;
			}
			
			httpServletResponse.setHeader("Location", realLink);
			httpServletResponse.setStatus(302);
		}catch(javax.persistence.EntityNotFoundException erro) {
			throw new ResponseStatusException(
					  HttpStatus.NOT_FOUND, "Sorry, but the short link not found"
					);
		}catch(Exception erro) {
			throw new ResponseStatusException(
					  HttpStatus.INTERNAL_SERVER_ERROR, "Sorry, but we have a problem, try again later"
					);
		}
		finally {
			// Stop the histogram timer
			requestTimer.observeDuration();
		}

	}

}

