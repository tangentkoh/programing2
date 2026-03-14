// mainメソッドを含むVarBaseValTesterクラスを書く
import java.util.Scanner;
public class VarBaseValTester{
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        VariableBaseValue[] varBaseVals = new VariableBaseValue[3];
        varBaseVals[0] = new VariableBaseValue(4);
        varBaseVals[1] = new VariableBaseValue(8);
        varBaseVals[2] = new VariableBaseValue(16); // 今回はこちらで初期化
        System.out.println("初期値の"+VariableBaseValue.getBase()+"進数だと");
        for(int i=0; i<varBaseVals.length; i++){
            System.out.println("配列番号"+i+"は"+varBaseVals[i]);
        }
        int b2 = 10;
        System.out.println("baseを入力"); // 自分で変える
        System.out.print("base："); b2 = stdIn.nextInt();
        VariableBaseValue.setBase(b2);
        System.out.println("選ばれた"+VariableBaseValue.getBase()+"進数だと");
        for(int i=0; i<varBaseVals.length; i++){
            System.out.println("配列番号"+i+"は"+varBaseVals[i]);
        }
        System.out.println("最後にセッターとゲッターの確認をすると");
        varBaseVals[0].setValue(32); // 今回もこちらが設定
        System.out.println("varBaseVals[0]のvalueを32に設定したら、getValue()は"
        +varBaseVals[0].getValue());
    }
}