// 以下に必要な記述を追加せよ
public class meikai15_6{
    public static void main(String[] args){
	    double r = 0.0;
        if(args.length!=0)r = Double.parseDouble(args[0]);
        System.out.println("円周は"+r*2*3.14);
        System.out.println("直径は"+r*r*3.14);
    }
}
