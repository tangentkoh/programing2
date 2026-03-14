// 以下に必要な記述を追加せよ
import java.util.Scanner;
import java.io.File;
class Dictionary{
    private int wordNum = 46725;
    private String[] eWords; // 英単語配列
    private String[] jWords; // 和訳配列
    public Dictionary(String filename){
        eWords = new String[wordNum];
        jWords = new String[wordNum];
        try{
            Scanner scan = new Scanner(new File(filename),"UTF-8");
            int index = 0;
            while (scan.hasNextLine() && index < wordNum){
                String line = scan.nextLine().trim();
                String[] parts = line.split("\\t", 2); // 分割処理
                if (parts.length == 2){
                    eWords[index] = parts[0];
                    jWords[index] = parts[1];
                    index++;
                }
            }
            scan.close();
        }
		catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
	public String searchEWord(String word){ // 完全一致
		for(int i=0; i<wordNum; i++){
			if(eWords[i].equals(word)){
				return eWords[i]+":"+jWords[i];
			}
		}
		return null;
	}
     public String searchFEWord(String input){ // 部分一致
        for (int i=0; i<wordNum; i++){
            String dWord=eWords[i];
        if (input.startsWith(dWord) && input.length() >= dWord.length()){
            String suffix=input.substring(dWord.length());
            return dWord+"-"+suffix+":"+jWords[i];
        }
        }
        return null;
    }
	public String searchJWord(String key){ // 日本一致
		StringBuilder r = new StringBuilder();
		for(int i=0; i<wordNum; i++){
			if(jWords[i].contains(key)){
				r.append(eWords[i]).append(":").append(jWords[i]).append("\n");
			}
		}
		return r.length()>0?r.toString():null;
	}
}
public class DictionaryTester{
    public static void main(String[] args){
		Scanner stdIn = new Scanner(System.in); // チェック用
        Dictionary d = new Dictionary("ejdic-hand-utf8.txt");
        System.out.println("辞書アプリ");
		System.out.println("searchEWord(完全一致)");
		System.out.print("言葉を入力:");
		String w1 = stdIn.nextLine(); String r1 = null;
		r1 = d.searchEWord(w1); System.out.println(r1);
        System.out.println("searchFEWord(前方一致)");
		System.out.print("言葉を入力:");
		String w2 = stdIn.nextLine(); String r2 = null;
		r2 = d.searchFEWord(w2); System.out.println(r2);
		System.out.println("searchJWord(日本一致)");
		System.out.print("言葉を入力:");
		String w3 = stdIn.nextLine(); String r3 = null;
		r3 = d.searchJWord(w3); System.out.println(r3);
		stdIn.close();
		System.out.println("アプリ終了");
    }
}
