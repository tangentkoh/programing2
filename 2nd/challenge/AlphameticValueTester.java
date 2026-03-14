// mainメソッドを含むAlphameticValueTesterクラスを書く
public class AlphameticValueTester{
    public static void main(String[] args){
        AlphameticValue a = new AlphameticValue("ABC");
        AlphameticValue b = new AlphameticValue("DEF");
        AlphameticValue c = new AlphameticValue("BHIJ");
        AlphameticValue.displayVals();
        int valA = a.toInt();
        int valB = b.toInt();
        int valC = c.toInt();
        System.out.println("変換完了");
        System.out.println(a.getDigitString()+" = "+valA);
        System.out.println(b.getDigitString()+" = "+valB);
        System.out.println(c.getDigitString()+" = "+valC);
        System.out.println(valA+" + "+valB+" = "+valC); // 表示
    }
}