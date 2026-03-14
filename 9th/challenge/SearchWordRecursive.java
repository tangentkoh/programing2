// 以下に必要な記述を追加せよ
import java.io.*;
public class SearchWordRecursive{
    public static void main(String[] args){
        if (args.length != 2) {
            System.out.println("使用法:java SearchWordRecursive ディレクトリ名 キーワード");
            System.out.println("例:java SearchWordRecursive ./ java");
            System.exit(0);
        }
        String dirname = args[0];
        String keyword = args[1];
        File dir = new File(dirname);
        searchInDirectory(dir, keyword); // サーチ
    }
    public static void searchInDirectory(File dir, String keyword){ // 再帰的に探索
        File[] files = dir.listFiles();
        if (files == null){return;}
        for (File file : files){
            if (file.getName().equals(".") || file.getName().equals("..")){continue;}
            if(file.isDirectory()){searchInDirectory(file, keyword);}
            else{searchInFile(file, keyword);}
        }
    }
    public static void searchInFile(File file, String keyword){ // キーワード探索
        try{
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder contentBuilder = new StringBuilder(); //文字列を扱うクラス
            int c;
            while((c=reader.read())!=-1){contentBuilder.append((char)c);}
            reader.close();
            String content = contentBuilder.toString();
            int ind = 0;
            boolean found = false;
            while((ind = content.indexOf(keyword, ind)) != -1){
                if(!found){
                    System.out.println("ファイル:"+file.getAbsolutePath());
                    found = true;
                }
                int start = Math.max(0, ind - 5);
                int end = Math.min(content.length(), ind + keyword.length() + 5);
                String context = content.substring(start, end);
                System.out.println("前後:"+context);
                ind += keyword.length();
            }
        }
        catch(Exception e){System.out.println(e);} // 読めないファイルは飛ばす
    }
}
