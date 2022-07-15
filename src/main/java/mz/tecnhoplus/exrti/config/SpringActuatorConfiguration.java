package mz.tecnhoplus.exrti.config;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc : Configurações de registo de logs (requisicoes e resposta)
 */
@Configuration
public class SpringActuatorConfiguration {
	final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository() {
			@Override
			public void add(HttpTrace trace) {
				try {
					String request = trace.getRequest().getUri().toString();
					if (!request.contains("testServices")) {
						LogSave.writeLog(dtf.format(LocalDateTime.now()) + " - Request - " + request + "\n"
								+ dtf.format(LocalDateTime.now()) + " - Response Status - "
								+ trace.getResponse().getStatus());
					}

				} catch (IOException e) {
				}

			}
		};
	}
}
