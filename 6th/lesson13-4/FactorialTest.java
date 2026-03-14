// FactorialTest.java を修正したプログラムを書く
public class FactorialTest{
    public static void main(String[] args) {
        System.out.println(factorial(10));
    }
    public static int factorial(int n){
        if(n<=0){return 1;} // ループ停止
        else{return n*factorial(n-1);}
    }
}