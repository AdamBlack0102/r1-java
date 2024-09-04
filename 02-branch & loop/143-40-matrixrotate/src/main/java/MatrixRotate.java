
import java.util.Scanner;

public class MatrixRotate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 输入矩阵大小
        int m = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] matrix = new int[m][n];

        // 输入矩阵元素
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        // 输入旋转角度
        int angle = scanner.nextInt();
        angle = angle % 360;

        // 计算旋转后的行列数
        int newM = angle == 90 || angle == 270 ? n : m;
        int newN = angle == 90 || angle == 270 ? m : n;

        // 创建旋转后的矩阵
        int[][] rotatedMatrix = new int[newM][newN];

        // 执行旋转
        if (angle == 90) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedMatrix[j][m - i - 1] = matrix[i][j];
                }
            }
        } else if (angle == 180) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedMatrix[m - i - 1][n - j - 1] = matrix[i][j];
                }
            }
        } else if (angle == 270) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    rotatedMatrix[n - j - 1][i] = matrix[i][j];
                }
            }
        }

        // 输出旋转后的矩阵
        for (int i = 0; i < newM; i++) {
            for (int j = 0; j < newN; j++) {
                System.out.print(rotatedMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
