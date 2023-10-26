package Lab5;

public class Task1 {
	public static int[][] add(int[][] a, int[][] b) {
		int rows = a.length;
		int cols = a[0].length;
		// Check if the matrices are of order 2
		if (rows != 2 || cols != 2 || rows != b.length || cols != b[0].length) {
			// Throw an exception if not
			throw new IllegalArgumentException("Matrices are not of order 2.");
		}
		int[][] result = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}

		return result;
	}

	public static int[][] subtract(int[][] a, int[][] b) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = a[i][j] - b[i][j];
			}
		}

		return result;
	}

	public static int[][] multiply(int[][] a, int[][] b) {
		int rowsA = a.length;
		int colsA = a[0].length;
		int rowsB = b.length;
		int colsB = b[0].length;

		if (colsA != rowsB) {
			throw new IllegalArgumentException("Matrices are not compatible for multiplication.");
		}

		int[][] result = new int[rowsA][colsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				for (int k = 0; k < colsA; k++) {
					result[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		return result;
	}

	public static int[][] transpose(int[][] a) {
		int rows = a.length;
		int cols = a[0].length;
		int[][] result = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[j][i] = a[i][j];
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[][] a = { { 1, 2 }, { 4, 5 } };
		int[][] b = { { 7, 8 }, { 9, 10 } };

		System.out.println("Ma trận a:");
		printMatrix(a);
		System.out.println("Ma trận b:");
		printMatrix(b);

		System.out.println("Phép cộng hai ma trận:");
		int[][] c = Task1.add(a, b);
		printMatrix(c);

		System.out.println("Phép trừ hai ma trận:");
		int[][] d = Task1.subtract(a, b);
		printMatrix(d);

		System.out.println("Phép nhân hai ma trận:");
		int[][] e = Task1.multiply(a, b);
		printMatrix(e);

		System.out.println("Phép chuyển vị ma trận a:");
		int[][] f = Task1.transpose(a);
		printMatrix(f);
	}

	public static void printMatrix(int[][] matrix) {
		for (int[] row : matrix) {
			for (int element : row) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

}
