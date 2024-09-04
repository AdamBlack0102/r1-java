package cn.edu.nju.TicTacToe;
/**
 * 横竖方式获胜对应的类
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameWinStrategy_HV {
	/**
	 * 自行实现检测获胜的方法
	 * @param cells  棋盘对应的char二维数组
	 * @return  检测结果
	 */
	public static Result check(char[][] cells, int size, int iPos, int jPos, int mode)
	{
		char winChar = 0;
		if(mode == 0){
			//对右方向加以检测
			int cntRight = 0;
			int cntLeft = 0;
			for(int i=jPos; i<size; i++){
				if(cells[iPos][i] == cells[iPos][jPos]){
					cntRight++;
				}
			}

			//对左方向进行检测
			for(int i=jPos-1; i>=0; i--){
				if(cells[iPos][i] == cells[iPos][jPos]){
					cntLeft++;
				}
			}
			if(cntLeft + cntRight == size) {
				winChar = cells[iPos][jPos];
			}

			//对上方向加以检测
			int cntUp = 0;
			int cntDown = 0;
			for(int i=iPos; i<size; i++){
				if(cells[i][jPos] == cells[iPos][jPos]){
					cntUp++;
				}
			}

			//对下方向进行检测
			for(int i=iPos-1; i>=0; i--){
				if(cells[i][jPos] == cells[iPos][jPos]){
					cntDown++;
				}
			}
			if(cntDown + cntUp == size) {
				winChar = cells[iPos][jPos];
			}
		}

		if( winChar == 0 && cells[1][1] != '_' &&
				( (cells[0][0] == cells[1][1] && cells[1][1] == cells[2][2])
						|| (cells[0][2] == cells[1][1] && cells[1][1] == cells[2][0]) )){
			winChar = cells[1][1];
		}

		switch(winChar){
			case 'X': return Result.X_WIN;
			case 'O': return Result.O_WIN;
			default: break;
		}

		for(int i = 0; i < size; ++i)
		{
			for(int j = 0; j < size; ++j)
			{
				if(cells[i][j] == '_')
					return Result.GAMING;
			}
		}
		return Result.DRAW;
	}
}