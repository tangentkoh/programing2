// AlphameticValueクラスを書く
public class AlphameticValue{
    private static int[] vals = {2,1,9,8,7,6,3,0,9,5}; // 調整
    private char[] digits;
    public static int getVal(char c){return vals[c-'A'];} // val取得
    public AlphameticValue(String s){digits=s.toCharArray();} // 変換器1
    public static void setVal(char c, int value){vals[c-'A'] = value;} // val書込
    public char[] getDigits(){return digits;} // digitsゲッター
    public String getDigitString(){return new String(digits);} // 確認用
    public int toInt(){ // 変換器2
        int ans = 0;
        for(char c:digits){ans=ans*10+getVal(c);}
        return ans;
    }
    public static void displayVals(){ // 結果確認用
        System.out.println("valsの内容は");
        for (char c='A'; c<='J'; c++) {
            System.out.println(c+" = "+getVal(c));
        }
    }
}