package java15;

import java.io.UnsupportedEncodingException;

/**
 * Visit Link: http://www.fileformat.info/info/unicode/char/search.htm
 * Query for "U+1F972"
 * Click on Returned Result and find the row "C/C++/Java source code" which should show "\uD83E\uDD72"
 * 
 */
public class Unicode13Support {
	private static final String SMILING_FACE_WITH_TEAR = "\uD83E\uDD72";
	private static final String DISGUISED_FACE="\uD83E\uDD78";
	private static final String NINJA="\uD83E\uDD77";
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(SMILING_FACE_WITH_TEAR);
		System.out.println(DISGUISED_FACE);
		System.out.println(NINJA);
	}
}
