// 以下に必要な記述を追加せよ
public class SumOfArgs{
    public static void main(String[] args){
        double sum = 0.0;
	    for(String x : args){
            sum += Double.parseDouble(x);
        }
        System.out.println("合計は"+sum+"です。");
    }
}
