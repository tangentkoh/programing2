import java.util.Random;
import java.util.Scanner;
class Nim {
    public static void main(String[] args) {
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        System.out.println("Nimゲーム");
        int[] piles = {
            rand.nextInt(9) + 1,
            rand.nextInt(9) + 1,
            rand.nextInt(9) + 1
        };
        Player p1 = new Player();
        p1.setNick();
        Player p2 = new Computer();
        p1.setP(piles);
        p2.setP(piles);
        System.out.println(p1.getNick() + "さん、ゲームを開始します");
        System.out.println("今回の初期配置");
        printP(piles);
        int x = rand.nextInt(50) + 1;
        boolean b;
        if(x>=25){System.out.println("先行は"+p1.getNick()+"さんです"); b = false;}
        else{System.out.println("先行はコンピュータです"); b = true;}
        while (true) {
            if(!b){
            p1.take();
            printP(piles);
            if (isGameOver(piles)) {
                System.out.println(p1.getNick() + "さんの勝利です");
                break;
            }
            }
            p2.take();
            printP(piles);
            if (isGameOver(piles)) {
                System.out.println("コンピュータの勝利です");
                System.out.println("何で負けたか、明日まで考えといてください");
                break;
            }
            if(b){b=false;}
        }
    }
    public static void printP(int[] piles) {
        System.out.println("山0：" + piles[0] + "個");
        System.out.println("山1：" + piles[1] + "個");
        System.out.println("山2：" + piles[2] + "個");
    }
    public static boolean isGameOver(int[] piles) {
        return piles[0] + piles[1] + piles[2] == 0;
    }
}
