package mz.tecnhoplus.exrti.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.tecnhoplus.exrti.entity.RateEntity;
import mz.tecnhoplus.exrti.repository.RateRepository;


@Service
public class RateServiceImpl implements RateService {

	@Autowired
	private RateRepository rateRepository;

	@Override
	public RateEntity saveRate(RateEntity rateEntity) {
		// TODO Auto-generated method stub
		return rateRepository.save(rateEntity);
	}

	@Override
	public List<RateEntity> fetchRateEntityList() {
		// TODO Auto-generated method stub
		return (List<RateEntity>) rateRepository.findAll();
	}

	@Override
	public RateEntity updateRateEntity(RateEntity rateEntity, Long rateEntityId) {
		// TODO Auto-generated method stub
		RateEntity rteDB = rateRepository.findById(rateEntityId).get();

		if (Objects.nonNull(rateEntity.getCurrency()) && !"".equalsIgnoreCase(rateEntity.getCurrency())) {
			rteDB.setCurrency(rateEntity.getCurrency());
		}

		if (Objects.nonNull(rateEntity.getValue()) && !"".equalsIgnoreCase(rateEntity.getValue())) {
			rteDB.setValue(rateEntity.getValue());
		}

		return rateRepository.save(rteDB);
	}

	@Override
	public void deleteRateEntityById(Long rateEntityId) {
		// TODO Auto-generated method stub
		rateRepository.deleteById(rateEntityId);
	}

}
