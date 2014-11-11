package codingInterviews;

import java.util.Stack;

public class StringArrayMatrix {

	public static void main(String[] args) {

		String[] tokens = new String[] { "4", "13", "5", "/", "+" };
		System.out.println(evalRPN(tokens));
	}

	public static int evalRPN(String[] tokens) {
		int ans = 0;
		String operators = "+-*/";
		Stack<String> stack = new Stack<String>();
		for (String t : tokens) {
			if (!operators.contains(t)) {
				stack.push(t);
			} else {
				int a = Integer.valueOf(stack.pop());
				int b = Integer.valueOf(stack.pop());
				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;

				case "-":
					stack.push(String.valueOf(b - a));
					break;

				case "*":
					stack.push(String.valueOf(a * b));
					break;

				case "/":
					stack.push(String.valueOf(b / a));
					break;

				}

			}

		}// for
		ans = Integer.valueOf(stack.pop());
		return ans;

	}
}
