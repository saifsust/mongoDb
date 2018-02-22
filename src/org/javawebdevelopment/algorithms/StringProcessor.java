package org.javawebdevelopment.algorithms;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class StringProcessor {

	// ------ properties -----//
	private static final String STORE_PATH = "H:\\stsWorkplace\\HibernateSpringForBeginner\\javawebdevelopment\\WebContent\\STORE_HOUSE\\";
	private static String boldStart = "<b>";
	private static String boldEnd = "</b>";
	private static String linkStart = "<a href='";
	private static String linkEnd = "'>" + boldStart + "Link Here" + boldEnd + "</a>";

	// ------ functionality --------/

	/****** string formation for modifying ****/

	public static String descriptionProcess(String description) {

		String temp = "";
		boolean found = true;
		for (int i = 0; i < description.length(); i++) {
			switch (description.charAt(i)) {
			case '|':
				if (found == true) {
					temp += boldStart;
					found = false;
				} else {
					temp += boldEnd;
					found = true;
				}
				break;

			case '<':
				temp += linkStart;
				break;
			case '>':
				temp += linkEnd;
				break;
			default:
				temp += description.charAt(i);

			}
		}

		return temp;
	}

	/**** file storage path finder *****/

	public static String fileLinkProcessor(MultipartFile file, HttpServletRequest httpServletRequest)
			throws IllegalStateException, IOException {
		String storePath = STORE_PATH;
		// System.out.println(file.getContentType());
		byte[] fileByte = file.getBytes();
		String realStorePath = storePath + File.separator + file;
		File directory = new File(realStorePath);
		// System.out.println(System.getProperty("catalina.home"));
		file.transferTo(directory);
		return realStorePath;
	}

	/***** current taker ******/

	public static String getCurrentTime() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

}
