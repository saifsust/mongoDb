package org.javawebdevelopment.algorithms;

public class StringProcessor {

	// ------ properties -----//
	private static String boldStart = "<b>";
	private static String boldEnd = "</b>";
	private static String linkStart = "<a href='";
	private static String linkEnd = "'>" + boldStart + "Link Here" + boldEnd + "</a>";

	// ------ functionality --------/
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

}
