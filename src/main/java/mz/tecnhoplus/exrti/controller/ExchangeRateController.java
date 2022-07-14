package mz.tecnhoplus.exrti.controller;

import java.io.IOException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	@PostMapping("/saveExchangeRateBase")
	public ExchangeRateEntity saveExchangeRateEntiryBase(@Valid @RequestBody ExchangeRateEntity exchangeRateEntity) {
		return exchangeRateService.saveExchangeRateEntityBase(exchangeRateEntity);
	}

	// read all operation
	@GetMapping("/exchangeRate")
	public List<ExchangeRateEntity> readExchangeRateEntity() {
		return exchangeRateService.fetchExchangeRateEntityList();
	}

	// read by ID
	@GetMapping("/exchangeRate/{exchangeRateEntityId}")
	public Object readExchangeRateEntityByID(@PathVariable("exchangeRateEntityId") String exchangeRateEntityId)
			throws IOException {
		return exchangeRateService.findExchangeRateEntityById(exchangeRateEntityId);
	}
}
