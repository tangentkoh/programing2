// サブクラスQuadraticEquationを書く
public class QuadraticEquation extends Equation{
    private double a, b, c;
    public QuadraticEquation(String name, double a, double b, double c) {
        super(name);
        this.a = a;
        this.b = b;
        this.c = c;
    }
    @Override public void print() {
        System.out.println(name+":"+a+"x^2+"+b+"x+"+c+"=0");
    }
    @Override public void solve() {
        double dis = b*b-4*a*c;
        double rea = -b/(2*a);
        if (dis>0){
            double x1 = (-b + Math.sqrt(dis))/(2 * a);
            double x2 = (-b - Math.sqrt(dis))/(2 * a);
            System.out.println("解:x="+x1+",x="+x2);
        } 
        else if (dis==0){System.out.println("重解:x="+rea);}
        else{
            double ima = Math.sqrt(-dis) / (2 * a);
            System.out.println("複雑な解:x="+rea+"+"+ima+"i,x="+rea+"-"+ima+"i");
        }
    }
}
