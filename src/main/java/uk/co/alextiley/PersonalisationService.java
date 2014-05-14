package uk.co.alextiley;

import java.util.List;

public interface PersonalisationService {
	public List<DummyProduct> getPersonalisedProducts(long customerId);
}