package codingInterviews;

import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * @author Jeff
 * @The goal is to find the longest palindromic substring within a provided
 *      String argument
 * 
 */
public class Palindrome {

	public static String[] findLongestPalindrome(String query) {
		Integer length = new Integer(query.length());

		// Remove any capitalization
		query = query.toLowerCase();
		if (length == 0)
			throw new Error("String is empty.");
		else {
			String longest = query.toString();
			if (length == 1)
				// The only letter must be the longest palindrome
				return new String[] { longest };
			else {
				// Check for longer palindromes
				for (int i = 0; i < length; i++) {
					Character toMatch = new Character(query.charAt(i));
					int palindrome_start = i;
					int palindrome_end = query.lastIndexOf(toMatch.charValue());
					if (palindrome_end != -1) {
						if (isPalindromic(query.substring(palindrome_start,
								palindrome_end))) {
							// TODO
						}

					}

				}
			}

			// TODO
			return new String[] { longest };
		}

	}

	private static boolean isPalindromic(String word) {
		//
		try {

			if ((word.length() & 1) == 0) {
				// Even
				String first_half = word.substring(0, (word.length() / 2));
				String end_half = new StringBuilder(word.substring(
						word.length() / 2, word.length())).reverse().toString();
				return first_half.equals(end_half);
			} else {
				// Odd
				int midPoint = (word.length() - 1) / 2;
				String first_half = word.substring(0, midPoint);
				String end_half = new StringBuilder(word.substring(
						midPoint + 1, word.length())).reverse().toString();
				return first_half.equals(end_half);
			}
		} catch (NullPointerException e) {
			System.err.println("NullPointerException: " + e.getMessage());
		}
		return false;

	}

	public static void main(String[] args) {
		String query = "abcdefgxoxyzz";

		// System.out.println(findLongestPalindrome(query));
		System.out.print(isPalindromic("xoxoxz"));
	}
}
