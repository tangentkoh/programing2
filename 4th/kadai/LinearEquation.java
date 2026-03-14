// サブクラスLinearEquationを書く
public class LinearEquation extends Equation{
    private double a, b;
    public LinearEquation(String name, double a, double b) {
        super(name);
        this.a=a;
        this.b=b;
    }
    @Override public void print() {
        System.out.println(name+":"+a+"x+"+b+"=0");
    }
    @Override public void solve() {
        double x=-b/a;
        System.out.println("解:x="+x);
    }
}
