// 右上が直角であるサブクラスRgtTopRAITriangleを書く
public class RgtTopRAITriangle extends RAITriangle{
    public RgtTopRAITriangle(int size){super(size);}
    @Override public String toString(){
        return "RgtTopRAITriangle(size:"+getSize()+")";
    }
    public void draw(){
        for(int i=1; i<=getSize(); i++){
            for(int j=1; j<=i-1; j++){
                System.out.print(' ');
            }
            for(int j=1; j<=getSize()+1-i; j++){
                System.out.print('*');
            }
            System.out.println();
        }
        System.out.println();
    }
}