import java.util.Scanner;

public class Game {
//    Chess can be "+1" or "-1"
    private int[][] chess = new int[3][3];
    public int win = 0;
    public int current_player = 1;
    public void printLayout(){

        String[][] strChess = new String[3][3];
        for(int row=0; row<3; row++){
            for(int col=0; col<3;col++){
                if (this.chess[row][col] == 1) {
                    strChess[row][col] = "O ";
                }
                else if(this.chess[row][col] == -1){
                    strChess[row][col] = "X ";
                }
                else{
                    strChess[row][col] = "  ";
                }
            }
        }
        String boundary = "+--+--+--+";
        for(int i =0; i<3; i++){
            System.out.println(boundary);
            System.out.println("|" +strChess[i][0]+"|"+strChess[i][1]+"|"+strChess[i][2]+"|");
        }
        System.out.println(boundary);
    }
    public int move(int row, int col){
//        player can be ether -1 or 1
//        if (this.current_player!=1 && this.current_player != -1){
//            throw new  IllegalArgumentException("Error: class chessBoard: player must be 1 or -1!");
//        }
        if (this.chess[row][col] == 0){
            this.chess[row][col] = this.current_player;
            return 1;
        }
        else{
            return 0;
        }
    }
    public int[] getMove(){
        if (this.current_player == 1)
            System.out.println("Player O Enter your move: ");
        else
            System.out.println("Player X Enter your move: ");
        Scanner scan = new Scanner(System.in);
        String step = scan.nextLine();

        int[] lst = new int[2];

        lst[0] = Integer.parseInt(step.split(",")[0]);
        lst[1] = Integer.parseInt(step.split(",")[1]);
//        this.chess[lst[0]][lst[1]] = this.current_player;
        return lst;
    }
    public int changePlayer(){
        this.current_player -= 2*this.current_player;
        return this.current_player;
    }

    public void judge(){
        int[] colSum = new int[3];
        for(int row=0; row<3;row++){
            int rowSum = 0;
            for(int col=0;col<3;col++) {
                rowSum += this.chess[row][col];
                colSum[col] += this.chess[row][col];
            }
            if(rowSum == -3)
                this.win = -1;
            if(rowSum == 3)
                this.win = 1;
        }
        for(int i: colSum){
            if(i==3)
                this.win = 1;
            if(i==-3)
                this.win = -1;
        }
        int diag = this.chess[0][0]+this.chess[1][1]+this.chess[2][2];
        if(diag==3)
            this.win = 1;
        if(diag==-3)
            this.win = -1;
        diag = this.chess[2][0]+this.chess[1][1]+this.chess[0][2];
        if(diag==3)
            this.win = 1;
        if(diag==-3)
            this.win = -1;
    }
    public void winStatement(){
        String playWin = new String();
        if(this.win>1)
            playWin = "O";
        else
            playWin = "X";
        System.out.println("Player " + playWin + " wins!");
    }
}
