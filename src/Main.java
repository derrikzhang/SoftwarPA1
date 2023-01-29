public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to play CS611 Tic Tac Toe!");
        Game game = new Game();
        game.printLayout();
        while (game.win ==0 ){
            int[] address= game.getMove();
            if (address[0]<1 || address[0]>3||address[1]<0|| address[1]>3){
                throw new  IllegalArgumentException("Error: the row and column number must with 1-3.");
            }
            if (game.move(address[0]-1, address[1]-1) == 0){
                System.out.println("Chess already exist in this position, please choose another.");
                continue;
            }
            game.changePlayer();
            game.printLayout();
            game.judge();
        }
        game.winStatement();
    }
}