// 課題のプログラムを作成する。
// RandomTimer クラスおよびメインの QuickPress クラスを作成する。
import java.util.Scanner;
import java.util.Random;
public class QuickPress{
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        System.out.print("Hit Enter to start:");
        stdIn.nextLine();
        RandomTimer t = new RandomTimer(10000);
        t.start();
        stdIn.nextLine();
        System.out.println("Your Time:"+t.responseTime());
        if(t.responseTime()<0){System.out.println("flying!");}
        t.fin();
        stdIn.close();
    }
}
class RandomTimer extends Thread{
    Random ram = new Random();
    private double count = 0;
    private boolean running = true;
    public RandomTimer(int m){
        double x = ram.nextInt(m);
        count = x;
    }
    @Override
    public void run(){
        boolean a = true;
        while(running){
        try{
            Thread.sleep(10);
        }catch(InterruptedException e){
        }
        count -= 10;
        if(count<0 && a){
            System.out.print("*");
            a = false;
        }
        }
    }
    public double responseTime(){
        return -count;
    }
    public void fin(){
        running = false;
    }
}