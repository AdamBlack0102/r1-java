package cn.edu.nju.TicTacToe;
/**
 * 正常落子模式类，另一落子模式自行创建类并实现，应该考虑到可扩展性，当有新的落子模式出现时更易于添加
 * hint：采用接口的方式，接口与实现相分离
 * @author Xin Feng & Qiu Liu
 *
 */
public class GameChessStrategy {
	/**
	 * 落子方法，可根据需要自行调整传入参数
	 * @param cells  棋盘对应的char二维数组
	 * @param currentPlayer  当前落子的玩家
	 * @param chessPos  下棋位置的字符串表示
	 */
	public int mode = -1;
	public GameChessStrategy(int modeSelect){
		mode = modeSelect;
	}

	public Result putChess(char[][] cells, Player currentPlayer, String chessPos, int size, GameWinStrategy winStrategy)
	{
		int i = chessPos.charAt(1) - '1';
		int j = chessPos.charAt(0) - 'A';
		switch (mode){
			case 0:{
				if(cells[i][j]!='_')
					cells[i][j] = currentPlayer == Player.X ? 'X' : 'O';
				if(winStrategy == GameWinStrategy.HV) {
					return GameWinStrategy_HV.check(cells, size, i, j, mode);
				}
				else if(winStrategy == GameWinStrategy.HVD){
					return GameWinStrategy_HVD.check(cells, size, i, j, mode);
				}
				return Result.FATAL;
			}
			case 1:{
				for (int it = 0; i < size; i++) {
					for (int jt = 0; j < size; j++) {
						if(cells[it][jt] != '_'){
							cells[it][jt] -= 1;
							if(cells[it][jt] == 'A'){
								cells[it][jt] = '_';
							}
						}
					}
				}
				if(currentPlayer == Player.X){
					cells[i][j] = 'E';
				}
				else {
					cells[i][j] = 'e';
				}
				if(winStrategy == GameWinStrategy.HV) {
					return GameWinStrategy_HV.check(cells, size, i, j, mode);
				}
				else if(winStrategy == GameWinStrategy.HVD){
					return GameWinStrategy_HVD.check(cells, size, i, j, mode);
				}
				return Result.FATAL;
			}
			default: System.err.println("Invalid mode selection.");
				return Result.FATAL;
		}
	}
}

