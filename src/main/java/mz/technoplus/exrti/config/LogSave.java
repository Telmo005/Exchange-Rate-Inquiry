package mz.technoplus.exrti.config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Telmo Jr.
 * @Date : 15-07-2022
 * @Contact: +258 84 20 10 505 Email: Telmo.sigauquejr@gmail.com
 * @Desc   : Registo de logs
 */
public class LogSave {
	static File file = null;
	private final static DateTimeFormatter mtf = DateTimeFormatter.ofPattern("MM-yyyy");
	private final static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static void createdDirectorylog() throws IOException {
		file = new File("C:/ExchangeRate/Log/" + mtf.format(LocalDateTime.now()));
		boolean b = false;
		if (!file.exists()) {
			b = file.mkdirs();
		}

		if (b) {
			System.out.println("Log directory created successfully");
			writeLog("Log directory created successfully");
		}
	}

	public static File CreateLogFile() throws IOException {
		createdDirectorylog();
		File file2 = new File(file.getAbsolutePath() + "/" + dtf.format(LocalDateTime.now()) + ".log");
		return file2;
	}

	public static void writeLog(String logs) throws IOException {
		BufferedWriter bw = null;
		File f = CreateLogFile();
		if (f.exists()) {
			bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile(), true));
			bw.newLine();
			bw.write(logs); // + "\n");
			bw.close();
		} else {
			f.createNewFile();
			bw = new BufferedWriter(new FileWriter(f.getAbsoluteFile(), true));
			bw.newLine();
			bw.write(logs);// + "\n");
			bw.close();
		}
	}
}
