import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows for the first matrix: ");
        int rows1 = scanner.nextInt();

        System.out.print("Enter the number of columns for the first matrix: ");
        int cols1 = scanner.nextInt();

        int[][] matrix1 = new int[rows1][cols1];

        System.out.println("Enter the elements of the first matrix:");
        enterMatrixElements(scanner, matrix1);

        System.out.print("Enter the number of rows for the second matrix: ");
        int rows2 = scanner.nextInt();

        System.out.print("Enter the number of columns for the second matrix: ");
        int cols2 = scanner.nextInt();

        int[][] matrix2 = new int[rows2][cols2];

        System.out.println("Enter the elements of the second matrix:");
        enterMatrixElements(scanner, matrix2);

        scanner.close();

        int[][] result = multiplyMatrices(matrix1, matrix2);

        System.out.println("Result:");
        printMatrix(result);
    }

    public static void enterMatrixElements(Scanner scanner, int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Enter element at position (" + (i + 1) + ", " + (j + 1) + "): ");
                matrix[i][j] = scanner.nextInt();
            }
        }
    }

    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;

        int[][] result = new int[rows1][cols2];

        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
            }
        }

        return result;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
