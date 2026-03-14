// 派生クラスOdometerCarを書く
public class OdometerCar extends Car{
    private double odometer = 0;
    public OdometerCar(String name,int width,int height,int length,double fuel,Day purchaseDay,double odometer) {
        super(name,width,height,length,fuel,purchaseDay);
        this.odometer = odometer;
    }
    public double getOdometer() {return odometer;} 
    @Override public boolean move(double dx, double dy) {
        double dist = Math.sqrt(dx * dx + dy * dy);
        if (super.move(dx, dy)) {odometer += dist; return true;} 
            else {return false;}
    }

    public void printOdometer() {System.out.printf("総走行距離：%.2f km\n", odometer);}
}