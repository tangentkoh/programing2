// List 19-15に沿ってQuestion.javaのプログラムを書く
import java.util.*;
public class Question{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("Alice");
        list.add("Bob");
        list.add("Chris");
        // list.add(1234); // コンパイルエラーが起こる
        System.out.println(list.get(2));
        System.out.println(list.size());
        for(String name:list){System.out.println(name);}
    }
}