package mz.tecnhoplus.exrti.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mz.tecnhoplus.exrti.config.LogSave;
import mz.tecnhoplus.exrti.response.ErrorResponse;

public class ExceptionHandler {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	@org.springframework.web.bind.annotation.ExceptionHandler(value = { Exception.class })
	public ResponseEntity<Object> handleyAnyException(Exception ex) throws IOException {
		ErrorResponse err = null;
		if (ex.getMessage().equals("No value present")) {
			err = new ErrorResponse("FAILURE", "No data found", dtf.format(LocalDateTime.now()),
					"info@technoplus.co.mz", ex.getMessage());
		} else {
			err = new ErrorResponse("FAILURE", "Oucureu um erro ao tentar processar a operação.",
					dtf.format(LocalDateTime.now()), "info@technoplus.co.mz", ex.getCause().getMessage() + "");
		}

		LogSave.writeLog(dtf.format(LocalDateTime.now()) + "- Response error: " + ex.getCause());
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
	}
}
