// サブクラスTrigonometricFunctionを書く
class TrigonometricFunction extends DifferentiableFunction{
    private double a;
    public TrigonometricFunction(String name, double a) {
        this.name = name;
        this.a = a;
    }
    @Override public void print() {System.out.println(name+":f(x)=sin(x)+"+a);}
    @Override public double value(double x) {return Math.sin(x)+a;}
    @Override public double dValue(double x) {return Math.cos(x);}
}