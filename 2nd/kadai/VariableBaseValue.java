// VariableBaseValueクラスを書く
public class VariableBaseValue{
    private static int base = 10;
    public static void setBase(int b) {
        if(b<2){base = 2;} 
        else if(b>10){base = 10;}
        else{base = b;}
    }
    public static int getBase(){return base;}
    private int value;
    public VariableBaseValue(int v){this.value = v;}
    public int getValue(){return value;} // set
    public void setValue(int v){this.value = v;} // get
    public String toString(){
        int v = this.value;
        int b = getBase(); // bを用意
        String s = "";
        do{
        s = (v % b) + s;
        v /= b;
        }while(v > 0);
        return s;
    }
}