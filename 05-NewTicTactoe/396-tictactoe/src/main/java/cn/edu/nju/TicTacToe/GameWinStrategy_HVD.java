package cn.edu.nju.TicTacToe;
/**
 * 横竖斜方式获胜对应的类，应该考虑到可扩展性，当有新的获胜模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */

//extends GameWinStrategy_HV
public class GameWinStrategy_HVD {
	/**
	 * 根据需要修改获胜的方法
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

			if(winChar == 0) {
				//对上方向加以检测
				int cntUp = 0;
				int cntDown = 0;
				for (int i = iPos; i < size; i++) {
					if (cells[i][jPos] == cells[iPos][jPos]) {
						cntUp++;
					}
				}

				//对下方向进行检测
				for (int i = iPos - 1; i >= 0; i--) {
					if (cells[i][jPos] == cells[iPos][jPos]) {
						cntDown++;
					}
				}
				if (cntDown + cntUp == size) {
					winChar = cells[iPos][jPos];
				}
			}

			//对角线进行检测
			if(winChar == 0) {
				//对右上方向加以检测
				int cntRightUp = 0;
				int cntLeftDown = 0;
				for (int i = iPos, j = jPos; i < size && j<size; i++, j++) {
					if (cells[i][j] == cells[iPos][jPos]) {
						cntRightUp++;
					}
				}

				//对左下方向进行检测
				for (int i = iPos-1, j = jPos-1; i > 0 && j>0; i--, j--) {
					if (cells[i][j] == cells[iPos][jPos]) {
						cntLeftDown++;
					}
				}
				if (cntLeftDown + cntRightUp == size) {
					winChar = cells[iPos][jPos];
				}
			}

			if(winChar == 0) {
				//对右上方向加以检测
				int cntRightDown = 0;
				int cntLeftUp = 0;
				for (int i = iPos, j = jPos; i < size && j >0; i++, j--) {
					if (cells[i][j] == cells[iPos][jPos]) {
						cntRightDown++;
					}
				}

				//对左下方向进行检测
				for (int i = iPos-1, j = jPos+1; i > 0 && j < size; i--, j++) {
					if (cells[i][j] == cells[iPos][jPos]) {
						cntLeftUp++;
					}
				}
				if (cntLeftUp + cntRightDown == size) {
					winChar = cells[iPos][jPos];
				}
			}
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