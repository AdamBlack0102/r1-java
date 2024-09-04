/*
public class Game {
    char [][] board;

    public void InitBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '_';
            }
        }
    }

    public void GameBoard() {
        this.board = new char[3][3];
        InitBoard();
    }

    public boolean IsValidMove(int row, int col) {
        if (board[row][col] == '_' && row < 3 && col < 3) {
            return true;
        }
        return false;
    }

    public void Move(int row, int col, char symbol) {
        if(IsValidMove(row, col)) {
            board[row][col] = symbol;
        } else {
            System.out.println("Invalid move!");
        }
    }

    public boolean CheckWin(char symbol) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol ) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (board[0][i] == symbol && board[1][i] == symbol && board[2][i] == symbol ) {
                return true;
            }
        }

        return (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) ||
                (board[2][0] == symbol && board[1][1] == symbol && board[0][2] == symbol);
    }
    
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public class Player {
        private char symbol;

        public Player(char symbol) {
            this.symbol = symbol;
        }

        public char getSymbol() {
            return symbol;
        }

        public void Move(GameBoard board, int row, int col) {
            board.Move(row, col, symbol);
        }
    }
    public Result playGame(String s){

		return null;
    }

    
    public static void main(String[] args){
        Game game = new Game();
        Result result = game.playGame("B2,C2,C1,A3,B3,B1,A2,B2,C3,A1,A3,B3,C2,B1,B2,A2,A1,C1,C3");
        System.out.println(result);
    }
}
*/

public class Game {
    //模拟棋盘的数组。0代表未操作，1代表X已落子此处，-1代表Y已落子此处
    private int size = 3;
    private int winLen = 3;
    private int [][] chessborad = new int [size][size];
    private int remain = size*size;
    //游戏主方法playGame
    //输入为对弈双方轮番落子的位置，以英文逗号为间隔，X先走
    public Result playGame(String s){
        String [] operations = s.split(",");
        int cnt = 0;
        for (String steps:operations
        ) {
            char op = '\0';
            if((cnt & 1) == 0){op = 'X';}
            else {op = 'Y';}
            if(placeChess(steps, op)){
                remain--;
            }
            if(op == 'X'){
                if(win(1)){
                    printChessBoard();
                    return Result.X_WIN;
                }
            }
            else if(op == 'Y'){
                if(win(-1)){
                    printChessBoard();
                    return Result.O_WIN;
                }
            }

            if(remain == 0){
                printChessBoard();
                return Result.DRAW;
            }
            printChessBoard();
            cnt++;
        }
        return Result.GAMING;
    }

    private boolean placeChess(String s, char player){
        int row = -1, col = -1;
//        switch (s.charAt(0)){
//            case 'A': {row = 0; break;}
//            case 'B': {row = 1; break;}
//            case 'C': {row = 2; break;}
//        }
        col = s.charAt(0) - 'A';
        row = s.charAt(1) - '0' - 1;

        if(chessborad[row][col] == 0){
            switch (player){
                case 'X': {chessborad[row][col] = 1; break;}
                case 'Y': {chessborad[row][col] = -1; break;}
            }
            return true;
        }
        else{
            return false;
        }
    }

    private boolean win(int op){
        //boolean result = false;
        //右倾判断
        for (int i = 0; i < winLen; i++) {
            if(chessborad[i][i] != op){
                break;
            }
            if(i == winLen - 1){
                return true;
            }
        }
        //左斜判断
        for (int i = 0; i < winLen; i++) {
            if(chessborad[i][size - i - 1] != op){
                break;
            }
            if(i == winLen - 1){
                return true;
            }
        }
        //竖列判断
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < winLen; j++) {
                if(chessborad[size - j - 1][i] != op){
                    break;
                }
                if(j == winLen - 1){
                    return true;
                }
            }
        }
        //横行判断
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < winLen; j++) {
                if(chessborad[i][size - j - 1] != op){
                    break;
                }
                if(j == winLen - 1){
                    return true;
                }
            }
        }
        return false;
    }

    private void printChessBoard(){
        System.out.println("  A B C");
        for (int i = 0; i < size; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < size; j++) {
                switch (chessborad[i][j]){
                    case 1:{System.out.print("X");break;}
                    case 0:{System.out.print("_");break;}
                    case -1:{System.out.print("O");break;}
                }
                if(j != size -1){
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

