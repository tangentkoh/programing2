// ・RangeAdd クラス
public class RangeAdd {
    public int add(int a, int b) throws NotNaturalNumber {
        if (a < 0) {throw new NotNaturalNumber(a);}
        if (b < 0) {throw new NotNaturalNumber(b);}
        if (a > b) {int x = a; a = b; b = x;}
        int sum = 0;
        for (int i = a; i <= b; i++){sum += i;}
        return sum;
    }
}
