// サブクラス/実装クラスParallelogramを書く
public class Parallelogram extends Shape implements Plane2D{
    private int width;
    private int height;
    public Parallelogram(int width,int height){
        this.width=width; this.height=height;
    }
    @Override public String toString(){
        return "Parallelogram(width:"+width+", height:"+height+")";
    }
    @Override public void draw(){
        for(int i=1; i<=height; i++){
            for(int j=1; j<height-i; j++){System.out.print(' ');}
            for(int j=0; j<width; j++){System.out.print('#');}
            System.out.println();
        }
    }
    @Override public int getArea(){return width*height;}
}