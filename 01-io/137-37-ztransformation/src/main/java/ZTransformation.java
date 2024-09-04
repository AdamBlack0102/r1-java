
import java.util.Scanner;

public class ZTransformation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();
        int numRows = scanner.nextInt();

        if (numRows == 1) {
            System.out.print(str);
        } else {
            int len = str.length();
            char[][] matrix = new char[numRows][len];

            for (int i = 0; i < numRows; i++) {
                for (int j = 0; j < len; j++) {
                    matrix[i][j] = ' ';
                }
            }

            int row = 0;
            int col = 0;
            boolean goingDown = true;
            for (char c : str.toCharArray()) {
                matrix[row][col] = c;
                if (goingDown) {
                    row++;
                } else {
                    row--;
                    col++;
                }
                if (row == numRows - 1) {
                    goingDown = false;
                } else if (row == 0) {
                    goingDown = true;
                }
            }

            int count = 0;

            for (char[] colArray : matrix) {

                for (int i = 0; i < len; i++) {
                    System.out.print(colArray[i]);
                    if (matrix[count][i] == ' ') {
                        System.out.print(" ");
                    }
                }
                count++;

                if(count != numRows) {
                    System.out.println();
                }
            }
        }
        scanner.close();
    }
}

