// 以下に必要な記述を追加せよ
import java.io.*;
public class ListRecursive{
    public static void main(String[] args){
	    if(args.length != 1){
            System.out.println("使用法:java ListRecursive ディレクトリ名");
            System.out.println("例:java ListRecursive 1st");
            System.exit(0);
        }
        String dirname = args[0];
        File dir = new File(dirname);
        printList(0, dir);
    }
    public static void printList(int depth, File dir){ // ファイルの表示
        System.out.println(getIndent(depth)+dir.getName()+"/");
        String[] files = dir.list();
        if(files == null){return;}
        for(String name : files){
            if(name.equals(".")||name.equals("..")){continue;}
            File file = new File(dir, name);
            if(file.isDirectory()){printList(depth + 1, file);}
            else{System.out.println(getIndent(depth + 1) + name);}
        }
    }
    public static String getIndent(int depth){ // インデントの作成
        StringBuilder sb=new StringBuilder();
        for(int i=0 ; i<depth; i++){sb.append("  ");}
        return sb.toString();
    }
}