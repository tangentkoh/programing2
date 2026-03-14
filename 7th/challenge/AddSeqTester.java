// チャレンジ課題のクラスを作成する。
// メインのクラス名は AddSeqTester とする。
import java.util.Scanner;
public class AddSeqTester {
    public static void main(String[] args) throws InterruptedException {
        Scanner stdIn = new Scanner(System.in);
        System.out.print("終了値：");
        long end = stdIn.nextLong();
        System.out.print("スレッド数：");
        int n = stdIn.nextInt();
        AddSeq[] ads = new AddSeq[n];
        Thread[] ths = new Thread[n];
        long rs = end / n;
        long start, finish;
        for (int i = 0; i < n; i++) {
            start = i * rs + 1;
            finish = (i == n - 1) ? end : (i + 1) * rs;
            ads[i] = new AddSeq(start, finish);
            ths[i] = new Thread(ads[i]);
        }
        long timeStart = System.nanoTime();
        for (int i = 0; i < n; i++) {ths[i].start();}
        for (int i = 0; i < n; i++) {ths[i].join();}
        long timeEnd = System.nanoTime();
        timeEnd -= timeStart;
        long total = 0;
        for (int i = 0; i < n; i++) {total += ads[i].getResult();}
        System.out.println("計算結果：" + total);
        System.out.println("処理時間：" + timeEnd);
        stdIn.close();
    }
}
class AddSeq implements Runnable {
    private long start;
    private long end;
    private long result;
    public AddSeq(long start, long end) {
        this.start = start;
        this.end = end;
        this.result = 0;
    }
    @Override public void run() {
        for (long i = start; i <= end; i++) {result += i;}
    }
    public long getResult() {return result;}
}