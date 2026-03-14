// 自動車クラス【第２版】Carを書く
public class Car {
    private String name;
    private int width;
    private int height;
    private int length;
    private double x;
    private double y;
    private double fuel;
    private Day purchaseDay;

    public Car(String name, int width, int height, int length, double fuel, Day purchaseDay) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.length = length;
        this.fuel = fuel;
        x = y = 0.0;
        this.purchaseDay = new Day(purchaseDay);
    }

    public double getX() {return x;}
    public double getY() {return y;}
    public double getFuel() {return fuel;}
    public Day getPerchaseDay() {return new Day(purchaseDay);}

    void putSpec() {
        System.out.println("名前："+name);
        System.out.println("車幅："+width+"mm");
        System.out.println("車高："+height+"mm");
        System.out.println("車長："+length+"mm");
        System.out.println("購入日：" + purchaseDay.getYear() + "/" + purchaseDay.getMonth() + "/" + purchaseDay.getDate());
        System.out.println("初期燃料："+fuel+"L");
    }

    boolean move(double dx, double dy) {
        double dist = Math.sqrt(dx*dx+dy*dy);
        if (dist>fuel){return false;}
        else {
            fuel -= dist;
            x += dx;
            y += dy;
            return true;
        }
    }
}