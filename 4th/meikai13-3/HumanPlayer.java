// 人間プレーヤを表すサブクラスHumanPlayerを書く
import java.util.Scanner;
public class HumanPlayer extends JankenPlayer{
    Scanner scan = new Scanner(System.in);
    private int h;
    public HumanPlayer(){}
    @Override public void theHand(){
        System.out.println("じゃんけんポン");
        System.out.print("(0)グー (1)チョキ (2)パー :");
        h = scan.nextInt();
    }
    @Override public int getnum(){
        return h;
    }
}