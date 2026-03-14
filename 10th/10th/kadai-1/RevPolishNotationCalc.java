// 課題1のプログラムRevPolishNotationCalcクラスを作成する
import java.util.*;
public class RevPolishNotationCalc{
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("逆ポーランド記法の式を入力:");
        String input = sc.nextLine();
        String[] dates = input.split(" ");
        for (String data : dates) {
            if(data.equals("+")||data.equals("-")||data.equals("*")||data.equals("/")){
                int b = stack.pop();
                int a = stack.pop();
                int r = 0;
                switch(data){
                    case "+":r = a + b; break;
                    case "-":r = a - b; break;
                    case "*":r = a * b; break;
                    case "/":r = a / b; break;
                    default:throw new IllegalArgumentException("無効");
                }
                stack.push(r);
            }
            else{stack.push(Integer.parseInt(data));}
        }
        System.out.println("結果:" + stack.pop());
        sc.close();
    }
}