// 以下に必要な記述を追加せよ
import java.io.*;
public class SearchWord{
    public static void main(String[] args){
	    if(args.length != 2){
            System.out.println("使用法:java SearchWord 検索対象ファイル キーワード");
            System.out.println("例:java SearchWord java.txt Java");
            System.exit(0);
        }
        String filename = args[0];
        String findString = args[1];
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            StringBuilder contentBuilder = new StringBuilder(); //文字列を扱うクラス
            int c;
            while((c=reader.read())!=-1){contentBuilder.append((char)c);}
            reader.close();
            String content = contentBuilder.toString();
            int index = 0;
            while ((index=content.indexOf(findString,index))!=-1){ // 完全一致のみ(大小も注意)
                int start = Math.max(0, index-5);
                int end = Math.min(content.length(), index+findString.length()+5);
                String context = content.substring(start, end);
                System.out.println("字数:"+index);
                System.out.println("前後:"+context);
                System.out.println();
                index += findString.length();
            }
        }
		catch(Exception e){
            System.out.println(e);
            System.exit(0);
        }
    }
}
