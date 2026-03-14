// ユーティリティクラスMinMaxを書く
public class MinMax {
    public static double Min(double a, double b) {
        return (a<b) ? a : b;
    }
    public static double Max(double a, double b) {
        return (a>b) ? a : b;
    }
}
  // あくまで大小判定のみ(二値用)