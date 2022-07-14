package mz.tecnhoplus.exrti.service;

import java.util.List;

import mz.tecnhoplus.exrti.entity.ExchangeRateEntity;

public interface ExchangeRateService {

	// Save operation
	ExchangeRateEntity saveExchangeRateEntity(ExchangeRateEntity exchangeRateEntity);

	// Save operation with base
	ExchangeRateEntity saveExchangeRateEntityBase(ExchangeRateEntity exchangeRateEntity);

	// Read operation
	List<ExchangeRateEntity> fetchExchangeRateEntityList();

	// Update operation
	ExchangeRateEntity updateExchangeRateEntity(ExchangeRateEntity exchangeRateEntity, Long exchangeRateEntityId);

	// Delete operation
	void deleteExchangeRateEntityById(String rexchangeRateEntityId);

	// Read operation by id
	Object findExchangeRateEntityById(String rexchangeRateEntityId);

}
