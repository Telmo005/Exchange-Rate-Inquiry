package mz.tecnhoplus.exrti.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mz.tecnhoplus.exrti.entity.ExchangeRateEntity;
import mz.tecnhoplus.exrti.entity.RateEntity;
import mz.tecnhoplus.exrti.exception.ExceptionHandler;
import mz.tecnhoplus.exrti.service.RateService;

@RestController
public class RateController extends ExceptionHandler{
	
	@Autowired(required=false) private RateService rateService;

	// Save operation
	@PostMapping("/saveRate")
	public RateEntity saveRateEntity(@Valid @RequestBody RateEntity rateEntity) {
		return rateService.saveRate(rateEntity);
	}
	
	// Save operation
	@GetMapping("/rates")
	public List<RateEntity> ExchangeRateEntity() {
		return rateService.fetchRateEntityList();
	}
}
