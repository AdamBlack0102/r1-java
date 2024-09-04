import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 矩阵类，实现矩阵的加法，矩阵乘法，点乘以及转置方法
 * 其中加法和点乘方法需要有两种实现方式
 * 1.传入一个MyMatrix对象进行2个矩阵的操作
 * 2.从控制台（console）读入一个矩阵数据，再进行操作
 * 所有的数据均为int型
 * 输入数据均默认为正确数据，不需要对输入数据进行校验
 * @author Ray Liu & Qin Liu
 *
 */
public class MyMatrix {
	private int[][] data;

	/**
	 * 构造函数，参数为2维int数组
	 * a[i][j]是矩阵中的第i+1行，第j+1列数据
	 * @param a
	 */
	public MyMatrix(int[][] a){
		this.data = a;
	}

	public int[][] getData() {
		return data;
	}

	/**
	 * 实现矩阵加法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix plus(MyMatrix B){
		int [][] B_matrix = B.getData();
		int rows = this.data.length;
		int cols = this.data[0].length;
		int [][] result = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = B_matrix[i][j] + this.data[i][j];
			}
		}
		return new MyMatrix(result);
	}


	/**
	 * 实现矩阵乘法，返回一个新的矩阵
	 * @param B
	 * @return
	 */
	public MyMatrix times(MyMatrix B){
		int [][] B_matrix = B.getData();
		int row_a = this.data.length;
		int col_a = this.data[0].length;
		int col_b = B_matrix[0].length;
		int [][] result = new int[row_a][col_b];
		for (int i = 0; i < row_a; i++) {
			for (int j = 0; j < col_b; j++) {
				for (int k = 0; k < col_a; k++) {
					result[i][j] += this.data[i][k] * B_matrix[k][j];
				}
			}

		}
		return new MyMatrix(result);
	}

	/**
	 * 实现矩阵的点乘，返回一个新的矩阵
	 * @param b
	 * @return
	 */
	public MyMatrix times(int b){
		int rows = this.data.length;
		int cols = this.data[0].length;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				this.data[i][j] *= b;
			}
		}
		return  this;
	}

	/**
	 * 实现矩阵的转置，返回一个新的矩阵
	 * @return
	 */
	public MyMatrix transpose(){
		int rows = this.data.length;
		int cols = this.data[0].length;
		int [][] result = new int[cols][rows];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[j][i] = this.data[i][j];
			}
		}
		return new MyMatrix(result);
	}

	/**
	 * 从控制台读入矩阵数据，进行矩阵加法，读入数据格式如下：
	 * m n
	 * m * n 的数据方阵，以空格隔开
	 * example:
	 * 4 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 1 2 3
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix plusFromConsole(){
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] R_C = reader.readLine().split(" ");
			int length_row = Integer.parseInt(R_C[0]);
			int length_column = Integer.parseInt(R_C[1]);
			int [][] B_matrix = new int[length_row][length_column];

			for(int i=0;i<length_row;i++){
				String[] rowNum = reader.readLine().split(" ");
				for (int j=0;j<length_column;j++){
					this.data[i][j] += Integer.parseInt(rowNum[j]);
				}
			}
		}catch (IOException e){
			e.printStackTrace();
		}
		return this;
	}


	/**
	 * 输入格式同上方法相同
	 * 实现矩阵的乘法
	 * 返回一个新的矩阵
	 * @return
	 */
	public MyMatrix timesFromConsole(){
		int [][] B_matrix = new int[0][0];
		MyMatrix B =new MyMatrix(B_matrix);
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String[] R_C = reader.readLine().split(" ");
			int length_row = Integer.parseInt(R_C[0]);
			int length_column = Integer.parseInt(R_C[1]);
			B_matrix = new int[length_row][length_column];

			for(int i=0;i<length_row;i++){
				String[] rowNum = reader.readLine().split(" ");
				for (int j=0;j<length_column;j++){
					B_matrix[i][j] += Integer.parseInt(rowNum[j]);
				}
			}
			B =new MyMatrix(B_matrix);
			return times(B);
		}catch (IOException e){
			e.printStackTrace();
		}
		return B;
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
	public void print(){
		StringBuilder result = new StringBuilder();
		int row_A = this.data.length;
		int col_A = this.data[0].length;
		System.out.println("");
		for (int[] datum : this.data) {
			for (int j = 0; j < col_A - 1; j++) {
				result.append(datum[j]).append(" ");
			}
			result.append(datum[col_A - 1]).append(System.lineSeparator());
		}
		System.out.println(result.toString());
	}
}
