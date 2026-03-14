// NotNaturalNumberクラスの定義
public class NotNaturalNumber extends RuntimeException {
    public NotNaturalNumber(int n) {
        super("自然数ではない: " + n);
    }
}