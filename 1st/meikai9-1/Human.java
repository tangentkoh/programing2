// Humanクラスを書く
public class Human{
    private String name; // 名前
    private int height; // 身長
    private int weight; // 体重
    private int age; // 年齢
    public Human(String name, int height, int weight, int age){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }
    public String getName() { return name; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public int getAge() { return age; }
}