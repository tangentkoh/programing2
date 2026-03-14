// サブクラスQuadraticFunctionを書く
class QuadraticFunction extends DifferentiableFunction{
    private double a, b;
    public QuadraticFunction(String name, double a, double b) {
        this.name = name;
        this.a = a;
        this.b = b;
    }
    @Override public void print() {System.out.println(name+":f(x)="+a+"x^2+"+b);}
    @Override public double value(double x) {return a*x*x+b;}
    @Override public double dValue(double x) {return 2*a*x;}
}