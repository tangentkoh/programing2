// TicTacToeBoardクラスを書く
import java.util.*;
public class TicTacToeBoard {
    private int[] board = new int[9];
    private Stack<Integer> history = new Stack<>();
    public TicTacToeBoard(){Arrays.fill(board,-1);}
    public boolean addMove(int index, int player){
        if(index<0||index>=9||board[index]!=-1) return false;
        board[index]=player;
        history.push(index);
        return true;
    }
    public void undo() {
        if (!history.isEmpty()) {
            int last = history.pop();
            board[last] = -1;
        }
    }
    public boolean isFull() {
        for (int cell : board) if (cell == -1) return false;
        return true;
    }
    public int checkWin() {
        int[][] lines={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};
        for (int[] line:lines) {
            int a = board[line[0]], b = board[line[1]], c = board[line[2]];
            if (a != -1 && a == b && b == c)return a;
        }
        return -1;
    }
    public List<Integer> getAvailableMoves() {
        List<Integer> moves = new ArrayList<>();
        for (int i = 0; i < 9; i++) if(board[i] == -1)moves.add(i);
        return moves;
    }
    public void display() {
        System.out.println("現在のボードです:");
        for (int i = 0; i < 9; i++) {
            char symbol=board[i]==-1 ? '.' : (board[i]==0?'o':'x');
            System.out.print(symbol+(i%3==2?"\n":" "));
        }
    }
    public TicTacToeBoard clone() {
        TicTacToeBoard copy = new TicTacToeBoard();
        copy.board = this.board.clone();
        copy.history = (Stack<Integer>) this.history.clone();
        return copy;
    }
}
