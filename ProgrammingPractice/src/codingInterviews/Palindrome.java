package codingInterviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Jeff
 */
public final class Palindrome {

	/**
	 * Find the longest palindromic substrings within the given string.
	 *
	 * @param s
	 *            the given string
	 * @return a list of the longest palindromic substrings
	 * @author Keith
	 */
	public static List<String> findLongestPalindromes(String s) {
		final int length = s.length();

		// Remove any capitalization.
		s = s.toLowerCase();

		final Set<String> palindromes = new TreeSet<>();

		palindromes.add(s);

		// Every string contains the zero-length palindrome.
		int longest = 0;

		// Now check for longer palindromes. Even indexes denote positions
		// centered on a character, odd positions are between characters.
		for (int idx = 0, lastIdx = length << 1; idx < lastIdx; ++idx) {
			int beg = idx / 2;
			int end = (idx + 1) / 2;

			for (; 0 <= beg && end < length && s.charAt(beg) == s.charAt(end); beg -= 1, end += 1) {
				int thisLength = end - beg + 1;

				if (thisLength >= longest) {
					if (thisLength > longest) {
						longest = thisLength;
						palindromes.clear();
					}

					palindromes.add(s.substring(beg, end + 1));
				}
			}
		}

		return new ArrayList<>(palindromes);
	}

	public static void main(String[] args) {
		System.out.println(findLongestPalindromes(""));
		System.out.println(findLongestPalindromes("abcade"));
		System.out.println(findLongestPalindromes("abbaxxabcd"));
	}
}
