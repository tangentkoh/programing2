// サブクラスTrigonometricEquationを書く
public class TrigonometricEquation extends Equation{
    private double a;
    public TrigonometricEquation(String name, double a) {
        super(name);
        this.a = a;
    }
    @Override public void print() {
        System.out.println(name+":sin(x)+"+a+"=0");
    }
    @Override public void solve() {
        double value = -a;
        if (value < -1||value > 1) {
            System.out.println("実数解が無い(|sin(x)|<=1)");
            return;
        }
        double x1 = Math.asin(value);
        double x2 = Math.PI-x1;
        System.out.printf("範囲内での解[0,2π):x=%.4f,x=%.4f%n", x1, x2);
    }
}
