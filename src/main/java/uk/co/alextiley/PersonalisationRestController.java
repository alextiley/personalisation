package uk.co.alextiley;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Handles REST requests into the personalisation service
 */
@Controller
public class PersonalisationRestController {
	
	private static final Logger logger = LoggerFactory.getLogger(PersonalisationRestController.class);
	
	/*
	 * Retrieves a collection of personalised products for a given customer
	 */
	@RequestMapping(value = "/customer/{customerId}", method = RequestMethod.GET, produces = "application/json; charset=utf-8")
	public @ResponseBody List<DummyProduct> product(@PathVariable long customerId) {
		
		logger.info("Getting personalised products for /customer/" + customerId + ".");
		
		List<DummyProduct> products = new DummyPersonalisationServiceImpl().getPersonalisedProducts(customerId);
		
		return products;
	}

}