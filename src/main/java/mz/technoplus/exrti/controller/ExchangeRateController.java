package mz.technoplus.exrti.controller;

import java.io.IOException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import mz.technoplus.exrti.entity.ExchangeRateEntity;
import mz.technoplus.exrti.exception.ExceptionHandler;
import mz.technoplus.exrti.service.ExchangeRateService;
/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc : 
 */
@RestController
@Api(value = "Consulta de cambio")
public class ExchangeRateController extends ExceptionHandler {

	@Autowired(required = false)
	private ExchangeRateService exchangeRateService;

	// Save operation
	@ApiOperation(value = "Faz o registo do câmbio actual")
	@PostMapping("/saveExchangeRate")
	public ExchangeRateEntity saveExchangeRateEntiryBase(@Valid @RequestBody ExchangeRateEntity exchangeRateEntity) {
		return exchangeRateService.saveExchangeRateEntityBase(exchangeRateEntity);
	}

	// read all operation
	@ApiOperation(value = "Apresenta a lista de cambios registados")
	@GetMapping("/exchangeRate")
	public Object readExchangeRateEntity() throws IOException {
		return exchangeRateService.fetchExchangeRateEntityList();
	}

	// read by ID
	@ApiOperation(value = "Apresenta registos de cambio consoante a moeda")
	@GetMapping("/exchangeRate/{base_code}")
	public Object readExchangeRateEntityByID(@PathVariable("base_code") String exchangeRateEntityId)
			throws IOException {
		return exchangeRateService.findExchangeRateEntityById(exchangeRateEntityId);
	}
}
