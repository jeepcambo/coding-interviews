package codingInterviews;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Stack;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class StringArrayMatrix {

    private static final class TokenIterator implements Iterator<String> {


        private final StringTokenizer tokenizer;



        TokenIterator(String input) {
            super();
            this.tokenizer = new StringTokenizer(input);
        }

        @Override
        public boolean hasNext() {
            return tokenizer.hasMoreTokens();
        }

        @Override
        public String next() {
            return tokenizer.nextToken();
        }
    }

    private static final class Tokenizer implements Iterable<String> {

        private final String input;

        Tokenizer(String input) {
            super();
            this.input = input;
        }

        @Override
        public Iterator<String> iterator() {
            return new TokenIterator(input);
        }
    }


    private static final Pattern Number = Pattern.compile("\\d+");

    private static final Pattern Operator = Pattern.compile("[-+/*]");

    public static int evalRPN(Iterable<String> tokens) {
        Stack<Integer> stack = new Stack<>();

        try {
            for (String token : tokens) {
                if (Operator.matcher(token).matches()) {
                    int rhs = stack.pop().intValue();
                    int lhs = stack.pop().intValue();

                    switch (token.charAt(0)) {
                    case '+':
                        stack.push(Integer.valueOf(lhs + rhs));
                        break;
                    case '-':
                        stack.push(Integer.valueOf(lhs - rhs));
                        break;
                    case '*':
                        stack.push(Integer.valueOf(lhs * rhs));
                        break;
                    case '/':
                        if (rhs == 0) {
                            throw new ArithmeticException("division by zero");
                        }
                        stack.push(Integer.valueOf(lhs / rhs));
                        break;
                    }
                } else if (Number.matcher(token).matches()) {
                    stack.push(Integer.valueOf(token));
                } else {
                    throw new IllegalArgumentException(token);
                }
            }

            return stack.pop().intValue();
        } catch (EmptyStackException e) {
            // TODO map to better exception
            return 0;
        }
    }

    public static int evalRPN(String expr) {
        return evalRPN(new Tokenizer(expr));
    }

    public static String findLongestPalindrome(String word) {
        return null;
        // TODO return properly
    }

    public static void main(String[] args) {
        String[] tokens = new String[] { "4", "13", "5", "/", "+" };

        System.out.println(evalRPN(Arrays.asList(tokens)));

        System.out.println(evalRPN("4 13 5 / +"));

        for (String word : args) {
            System.out.println(findLongestPalindrome(word));
        }
    }
}
