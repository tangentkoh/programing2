// 課題2のプログラムを作成する
//
import java.util.*;
// 車クラス
class Car{
    private int step;
    public Car(int step){this.step = step;}
    public int getStep(){return step;}
}
// SignalSimulatorクラス
public class SignalSimulator{
    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("使用法:信号の間隔 車の出現間隔");
            System.out.println("例:java SignalSimulator 20 10");
            System.exit(0);
        }
        int sigFreq = Integer.parseInt(args[0]);
        int carFreq = Integer.parseInt(args[1]);
        Queue<Car> queue = new LinkedList<>();
        boolean isRed = false;
        int carnum = 0;
        int waitnum = 0;
        for (int i=1; i<=10000; i++){
            if(i%sigFreq==0){isRed = !isRed;}
            if(i%carFreq==0){
                Car in = new Car(i);
                queue.offer(in);
            }
            if(!isRed&&!queue.isEmpty()){
                Car out = queue.poll();
                carnum++;
                waitnum+=(i-out.getStep());
            }
        }
        System.out.println("通過台数:"+carnum);
        System.out.println("平均待機時間:"+(waitnum/carnum));
    }
}