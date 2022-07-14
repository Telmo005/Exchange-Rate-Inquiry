package mz.tecnhoplus.exrti.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse {
	private String internalStatus;
	private String errorDescription;
	private String date;
	private String cause;
	private String localMessage;
}
