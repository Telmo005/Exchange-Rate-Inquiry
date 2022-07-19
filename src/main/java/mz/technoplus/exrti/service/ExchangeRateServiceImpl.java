package mz.technoplus.exrti.service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import mz.technoplus.exrti.entity.ExchangeRateEntity;
import mz.technoplus.exrti.entity.RateEntity;
import mz.technoplus.exrti.exception.ExceptionHandler;
import mz.technoplus.exrti.repository.ExchangeRateRepository;

/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc :
 * 
 */
@Service
public class ExchangeRateServiceImpl extends ExceptionHandler implements ExchangeRateService {

	@Autowired
	private ExchangeRateRepository exchangeRateRepository;

	@Override
	public ExchangeRateEntity saveExchangeRateEntity(ExchangeRateEntity exchangeRateEntity) {
		// TODO Auto-generated method stub
		return exchangeRateRepository.save(exchangeRateEntity);
	}

	@Override
	public void deleteExchangeRateEntityById(String rexchangeRateEntityId) {
		// TODO Auto-generated method stub
		exchangeRateRepository.deleteById(rexchangeRateEntityId);
	}

	@Override
	public ExchangeRateEntity findExchangeRateEntityById(String rexchangeRateEntityId) {
		// TODO Auto-generated method stub
		return exchangeRateRepository.findById(rexchangeRateEntityId).get();
	}

	@Override
	public Object fetchExchangeRateEntityList() throws IOException {
		// TODO Auto-generated method stub
		List<ExchangeRateEntity> exchangeRateEntitys = exchangeRateRepository.findAll();
		if (exchangeRateEntitys.isEmpty()) {
			return ExceptionHandler.handleyAnyException("No data found", "No value present",
					HttpStatus.EXPECTATION_FAILED);
		} else {
			return exchangeRateEntitys;
		}
	}

	@Override
	public ExchangeRateEntity saveExchangeRateEntityBase(ExchangeRateEntity exchangeRateEntity) {
		// TODO Auto-generated method stub
		Instant instant = Instant.now();
		Timestamp timestamp = Timestamp.from(instant);

		exchangeRateEntity.setTime_last_update_unix(instant.toEpochMilli());
		exchangeRateEntity.setTime_last_update_utc(timestamp);
		exchangeRateEntity.setTime_next_update_unix(instant.toEpochMilli());
		exchangeRateEntity.setTime_next_update_utc(timestamp);
		exchangeRateEntity.setCreatedOn(timestamp);

		List<RateEntity> rateEntitys = exchangeRateEntity.getRateEntity();
		List<RateEntity> rateEntitys3 = new ArrayList<>();

		for (RateEntity rateEntity2 : rateEntitys) {
			rateEntity2.setCreatedOn(timestamp);
			rateEntitys3.add(rateEntity2);
		}

		exchangeRateEntity.setRateEntity(rateEntitys3);

		rateEntitys = null;
		rateEntitys3 = null;
		return exchangeRateRepository.save(exchangeRateEntity);
	}

	@Override
	public ExchangeRateEntity updateExchangeRateEntity(ExchangeRateEntity exchangeRateEntity,
			Long exchangeRateEntityId) {
		// TODO Auto-generated method stub
		ExchangeRateEntity rteDB = exchangeRateRepository.findById(exchangeRateEntityId.toString()).get();

		Instant instant = Instant.now();
		Timestamp timestamp = Timestamp.from(instant);
		rteDB.setUpdateOn(timestamp);

		if (Objects.nonNull(exchangeRateEntity.getBase_code())
				&& !"".equalsIgnoreCase(exchangeRateEntity.getBase_code())) {
			rteDB.setBase_code((exchangeRateEntity.getBase_code()));
			;
		}

		if (Objects.nonNull(exchangeRateEntity.getTime_eol_unix())
				&& !"".equalsIgnoreCase(exchangeRateEntity.getTime_eol_unix() + "")) {
			rteDB.setTime_eol_unix((exchangeRateEntity.getTime_eol_unix()));
		}

		if (Objects.nonNull(exchangeRateEntity.getTime_last_update_unix())
				&& !"".equalsIgnoreCase(exchangeRateEntity.getTime_last_update_unix() + "")) {
			rteDB.setTime_last_update_unix((exchangeRateEntity.getTime_last_update_unix()));
		}

		if (Objects.nonNull(exchangeRateEntity.getTime_last_update_utc())
				&& !"".equalsIgnoreCase(exchangeRateEntity.getTime_last_update_utc() + "")) {
			rteDB.setTime_last_update_utc((exchangeRateEntity.getTime_last_update_utc()));
		}

		if (Objects.nonNull(exchangeRateEntity.getTime_next_update_unix())
				&& !"".equalsIgnoreCase(exchangeRateEntity.getTime_next_update_unix() + "")) {
			rteDB.setTime_next_update_unix((exchangeRateEntity.getTime_next_update_unix()));
		}

		if (Objects.nonNull(exchangeRateEntity.getTime_next_update_utc())
				&& !"".equalsIgnoreCase(exchangeRateEntity.getTime_next_update_utc() + "")) {
			rteDB.setTime_next_update_utc((exchangeRateEntity.getTime_next_update_utc()));
		}

		return exchangeRateRepository.save(rteDB);
	}

}
