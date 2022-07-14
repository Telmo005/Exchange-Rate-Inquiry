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

		String errorDescription = ex.getMessage() + " ";
		ErrorResponse err = new ErrorResponse("FAILURE", errorDescription.toUpperCase(),
				dtf.format(LocalDateTime.now()), ex.getMessage().toUpperCase(), errorDescription.toUpperCase());
		LogSave.writeLog(dtf.format(LocalDateTime.now()) + "- Response error: " + errorDescription.toUpperCase());
		return new ResponseEntity<>(err, new HttpHeaders(), HttpStatus.EXPECTATION_FAILED);
	}
}
