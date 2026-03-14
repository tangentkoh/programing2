// 問題16-6のクラスを Thread クラスの拡張クラスとして作る
public class ThreadTest1{
    public static void main(String[] args){
        new ThreadA1().start();
        new ThreadE1().start();
    }
}
class ThreadA1 extends Thread{
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            try{
                Thread.sleep(3000);
            }catch(InterruptedException e){
            }
            System.out.println("***");
        }
    }
}
class ThreadE1 extends Thread{
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            try{
                Thread.sleep(5000);
            }catch(InterruptedException e){
            }
            System.out.println("=====");
        }
    }
}