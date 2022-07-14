package mz.tecnhoplus.exrti.service;

import java.util.List;


import mz.tecnhoplus.exrti.entity.RateEntity;

public interface RateService {

	// Save operation
	RateEntity saveRate(RateEntity rateEntity);

	// Read operation
	List<RateEntity> fetchRateEntityList();
	
	// Update operation
	RateEntity updateRateEntity(RateEntity rateEntity, Long rateEntityId);

	// Delete operation
	void deleteRateEntityById(Long rateEntityId);
}
