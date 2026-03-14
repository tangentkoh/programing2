// クラスPetを書く
// サブクラスPetを書く
// 資料に従って一部を省略しても良い
public class Pet {
    private String name;
    public Pet(String name){this.name=name;}
    public String getName(){return name;}
    public void introduce(){System.out.println("■俺の名前は"+name+"だ");}
}
class RobotPet extends Pet{
    public RobotPet(String name){super(name);}
    public void introduce(){System.out.println("◇ 私はロボット、名前は"+getName());}
}