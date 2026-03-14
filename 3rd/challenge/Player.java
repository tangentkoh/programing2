import java.util.Scanner;
public class Player {
    private String nick;
    protected int[] piles;
    public String getNick() { return nick; }
    public void setNick() {
        Scanner scan = new Scanner(System.in);
        System.out.print("ニックネームを入力してください：");
        nick = scan.nextLine();
    }
    public void setP(int[] piles) {this.piles = piles;}
    public void take() {
        int n = -1, m = -1;
        System.out.println(nick + "さんの番です");
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.print("どの山から取りますか？(0, 1, 2)：");
            n = scan.nextInt();
            if(n!=0 && n!=1 && n!=2) {
                System.out.println("無効な入力です");
                continue;
            }
            if (piles[n]==0) {
                System.out.println("その山には石が無いです");
                continue;
            }
            System.out.print("いくつ取りますか？(一以上石の数以下)：");
            m = scan.nextInt();
            if (m<1 || m>piles[n]) {
                System.out.println("不正な入力です");
                continue;
            }
            break;
        }
        piles[n] -= m;
        System.out.println(nick+"さんは山"+n+"から石を"+m+"個取りました");
    }
}
