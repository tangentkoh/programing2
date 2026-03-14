// 抽象クラスRobotを書く
public abstract class Robot {
    public static int clock=0;
    public static void resetClock(){clock=0;}
    public static void nextClock(){clock++;}
    protected int state;
    protected int[] history;
    protected Robot left, right;
    public void initialize(Robot left,Robot right,int totalSteps){
        this.left=left;
        this.right=right;
        this.history=new int[totalSteps+1];
        this.history[clock]=state;
    }
    public int getPreviousState(){return history[clock];}
    public abstract char getHistoryCharAt(int time);
    public abstract void transition(int totalSteps);
}