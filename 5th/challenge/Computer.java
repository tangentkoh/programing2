// 実装クラスComputerを書く
public class Computer implements TicTacToePlayable {
    @Override public int nextMove(TicTacToeBoard board, int player) {
        int bScore = Integer.MIN_VALUE;
        int bMove = -1;
        for (int move : board.getAvailableMoves()) {
            board.addMove(move, player);
            int score = minimax(board, 1 - player, player);
            board.undo();
            if (score > bScore) {
                bScore = score;
                bMove = move;
            }
        }
        System.out.println(bMove+"を選択しました");
        return bMove;
    }
    private int minimax(TicTacToeBoard board, int currentPlayer, int maxPlayer) {
        int winner = board.checkWin();
        if (winner == maxPlayer) {return 10;}
        else if (winner == 1 - maxPlayer) {return -10;}
        else if (board.isFull()) {return 0;}
        int bestScore = (currentPlayer == maxPlayer) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        for (int move : board.getAvailableMoves()) {
            board.addMove(move, currentPlayer);
            int score = minimax(board, 1 - currentPlayer, maxPlayer);
            board.undo();
            if (currentPlayer == maxPlayer) {bestScore = Math.max(score, bestScore);} 
            else {bestScore = Math.min(score, bestScore);}
        }
        return bestScore;
    }
}
