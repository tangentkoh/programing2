// Shiritori.java を書く hori kousuke
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
public class Shiritori{
    public static void main(String[] args) {
        System.out.println("しりとりアプリ");
        System.out.println("ユーザvsシステム");
        String[][] names = new String[199844][2];
        File file = new File("worddict.txt");
        SearchWord reader = new SearchWord();
        reader.readTxt(file,names);
        Scanner stdIn = new Scanner(System.in);
        HashSet<String> unames = new HashSet<>(); // ハッシュで素早く
        Random random = new Random();
        int index = random.nextInt(199844);
        String cnames = names[index][1];
        System.out.println("最初のコトバは:"+cnames); // 最初の単語(ランダム)
        unames.add(cnames);
        System.out.println("(入力は全角ひらがなのみ)");
        while(true){
            System.out.print("ユーザの番:");
            String userstdIn = stdIn.nextLine().trim();
            try{
                String lchar = getlchar(cnames);
                CheckWord.validate(userstdIn,lchar,unames,names); // 確認
                unames.add(userstdIn);
                String nchar = getlchar(userstdIn);
                String sys = SearchWord.findValidWord(nchar,unames,names);
                if (sys == null){
                    System.out.println("システムは返答できない");
                    System.out.println("ユーザの勝利");
                    break;
                } else {
                    System.out.println("システムの番:" + sys);
                    unames.add(sys);
                    cnames = sys;
                }
            }catch(NotValidWordError e){
                System.out.println("「不適切」"+e.getMessage());
            }catch(LoseWordError f){
                System.out.println("「アウト」"+f.getMessage());
                System.out.println("ユーザはアウトになった");
                System.out.println("システムの勝利");
                break;
            }catch(NoKeywordError g){
                System.out.println("「辞書外」" + g.getMessage());
            }
        }
        stdIn.close();
    }
    public static String getlchar(String word){ //ラスワ取得
        String lastChar = word.substring(word.length() - 1);
        switch (lastChar) {
            case "ぁ": return "あ"; // 小文字変換
            case "ぃ": return "い"; // 伸ばし棒はシステムの弱点
            case "ぅ": return "う";
            case "ぇ": return "え";
            case "ぉ": return "お";
            case "っ": return "つ";
            case "ゃ": return "や";
            case "ゅ": return "ゆ";
            case "ょ": return "よ";
            default: return lastChar;
        }
    }
}
class NotValidWordError extends Exception{ // 例外クラスず
    public NotValidWordError(String s){super(s);}
}
class LoseWordError extends Exception{
    public LoseWordError(String s){super(s);}
}
class NoKeywordError extends Exception{
    public NoKeywordError(String s){super(s);}
}
class CheckWord{
    public static void validate(String w, String lc, HashSet<String> un, String[][] ns)
        throws NotValidWordError,LoseWordError,NoKeywordError{
        if(w.length()<=3){throw new NotValidWordError("コトバが短い");}
        if(un.contains(w)){throw new NotValidWordError("コトバはすでに使われている");}
        if(w.endsWith("ん")){throw new LoseWordError("最終文字が「ん」だ");}
        if(lc!=null&&!w.startsWith(lc)){throw new LoseWordError("しりとりが続かない(不一致)");}
        boolean found = false;
        for(String[] entry:ns){
            if (entry[1]==null) break;
            if (entry[1].equals(w)){found = true; break;}
        }
        if(!found){throw new NoKeywordError("コトバは辞書に存在しない");}
    }
}
class SearchWord{ // コトバの読み込み
    public void readTxt(File file, String[][] names){
        int index = 0;
        try{
            Scanner scanner = new Scanner(file,"UTF-8"); // 文字化け防止
            while(scanner.hasNextLine() && index < names.length){
                String line = scanner.nextLine().trim();
                String[] parts = line.split(" ");
                if(parts.length >= 2){
                    names[index][0] = parts[0];
                    names[index][1] = parts[1];
                    index++;
                }
            }
            scanner.close();
            System.out.println("辞書ファイル読み込み完了("+index+"語)");
        }catch(FileNotFoundException h){
            System.out.println("ファイルが見つからない:"+file.getName());
        }
    }
    public static String findValidWord(String sc, HashSet<String> un, String[][] ns){
        for (String[] entry:ns){ // コトバ探し
            if(entry[1] == null){break;}
            String x = entry[1];
            if(x.length()>=4&&x.startsWith(sc)&&!un.contains(x)&&!x.endsWith("ん"))
            {return x;}
        }
        return null;
    }
}