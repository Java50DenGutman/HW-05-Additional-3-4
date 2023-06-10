package telran.util.tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static telran.util.AdditionalTask.*;

public class AdditionalTaskTest {

	@Test
	void testCountLetters() {
		String text1 = "hello";
		String text2 = "world";
		int[] expected1 = { 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		int[] expected2 = { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 };
		assertArrayEquals(expected1, countLetters(text1));
		assertArrayEquals(expected2, countLetters(text2));
	}

	@Test
	void testHasValidBrackets() {
		String text = "aaaaaa (sdfsdfdsf[dfd(f)f] zcvzxcv {{[ghjk]}} asd )";
		assertTrue(hasValidBrackets(text));
		String text1 = "invalid (brackets order) dfgswfgsf(";
		assertFalse(hasValidBrackets(text1));
		String text2 = "invalid [brackets (nesting) order] wertrt)";
		assertFalse(hasValidBrackets(text2));
		String text3 = "((}{)([]))";
		assertFalse(hasValidBrackets(text3));

	}
}