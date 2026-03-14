// 左下が直角であるサブクラスLftBtmRAITriangleを書く
public class LftBtmRAITriangle extends RAITriangle{
    public LftBtmRAITriangle(int size){super(size);}
    @Override public String toString(){
        return "LftBtmRAITriangle(size:"+getSize()+")";
    }
    public void draw(){
        for(int i=1; i<=getSize(); i++){
            for(int j=1; j<=i; j++){
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }
}