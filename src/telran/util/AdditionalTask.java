package telran.util;

public class AdditionalTask {

	public static int[] countLetters(String text) {
		text = text.toLowerCase();
		int[] counts = new int[26];

		char[] chars = text.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (Character.isLetter(c)) {
				int index = c - 'a';
				counts[index]++;
			}
		}

		return counts;
	}

	public static boolean hasValidBrackets(String text) {
		int roundBracketsCount = 0;
		int squareBracketsCount = 0;
		int curlyBracketsCount = 0;

		for (char c : text.toCharArray()) {
			if (c == '(') {
				roundBracketsCount++;
			} else if (c == ')') {
				roundBracketsCount--;
			} else if (c == '[') {
				squareBracketsCount++;
			} else if (c == ']') {
				squareBracketsCount--;
			} else if (c == '{') {
				curlyBracketsCount++;
			} else if (c == '}') {
				curlyBracketsCount--;
			}

			if (roundBracketsCount < 0 || squareBracketsCount < 0 || curlyBracketsCount < 0) {
				return false; // данный метод просто считает скобки. если учитывать их порядок - я нагуглил
								// про стек. но мы его еще не учили
			}
		}

		return roundBracketsCount == 0 && squareBracketsCount == 0 && curlyBracketsCount == 0;
	}
}