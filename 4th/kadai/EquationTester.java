// mainメソッドを含むEquationTesterクラスを書く
public class EquationTester{
    public static void main(String[] args) {
        Equation[] eqs = new Equation[5];
        System.out.println("方程式は5つです");
        System.out.println();
        eqs[0] = new LinearEquation("線形方程式1", 2, -4);
        eqs[1] = new QuadraticEquation("二次方程式1", 1, -3, 2);
        eqs[2] = new QuadraticEquation("二次方程式2", 1, 2, 5);
        eqs[3] = new QuadraticEquation("二次方程式3", 1, -2, 1);
        eqs[4] = new TrigonometricEquation("三角方程式1", -0.5);
        for (Equation eq:eqs) {
            eq.print();
            eq.solve();
            System.out.println();
        }
    }
}
