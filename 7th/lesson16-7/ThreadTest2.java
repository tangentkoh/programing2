// 問題16-6のクラスを Runnable インタフェースを実装して作る
public class ThreadTest2{
    public static void main(String[] args){
        new Thread(new ThreadA2()).start();
        new Thread(new ThreadE2()).start();
    }
}
class ThreadA2 implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            try{
                Thread.sleep(1500);
            }catch(InterruptedException e){
            }
            System.out.println("***");
        }
    }
}
class ThreadE2 implements Runnable{
    @Override
    public void run(){
        for(int i=0; i<5; i++){
            try{
                Thread.sleep(2500);
            }catch(InterruptedException e){
            }
            System.out.println("=====");
        }
    }
}