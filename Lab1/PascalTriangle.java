public class PascalTriangle {
	public static void printPascalTriangle(int n) {
		for (int i = 0; i < n; i++) {
			for (int space = 1; space < n - i; ++space) {
				System.out.print("  ");
			}
			for (int j = 0; j <= i; j++) {
				int value;
				if (j == 0 || i == j)
					value = 1;
				else
					value = (int) (factorial(i) / (factorial(j) * factorial(i - j)));
				System.out.printf("%4d", value);
			}
			System.out.println();
		}
	}

	public static long factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	public static int[] getPascalTriangle(int n) {
		if (n == 1) {
			return new int[] { 1 };
		}
		int[] prevRow = getPascalTriangle(n - 1);
		int[] nextRow = generateNextRow(prevRow);
		return nextRow;
	}

	public static int[] generateNextRow(int[] prevRow) {
		int length = prevRow.length + 1;
		int[] nextRow = new int[length];
		nextRow[0] = 1;
		nextRow[length - 1] = 1;
		for (int i = 1; i < length - 1; i++) {
			nextRow[i] = prevRow[i - 1] + prevRow[i];
		}
		return nextRow;
	}

	public static void main(String[] args) {
		System.out.println("Test case 1: n = 1");
		PascalTriangle.printPascalTriangle(1);
		System.out.println("Test case 2: n = 2");
		PascalTriangle.printPascalTriangle(2);
		System.out.println("Test case 3: n = 3");
		PascalTriangle.printPascalTriangle(3);
		System.out.println("Test case 4: n = 4");
		PascalTriangle.printPascalTriangle(4);
		System.out.println("Test case 5: n = -1");
		PascalTriangle.printPascalTriangle(-1);
		System.out.println("Test case 6: n = 0");
		PascalTriangle.printPascalTriangle(0);
	}
}
