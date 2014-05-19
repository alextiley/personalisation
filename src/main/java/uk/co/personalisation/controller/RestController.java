package uk.co.personalisation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import uk.co.personalisation.model.EventType;
import uk.co.personalisation.model.UserEvent;
import uk.co.personalisation.service.PersonalisationService;
import uk.co.personalisation.service.PersonalisationServiceImpl;

/**
 * Handles REST requests into the personalisation service
 */
@Controller
public class RestController {
	
	private static final Logger logger = LoggerFactory.getLogger(RestController.class);
	
	/*
	 * Retrieves a collection of personalised products for a given customer
	 */
	@RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET)
	public @ResponseBody String getCustomerRecommendations(@PathVariable long customerId) {
		
		logger.info("Getting personalised products for /customer/" + customerId + ".");
		
		PersonalisationService service = new PersonalisationServiceImpl();
		String products = service.getPersonalisedProducts(customerId);
		
		return products;
	}

	/*
	 * Tracks a user event and stores it away in the database
	 */
	@RequestMapping(value = "/event/track", method = RequestMethod.PUT)
	public ResponseEntity<String> trackEvent(@RequestBody UserEvent event) {
		
		long productId = event.getProductId();
		Enum<EventType> eventType = event.getType();
		
		logger.info("Attempting to track user event. productId=" + productId + ", eventType=" + eventType);
		//int score = new EventServiceImpl().getEventScore(productId, eventType);

		//event.setScore(score);

		return new ResponseEntity<String>(HttpStatus.OK);
	}
}