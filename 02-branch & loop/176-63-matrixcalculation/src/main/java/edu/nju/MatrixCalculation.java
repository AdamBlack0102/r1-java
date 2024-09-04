package edu.nju;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 实现矩阵的加法、乘法以及控制台输出
 * 其中加法和乘法需要有两种实现方式
 * 1.传入一个矩阵进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 */
public class MatrixCalculation {
	int i=0, j=0, k=0;
	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @return result matrix = A + B
	 */
	public int[][] plus(int[][] A, int[][] B){
		// TODO
		int row_A = A.length;
		if (row_A != 0) {
			int col_A = A[0].length;
			int[][] result = new int[row_A][col_A];
			for (i = 0; i < row_A; i++) {
				for (j = 0; j < col_A; j++) {
					result[i][j] = A[i][j] + B[i][j];
				}
			}
			return result;
		}
		else{
			return new int[0][0];
		}
	}

	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @return result matrix = A * B
	 */
	public int[][] times(int[][] A, int[][] B){
		int row_A = A.length;
		int row_B = B.length;
		if(row_A != 0 && row_B != 0) {
			int col_A = A[0].length;
			int col_B = B[0].length;
			int[][] result = new int[row_A][col_B];
			for (i = 0; i < row_A; i++) {
				for (j = 0; j < col_B; j++) {
					for (k = 0; k < col_A; k++)
						result[i][j] += A[i][k] * B[k][j];
				}
			}
			return result;
		}
		else{
			return new int[0][0];
		}
	}

	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * 连续读入2个矩阵数据
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 */
	public int [][] plusFromConsole() {
		// TODO
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] R_C = reader.readLine().split(" ");
			int length_row = Integer.parseInt(R_C[0]);
			int length_column = Integer.parseInt(R_C[1]);
			int[][] matrixA = new int[length_row][length_column];

			for(int i=0;i<length_row;i++){
				String[] rowNum = reader.readLine().split(" ");
				for (int j=0;j<length_column;j++){
					matrixA[i][j] = Integer.parseInt(rowNum[j]);
				}
			}

			R_C = reader.readLine().split(" ");
			length_row = Integer.parseInt(R_C[0]);
			length_column = Integer.parseInt(R_C[1]);
			int[][] matrixB = new int[length_row][length_column];

			for(int i=0;i<length_row;i++){
				String[] rowNum = reader.readLine().split(" ");
				for (int j=0;j<length_column;j++){
					matrixB[i][j] = Integer.parseInt(rowNum[j]);
				}
			}
			reader.close();
			return plus(matrixA,matrixB);

		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

//	private int[][] getmartice() throws IOException {
//		BufferedReader in_matrix = new BufferedReader(new InputStreamReader(System.in));
//		String[] A_lines = in_matrix.readLine().split("\\r?\\n");
//
//		String[] A_size = A_lines[0].split(" ");
//		int row_A = Integer.parseInt(A_size[0]);
//		int col_A = Integer.parseInt(A_size[1]);
//
//		int [][] A = new int[row_A][col_A];
//		for(i=1;i<row_A+1;i++){
//			String[] row = A_lines[i].split(" ");
//			for (j = 0; j < col_A; j++) {
//				A[i][j] = Integer.parseInt(row[j]);
//			}
//		}
//
//		int pointer = row_A + 1;
//		String[] B_size = A_lines[pointer].split(" ");
//
//		int row_B = Integer.parseInt(B_size[0]);
//		int col_B = Integer.parseInt(B_size[1]);
//
//		int [][] B = new int[row_B][col_B];
//		for(i=pointer;i<pointer+row_B+1;i++){
//			String[] row = A_lines[i].split(" ");
//			for (j = 0; j < col_B; j++) {
//				B[i-pointer][j] = Integer.parseInt(row[j]);
//			}
//		}
//		return B;
//		in_martix.close();
//	}

	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 */
	public int[][] timesFromConsole() {
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] R_C = reader.readLine().split(" ");
			int length_row = Integer.parseInt(R_C[0]);
			int length_column = Integer.parseInt(R_C[1]);
			int[][] matrixA = new int[length_row][length_column];

			for(int i=0;i<length_row;i++){
				String[] rowNum = reader.readLine().split(" ");
				for (int j=0;j<length_column;j++){
					matrixA[i][j] = Integer.parseInt(rowNum[j]);
				}
			}

			R_C = reader.readLine().split(" ");
			length_row = Integer.parseInt(R_C[0]);
			length_column = Integer.parseInt(R_C[1]);
			int[][] matrixB = new int[length_row][length_column];

			for(int i=0;i<length_row;i++){
				String[] rowNum = reader.readLine().split(" ");
				for (int j=0;j<length_column;j++){
					matrixB[i][j] = Integer.parseInt(rowNum[j]);
				}
			}
			reader.close();
			return times(matrixA,matrixB);

		}catch (IOException e){
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 打印出该矩阵的数据
	 * 起始一个空行，结束一个空行
	 * 矩阵中每一行数据呈一行，数据间以空格隔开
	 * example：
	 *
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 *
	 */
	public void print(int[][] A){
		// TODO
		int row_A = A.length;
		int col_A = A[0].length;
		System.out.println("");
		for(i=0;i<row_A;i++){
			for(j=0;j<col_A-1;j++){
				System.out.print(A[i][j] + " ");
			}
			System.out.println(A[i][col_A-1]);
		}
		/* System.out.println(""); */
	}
}
