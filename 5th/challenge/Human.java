// 実装クラスHumanを書く
import java.util.Scanner;
public class Human implements TicTacToePlayable {
    private Scanner scanner = new Scanner(System.in);
    @Override public int nextMove(TicTacToeBoard board, int player) {
        int move;
        while (true) {
            System.out.print("プレイヤー" + (player + 1) + "の手(0-8):");
            move = scanner.nextInt();
            if (board.getAvailableMoves().contains(move)){
                System.out.println(move+"を選択しました");
                return move;
            }
            System.out.println("無効な手です、もう一度入力してください");
        }
    }
}
