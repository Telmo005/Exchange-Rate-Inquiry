package mz.technoplus.exrti.service;

import java.io.IOException;

import mz.technoplus.exrti.entity.ExchangeRateEntity;

/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc :
 * 
 */
public interface ExchangeRateService {

	// Save operation
	ExchangeRateEntity saveExchangeRateEntity(ExchangeRateEntity exchangeRateEntity);

	// Save operation with base
	ExchangeRateEntity saveExchangeRateEntityBase(ExchangeRateEntity exchangeRateEntity);

	// Read operation
	Object fetchExchangeRateEntityList() throws IOException;

	// Update operation
	ExchangeRateEntity updateExchangeRateEntity(ExchangeRateEntity exchangeRateEntity, Long exchangeRateEntityId);

	// Delete operation
	void deleteExchangeRateEntityById(String rexchangeRateEntityId);

	// Read operation by id
	Object findExchangeRateEntityById(String rexchangeRateEntityId);

}
