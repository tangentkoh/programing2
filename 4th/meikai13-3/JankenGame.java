// mainメソッドを含むJankenGameクラスを書く
class JankenGame{
    public static void main(String[] args) {
            JankenPlayer[] p = new JankenPlayer[2];
            String[] s = {"グー","チョキ","パー"};
            System.out.println("プレイヤーvsコンピュータ");
            p[0] = new HumanPlayer();
            p[0].theHand();
            int x = p[0].getnum();
            p[1] = new ComputerPlayer();
            p[1].theHand();
            int y = p[1].getnum();
            System.out.println("貴方は"+s[x]+"です");
            System.out.println("私は"+s[y]+"です");
            if(x==y){System.out.println("引き分け");}
            else if((x==0&&y==1)||(x==1&&y==2)||(x==2&&y==0)){
                System.out.println("プレイヤーの勝ち");
            }
            else{
                System.out.println("プレイヤーの負け");
            }
    }
}