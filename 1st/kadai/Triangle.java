// Triangleクラスを書く
public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    public Triangle(double l, double m) {
        this(l, l, m);
    }
    public Triangle(double n) {
        this(n, n);
    }

    public double getA() {return a;}
    public double getB() {return b;}
    public double getC() {return c;}
    public void setA(double a) {this.a = a;}
    public void setB(double b) {this.b = b;}
    public void setC(double c) {this.c = c;}

    public boolean isI() {return (a == b)||(b == c)||(c == a);} // 正三角形は全て満たす   
    public boolean isE() {return (a == b)&&(b == c);} // 二等辺三角形は片方のみ
    public boolean equal(Triangle other) {
        return (this.a == other.a) && (this.b == other.b) && (this.c == other.c);
    } // 他三角形と比較
    public String toString() {
        return String.format("三角形(a=%.1f, b=%.1f, c=%.1f)", a, b, c); // フォーマット指定
    }
}
