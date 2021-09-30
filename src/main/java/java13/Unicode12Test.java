package java13;

import java.io.UnsupportedEncodingException;

public class Unicode12Test {

	private static final String PINCHING_HAND = "\uDD0F";
	private static final String YAWN_FACE = "\uDD71";
	private static final String WAFFLE = "\uDDC7";
	public static void main(String[] args) throws UnsupportedEncodingException {
		System.out.println(PINCHING_HAND);
		System.out.println(YAWN_FACE);
		System.out.println(WAFFLE);
	}

}
