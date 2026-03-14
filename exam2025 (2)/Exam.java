import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

// 下記の雛形を利用せよ
// なお，すべての問題について対応箇所を示しているわけではない
// また，通常レポートのように，処理内容がわかるような出力を追加する必要はない
// 採点は解答用テキストファイルで行うため，必要箇所は必ずそちらのファイルに転記すること．

class PlayerData{
    private String name;
    private int id;
    private int games;
    private int [] atbat;
    private int [] hits;
    private static int counter=0;
    //{id = counter++;}
    PlayerData(){
	// 問1-エ
        id = counter++;
    }
    PlayerData(String name){
	// 問1-オ
        
        this.name = name;
    }
    PlayerData(String name, int [] atbat, int [] hits){
	// 問1-カ
        this(name);
        this.atbat = atbat;
        this.hits = hits;
        games = atbat.length;
    }
    PlayerData(PlayerData player){
	// 問1-ク
        PlayerData player2 = new PlayerData(player);
        
    }
    int totalhits(){
	// コンパイル用のダミー，書き換えること
	// 問1-ア
	// return 0;
        int t=0;
        for(int i=0; i<hits.length; i++){
            t+=hits[i];
        }
        return t;
    }
    int totalbats(){
	// コンパイル用のダミー，書き換えること
	// 問1-ア
	//return 0;
        int b=0;
        for(int i=0; i<atbat.length; i++){
            b+=atbat[i];
        }
        return b;
    }
    double battingAverage(){
	// コンパイル用のダミー，書き換えること
	// 問1-イ
	//return 0; 
        int t=totalhits()*1000;
        int b=totalbats();
        int a = t/b;
        double a2 = a;
        a2/=1000;
        return a2;
    }
    public String toString(){
        return(name+"(id:"+id+")の打率は"+battingAverage()+"("+totalbats()+"打数"+totalhits()+"安打)です。");
    }
}

// インタフェースLinkableを作成せよ
// 問2-ア
interface Linkable{
    boolean addTail(Object o){
        list.add(o);
    }
    int[] getArray(){
        int[] a = list;
        return a[];
    }
}
// LinkedPlayerを作成せよ
// 以下はダミー，適切に書き換えること
// 問2-イ，ウ
class LinkedPlayer extends PlayerData{
    // 以下は Linkable未定義のためコメントアウトしている．
    // 必要に応じて利用すること．
    Linkable next = null;
    //問2-エ
    LinkedPlayer(PlayerData player){
        this(player);
    }
    
}


public class Exam{
    public static void main(String [] args){
	//
	int [] atbat = {2, 0, 1, 3};
	int [] hists = {1, 0, 0, 1};

	// 問1-キ出力
	// 変更しないこと
	PlayerData p1 = new PlayerData("大谷", atbat, hists);
	System.out.println(p1);

	// 必要に応じて追加すること．
    }
}
