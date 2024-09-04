package cn.edu.nju.TicTacToe;
public class Board {
	/**
	 * 成员变量的初始化代码请修改，请灵活选择初始化方式
	 * 必要时可添加成员变量
	 */
	protected char[][] cells;
	public int size;
	protected GameChessStrategy chessStrategy;
	//	protected GameWinStrategy_HV winStrategy_HV;
//	protected GameWinStrategy_HV winStrategy_HVD;
	protected GameWinStrategy winStrategy;
	protected Player player = Player.X;

	/**
	 * 请修改构造方法，并添加合适的构造方法
	 */
//	public Board(int size){
//		cells = new char[3][3];
//		for(int i=0; i<3; i++){
//			for(int j=0; j<3; j++){
//				cells[i][j] = '_';
//			}
//		}
//
//		chessStrategy = new GameChessStrategy();
//		winStrategy = new GameWinStrategy_HVD();
//	}

	/**
	 *
	 * @param boardSize
	 * @param winStrategyIn
	 */

	public Board(int boardSize, GameChessStrategy chessStrategy, GameWinStrategy winStrategyIn){
		cells = new char[boardSize][boardSize];
		size = boardSize;
		for(int i=0; i<boardSize; i++){
			for(int j=0; j<boardSize; j++){
				cells[i][j] = '_';
			}
		}
		this.chessStrategy = chessStrategy;
		this.winStrategy = winStrategyIn;
	}

	/**
	 * @param move 下棋的位置
	 * @return 落棋之后的结果
	 */
	public Result nextMove(String move) {
		return chessStrategy.putChess(cells, nextPlay(), move, size, winStrategy);
		//updateBoard(chessStrategy.mode);
	}

	/**
	 * @return 下一个落棋的玩家
	 */
	protected Player nextPlay(){
		Player res = player;
		player = player == Player.X ? Player.O : Player.X;
		return res;
	}

//	protected void updateBoard(int mode){
//		if (chessStrategy.mode == 0){
//		}
//		else {
//
//		}
//	}

	/**
	 * 棋盘的输出方法，根据需要进行修改
	 */
	public void print(){
		StringBuilder head = new StringBuilder(" ");
		for (int i = 0; i < size; i++) {
			head.append(' ');
			head.append((char) ('A'+i));
		}
//		head.append((char) ('A'+size - 1));
//		head.append(' ');
		System.out.println(head.toString());
		if(chessStrategy.mode == 0) {
			for (int i = 0; i < size; i++) {
				System.out.print(i + 1);
				for (int j = 0; j < size; j++) {
					System.out.print(" " + cells[i][j]);
				}
				System.out.println();
			}
		}
		else if(chessStrategy.mode == 1){
			for (int i = 0; i < size; i++) {
				System.out.print(i + 1);
				for (int j = 0; j < size; j++) {
					if(whose(cells[i][j]) == Player.X) {
						System.out.print(" X");
					}
					else if(whose(cells[i][j]) == Player.O){
						System.out.print(" O");
					}
				}
				System.out.println();
			}
		}
		else System.err.println("Fatal Error");
	}

	public Player whose(char x){
		if(x <= 'z' && x >= 'a') {
			return Player.O;
		}
		else if(x <= 'Z' && x >= 'A'){
			return Player.X;
		}
		return Player.ERROR;
	}
}