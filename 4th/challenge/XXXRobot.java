// サブクラスXXXRobotを書く(クラス名/.javaファイル名やサブクラスの数は適切に調整する)
public class XXXRobot extends Robot {
    private final int id;
    public XXXRobot(int id){this.id = id;}
    @Override public void transition(int totalSteps) {
        int cu = history[clock];
        int ls = (left == null) ? -1:left.history[clock];
        int rs = (right == null) ? -1:right.history[clock];
        int next = cu;
        if (cu == 0 && ls >= 1){next = 1;}
        else if (cu == 1){
            boolean leftOk = (ls >= 1);
            boolean rightOk = (rs >= 1) || (rs < 0);
            if (leftOk && rightOk){next = 2;}
        }
        else if (cu == 2 && ls == 1){next = 2;}
        history[clock + 1] = next;
        state = next;
    }
    @Override public char getHistoryCharAt(int time) {
        switch (history[time]) {
            case 0: return 'A'; // 信号なし
            case 1: return 'B'; // 信号あり
            case 2: return 'C'; // 仮点灯
            case 3: return 'Z'; // 完全点灯
            default: return '?';
        }
    }
}