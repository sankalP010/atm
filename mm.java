import java.util.Scanner;

public class MatrixMultiplication {
    
    public static int[][] matrixMultiplication(int[][] mat1, int[][] mat2) {
        int rows1 = mat1.length;
        int cols1 = mat1[0].length;
        int cols2 = mat2[0].length;
        
        int[][] res = new int[rows1][cols2];
        
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    res[i][j] += mat1[i][k] * mat2[k][j];
                }
            }
        }
        
        return res;
    }
    
    public static void displayMatrix(int[][] mat) {
        for (int[] row : mat) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
    
    public static int[][] getMatrixFromUser(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];
        
        System.out.println("Enter the elements of the matrix (separated by spaces):");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        
        return matrix;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of rows for Matrix 1: ");
        int rows1 = scanner.nextInt();
        
        System.out.print("Enter the number of columns for Matrix 1: ");
        int cols1 = scanner.nextInt();
        
        int[][] mat1 = getMatrixFromUser(rows1, cols1, scanner);
        
        System.out.print("Enter the number of rows for Matrix 2: ");
        int rows2 = scanner.nextInt();
        
        System.out.print("Enter the number of columns for Matrix 2: ");
        int cols2 = scanner.nextInt();
        
        int[][] mat2 = getMatrixFromUser(rows2, cols2, scanner);
        
        scanner.close();
        
        if (cols1 != rows2) {
            System.out.println("Error: Matrix multiplication not possible.");
            return;
        }
        
        int[][] result = matrixMultiplication(mat1, mat2);
        
        System.out.println("\nMatrix 1:");
        displayMatrix(mat1);
        
        System.out.println("\nMatrix 2:");
        displayMatrix(mat2);
        
        System.out.println("\nResultant Matrix:");
        displayMatrix(result);
    }
}
