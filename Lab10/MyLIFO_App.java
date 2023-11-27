package Lab10;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MyLIFO_App {
	// This method reserves the given array
	// 1,2,3 => 3,2,1
	public static <E> void reserve(E[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			E temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==>false
	public static boolean isCorrect(String input) {
		Stack<Character> stack = new Stack<>();

		for (char ch : input.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (ch == ')' && !stack.isEmpty() && stack.peek() == '(') {
				stack.pop();
			} else if (ch == ']' && !stack.isEmpty() && stack.peek() == '[') {
				stack.pop();
			} else if (ch == '}' && !stack.isEmpty() && stack.peek() == '{') {
				stack.pop();
			} else {
				return false; // Unmatched closing parenthesis
			}
		}

		return stack.isEmpty(); // Check if any unmatched opening parentheses are left
	}

	public static int evaluateExpression(String expression) {
		Stack<Integer> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int index = 0;

		while (index < expression.length()) {
			char ch = expression.charAt(index);

			if (Character.isDigit(ch)) {
				int num = 0;
				while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
					num = num * 10 + Character.getNumericValue(expression.charAt(index));
					index++;
				}
				operands.push(num);
			} else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
				while (!operators.isEmpty() && precedence(operators.peek()) >= precedence(ch)) {
					processOperator(operands, operators);
				}
				operators.push(ch);
				index++;
			} else if (ch == '(') {
				int closingIndex = findClosingParenthesis(expression, index);
				operands.push(evaluateExpression(expression.substring(index + 1, closingIndex)));
				index = closingIndex + 1;
			} else {
				index++; // Ignore other characters
			}
		}

		while (!operators.isEmpty()) {
			processOperator(operands, operators);
		}

		return operands.pop();
	}

	private static int findClosingParenthesis(String expression, int start) {
		int count = 0;
		int index = start;

		while (index < expression.length()) {
			char ch = expression.charAt(index);

			if (ch == '(') {
				count++;
			} else if (ch == ')') {
				count--;
				if (count == 0) {
					return index;
				}
			}
			index++;
		}

		throw new IllegalArgumentException("Unbalanced parentheses");
	}

	private static void processOperator(Stack<Integer> operands, Stack<Character> operators) {
		char operator = operators.pop();
		int operand2 = operands.pop();
		int operand1 = operands.pop();
		operands.push(applyOperator(operand1, operand2, operator));
	}

	private static int applyOperator(int operand1, int operand2, char operator) {
		switch (operator) {
		case '+':
			return operand1 + operand2;
		case '-':
			return operand1 - operand2;
		case '*':
			return operand1 * operand2;
		case '/':
			if (operand2 != 0) {
				return operand1 / operand2;
			} else {
				throw new ArithmeticException("Division by zero");
			}
		default:
			throw new IllegalArgumentException("Invalid operator: " + operator);
		}
	}

	private static int precedence(char operator) {
		return (operator == '+' || operator == '-') ? 1 : (operator == '*' || operator == '/') ? 2 : 0;
	}

	// method stutter that accepts a queue of integers as a parameter and replaces
	// every element of the queue with two copies of that element
	// front [1, 2, 3] back
	// becomes [2,3,1,1]->[3,1,1,2,2]
	// front [1, 1, 2, 2, 3, 3] back
	public static <E> void stutter(Queue<E> input) {
		int size = input.size();
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			input.offer(element);
			input.offer(element);
		}
	}

	// Method mirror that accepts a queue of strings as a
	// parameter and appends the queue's contents to itself in reverse order
	// front [a, b, c] back
	// becomes
	// front [a, b, c, c, b, a] back
	public static <E> void mirror(Queue<E> input) {
		int size = input.size();
		Stack<E> stack = new Stack<>();

		// Push elements onto the stack
		for (int i = 0; i < size; i++) {
			E element = input.poll();
			stack.push(element);
			input.offer(element);
		}

		// Pop elements from the stack and add them back to the queue
		while (!stack.isEmpty()) {
			input.offer(stack.pop());
		}
	}

	public static void main(String[] args) {
		Integer[] integerArray = { 1, 2, 3, 4, 5 };
		System.out.println("Original Integer Array: " + Arrays.toString(integerArray));

		reserve(integerArray);
		System.out.println("Reversed Integer Array: " + Arrays.toString(integerArray));

		// Example with String array
		String[] stringArray = { "apple", "banana", "cherry" };
		System.out.println("Original String Array: " + Arrays.toString(stringArray));

		reserve(stringArray);
		System.out.println("Reversed String Array: " + Arrays.toString(stringArray));

		System.out.println(isCorrect("{([])}")); // true
		System.out.println(isCorrect("()[]{}")); // true
		System.out.println(isCorrect("([)]")); // false
		System.out.println(isCorrect("((")); // false
		System.out.println(isCorrect("[(()])")); // false
		System.out.println(isCorrect("([(([]))][]{}())")); // true

		String expression = "51 + (54 *(3+2))";
		System.out.println("Result of expression: " + evaluateExpression(expression));

		Queue<Integer> intQueue = new LinkedList<>(Arrays.asList(1, 2, 3));
		stutter(intQueue);
		System.out.println("Stuttered Queue: " + intQueue);

		Queue<String> stringQueue = new LinkedList<>(Arrays.asList("a", "b", "c"));
		mirror(stringQueue);
		System.out.println("Mirrored Queue: " + stringQueue);
	}

}