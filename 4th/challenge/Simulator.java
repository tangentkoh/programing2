// mainメソッドを含むSimulatorクラスを書く hori kousuke
public class Simulator {
    public static void main(String[] args) {
        final int nR = 10;  // ロボット数
        final int steps = 20; // ステップ数
        Robot[] robots = new XXXRobot[nR];
        for (int i = 0; i < nR; i++) {
            robots[i] = new XXXRobot(i);
            robots[i].state = (i == 0) ? 2 : 0;
        }
        for (int i = 0; i < nR; i++) {
            Robot left = (i > 0) ? robots[i - 1] : null;
            Robot right = (i < nR - 1) ? robots[i + 1] : null;
            robots[i].initialize(left, right, steps);
        }
        Robot.resetClock();
        for (int t = 0; t < steps; t++) {
            int tag = -1;
            int ns = -1;
            for (int i = 0; i < nR; i++) {
                int cu = robots[i].history[Robot.clock];
                int ls = (robots[i].left == null) ? -1 : robots[i].left.history[Robot.clock];
                if (cu == 0 && ls >= 1) {tag = i; ns = 1; break;}
            }
            if (tag < 0) {
                for (int i = 0; i < nR; i++) {
                    int cu = robots[i].history[Robot.clock];
                    if (cu != 1) continue;
                    int ls = (robots[i].left == null) ? -1 : robots[i].left.history[Robot.clock];
                    int rs = (robots[i].right == null) ? -1 : robots[i].right.history[Robot.clock];
                    boolean LOK = ls >= 1;
                    boolean ROK = (robots[i].right == null) || (rs >= 1);
                    if (LOK && ROK) {tag = i; ns = 2; break;}
                }
            }
            boolean All = true;
            if (tag < 0) {
                for (int i = 0; i < nR; i++) {
                    if (robots[i].history[Robot.clock] < 2){All = false; break;}
                }
                if(All){ns = 3; tag = -2;}
            }
            Robot.nextClock();
            if (tag == -2) {
                for (int i = 0; i < nR; i++) {
                    robots[i].history[Robot.clock] = ns;
                    robots[i].state = ns;
                }
            } 
            else if (tag >= 0){
                for (int i = 0; i < nR; i++) {
                    robots[i].history[Robot.clock]=(i==tag)?ns:robots[i].history[Robot.clock-1];
                    robots[i].state = robots[i].history[Robot.clock];
                }
            } 
            else {
                for (int i = 0; i < nR; i++) {
                    robots[i].history[Robot.clock] = robots[i].history[Robot.clock - 1];
                    robots[i].state = robots[i].history[Robot.clock];
                }
            }
        }
        System.out.println("ロボット数: " + nR);
        System.out.println("ステップ数: " + Robot.clock);
        System.out.println();
        for (int t = 0; t <= Robot.clock - 1; t++) {
            System.out.printf("%2d: ", t);
            for (Robot r : robots){System.out.print(r.getHistoryCharAt(t));}
            System.out.println();
        }
        System.out.println();
    }
}