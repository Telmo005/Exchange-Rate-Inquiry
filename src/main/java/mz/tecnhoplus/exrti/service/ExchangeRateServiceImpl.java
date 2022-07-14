package mz.tecnhoplus.exrti.service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mz.tecnhoplus.exrti.entity.ExchangeRateEntity;
import mz.tecnhoplus.exrti.exception.ExceptionHandler;
import mz.tecnhoplus.exrti.repository.ExchangeRateRepository;

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
	public ExchangeRateEntity saveExchangeRateEntityBase(ExchangeRateEntity exchangeRateEntity) {
		// TODO Auto-generated method stub
		Instant instant = Instant.now();
		Timestamp timestamp = Timestamp.from(instant);

		exchangeRateEntity.setTime_last_update_unix(instant.toEpochMilli());
		exchangeRateEntity.setTime_last_update_utc(instant.toString());
		exchangeRateEntity.setTime_next_update_unix(instant.toEpochMilli());
		exchangeRateEntity.setTime_next_update_utc(instant.toString());
		System.out.println(timestamp +"   "+ instant);
		return exchangeRateRepository.save(exchangeRateEntity);
	}

	@Override
	public List<ExchangeRateEntity> fetchExchangeRateEntityList() {
		// TODO Auto-generated method stub
		return (List<ExchangeRateEntity>) exchangeRateRepository.findAll();
	}

	@Override
	public ExchangeRateEntity updateExchangeRateEntity(ExchangeRateEntity exchangeRateEntity,
			Long exchangeRateEntityId) {
		// TODO Auto-generated method stub
		ExchangeRateEntity rteDB = exchangeRateRepository.findById(exchangeRateEntityId).get();

		if (Objects.nonNull(exchangeRateEntity.getBase_code())
				&& !"".equalsIgnoreCase(exchangeRateEntity.getBase_code())) {
			rteDB.setBase_code((exchangeRateEntity.getBase_code()));
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
				&& !"".equalsIgnoreCase(exchangeRateEntity.getTime_last_update_utc())) {
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

	@Override
	public void deleteRateEntityById(Long rexchangeRateEntityId) {
		// TODO Auto-generated method stub
		exchangeRateRepository.deleteById(rexchangeRateEntityId);
	}

}
