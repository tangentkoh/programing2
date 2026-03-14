// Computerクラスを書く
import java.util.Random;
public class Computer extends Player{
    @Override
    public void take() {
        System.out.println("コンピュータの番です");
        Random rand = new Random();
        int n2;
        do {
            n2 = rand.nextInt(3);
        } while (piles[n2] == 0);
        int m2 = rand.nextInt(piles[n2]) + 1;
        if(piles[n2]==m2&&m2!=1){m2 -= 1;}
        if(piles[0]+piles[1]+piles[2]==piles[n2]){m2 = piles[n2];}
        piles[n2] -= m2;
        System.out.println("コンピュータは山"+n2+"から石を"+m2+"個取りました");
    }
}