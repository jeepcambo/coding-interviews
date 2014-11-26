package codingInterviews;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jeff
 * @The goal is to find the longest palindromic substring within a provided
 *      String argument
 * 
 */
public class Palindrome {

	public static List<String> findLongestPalindrome(String s) {

		// Remove any capitalization

		if (s.isEmpty())
			throw new Error("String is empty.");
		else {
			s = s.toLowerCase();
			List<String> longest = new ArrayList<String>();
			longest.add(s.substring(0, 1));
			// Check for longer palindromes
			for (int i = 1; i < s.length(); i++) {
				// Odd palindrome
				int begin = i;
				int end = begin;

				while ((begin > 0) && (end < s.length() - 1)) {

					if (s.charAt(begin - 1) == s.charAt(end + 1)) {
						begin--;
						end++;
					} else {
						break;
					}
				}
				if (s.substring(begin, end + 1).length() > longest.get(0)
						.length()) {
					longest.clear();
					longest.add(s.substring(begin, end + 1));
				}

				else if (s.substring(begin, end + 1).length() == longest.get(0)
						.length())
					longest.add(s.substring(begin, end + 1));

				// TODO fix bugs in even
				// Even palindrome
				if (i < s.length() - 1) {
					// There can be no even palindrome if the pointer is already
					// at the last character
					begin = i;
					end = begin + 1;

					while ((begin > 0) && (end < s.length() - 1)) {

						if (s.charAt(begin - 1) == s.charAt(end + 1)) {
							begin--;
							end++;
						} else {
							break;
						}
					}

					if (s.substring(begin, end + 1).length() > longest.get(0)
							.length()) {
						longest.clear();
						longest.add(s.substring(begin, end + 1));
					}

					else if (s.substring(begin, end + 1).length() == longest
							.get(0).length())
						longest.add(s.substring(begin, end + 1));
				}

			}
			return longest;
		}

	}

	public static void main(String[] args) {

		// System.out.println(findLongestPalindrome(query));
		System.out.print(findLongestPalindrome("abbaxxabcd"));
	}
}
