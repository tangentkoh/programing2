// mainメソッドを含むTicTacToeクラスを書く hori kousuke
import java.util.Scanner;
public class TicTacToe {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        TicTacToePlayable[] players = new TicTacToePlayable[2];
        System.out.println("三目並べ");
        int mode;
        do{
            System.out.print("人間vs人間→0、人間vsCPU→1、CPUvsCPU→2:");
            mode = stdIn.nextInt();
            if (mode<0 || mode>2) {System.out.println("不正な入力です");}
        }while (mode<0 || mode>2);
        if (mode == 0){
            players[0] = new Human();
            players[1] = new Human();
            System.out.println("人間1vs人間2");
        }
        else if (mode == 1){
            players[0] = new Human();
            players[1] = new Computer();
            System.out.println("人間1vsCPU2");
        } 
        else{
            players[0] = new Computer();
            players[1] = new Computer();
            System.out.println("CPU1vsCPU2");
        }
        System.out.println("ボードと数字の関係です");
        System.out.println("0 1 2");
        System.out.println("3 4 5");
        System.out.println("6 7 8");
        TicTacToeBoard board = new TicTacToeBoard();
        int currentPlayer = 0;
        while (true) {
            board.display();
            int move = players[currentPlayer].nextMove(board.clone(), currentPlayer);
            if (!board.addMove(move, currentPlayer)) {
                System.out.println("不正な手です");
                continue;
            }
            int winner = board.checkWin();
            if (winner != -1) {
                board.display();
                System.out.println("プレイヤー"+(winner+1)+"の勝ちです");
                break;
            } 
            else if (board.isFull()) {
                board.display();
                System.out.println("引き分けです");
                break;
            }
            currentPlayer=1-currentPlayer;
        }
    }
}
