// mainメソッドを含むFunctionTesterクラスを書く
class FunctionTester{
    public static void main(String[] args){
        System.out.println("微分方程式");
        DifferentiableFunction[] difFuncs = {
            new QuadraticFunction("二次式A", 1.0, -2.0), // x^2-2
            new TrigonometricFunction("三角関数式B", 0.5) // sinx+0.5
        };
        System.out.println("fの全ての機能の確認(x=1.0)");
        for (Function f : difFuncs) {
            f.print();
            double testrX = 1.0; // 今回は1.0を代入
            System.out.println("f("+testrX+")="+f.value(testrX));
        }
        System.out.println("dの機能の確認(x=1.0)");
        for (Differentiable d : difFuncs) {
            double testrY = 1.0; // こちらも1.0で
            System.out.println("f'("+testrY+")="+d.dValue(testrY));
        }
        System.out.println("ニュートン法(x0=1.0,n=30)");
        for (DifferentiableFunction df : difFuncs) {
            double root = NewtonMethod(df, 1.0, 30); // ここは課題通り
            System.out.println(df.name+"の近似解:"+root);
        }
        System.out.println();
    }
    static double NewtonMethod(DifferentiableFunction f,double x0,int n){
        double x=x0;
        for(int i=1; i<=n; i++){x=x-f.value(x)/f.dValue(x);}
        return x;
    }
}