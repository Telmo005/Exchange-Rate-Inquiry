package mz.tecnhoplus.exrti.exception;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mz.tecnhoplus.exrti.config.LogSave;
import mz.tecnhoplus.exrti.response.ErrorResponse;
/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc : Padronização de erros
 *  
 */
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
	
	public static ResponseEntity<Object> handleyAnyException(String msg, String localMessage, HttpStatus httpStatus)
			throws IOException {

		String errorDescription = msg;
		ErrorResponse err = new ErrorResponse("FAILURE", errorDescription,
				dtf.format(LocalDateTime.now()), msg, localMessage);
		LogSave.writeLog(dtf.format(LocalDateTime.now()) + "- Response error: " + errorDescription);
		return new ResponseEntity<>(err, new HttpHeaders(), httpStatus);
	}
}
