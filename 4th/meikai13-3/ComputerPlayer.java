// コンピュータプレーヤを表すサブクラスComputerPlayerを書く
import java.util.Random;
public class ComputerPlayer extends JankenPlayer{
    Random rand = new Random();
    private int h;
    public ComputerPlayer(){}
    @Override public void theHand(){
        h = rand.nextInt(3);
    }
    @Override public int getnum(){
        return h;
    }
}