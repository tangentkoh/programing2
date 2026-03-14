// 抽象クラスEquationを書く
public abstract class Equation{
    protected String name;
    public Equation(String name){this.name = name;}
    public String getName(){return name;}
    public abstract void print();
    public abstract void solve();
}