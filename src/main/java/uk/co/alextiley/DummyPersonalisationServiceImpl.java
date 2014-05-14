package uk.co.alextiley;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Proof of concept - returns a collection of products to the controller
 */
public class DummyPersonalisationServiceImpl implements PersonalisationService {
	
	private static final Logger logger = LoggerFactory.getLogger(DummyPersonalisationServiceImpl.class);
	
	public List<DummyProduct> getPersonalisedProducts(long customerId) {
		
		List<DummyProduct> products = new ArrayList<DummyProduct>();
		
		products.add(new DummyProduct(1, "Cotton Dress"));
		products.add(new DummyProduct(2, "Silk Gloves"));
		products.add(new DummyProduct(3, "Cashmere Sweater"));
		products.add(new DummyProduct(4, "Nylon Tights"));
		products.add(new DummyProduct(5, "Levi Jeans"));
		
		logger.info("Product results: " + products.toString());

		return products;
	}

}