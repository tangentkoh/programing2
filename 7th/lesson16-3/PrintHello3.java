// 16-2のプログラムを使ってPrintHello3のプログラムを書く
public class PrintHello3{
    public static void main(String[] args){
        new LabelPrinter3("おはよう！").start();
        new LabelPrinter3("こんにちは！").start();
        new LabelPrinter3("こんばんは！").start();
    }
}
class LabelPrinter3 extends Thread{
    String label = "no label";
    LabelPrinter3(String label){
        this.label = label;
    }
    @Override
    public void run(){
        while(true){
            System.out.println(label);
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
        }
        }
    }
}