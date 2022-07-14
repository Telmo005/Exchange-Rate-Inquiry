package mz.tecnhoplus.exrti.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mz.tecnhoplus.exrti.entity.ExchangeRateEntity;
import mz.tecnhoplus.exrti.exception.ExceptionHandler;
import mz.tecnhoplus.exrti.service.ExchangeRateService;

@RestController
public class ExchangeRateController extends ExceptionHandler {

	@Autowired(required = false)
	private ExchangeRateService exchangeRateService;

	// Save operation
	@PutMapping("/saveExchangeRate")
	public ExchangeRateEntity saveExchangeRateEntiryComplt(@Valid @RequestBody ExchangeRateEntity exchangeRateEntity) {
		return exchangeRateService.saveExchangeRateEntity(exchangeRateEntity);
	}

	// Save operation
	@PutMapping("/saveExchangeRateBase")
	public ExchangeRateEntity saveExchangeRateEntiryBase(@Valid @RequestBody ExchangeRateEntity exchangeRateEntity) {
		return exchangeRateService.saveExchangeRateEntityBase(exchangeRateEntity);
	}

	// read operation
	@GetMapping("/ExchangeRate")
	public List<ExchangeRateEntity> ExchangeRateEntity() {
		return exchangeRateService.fetchExchangeRateEntityList();
	}
}
