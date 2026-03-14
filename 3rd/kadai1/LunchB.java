// LunchBクラスを書く(???を適切に直す)
public class LunchB extends LunchA{
  private String topping ; // トッピングの名前
  private int pTopping ; // トッピングの価格

  public LunchB(String curry , int pCurry,
        String topping, int pTopping){
     super(curry,pCurry);
     this.topping = topping ;
     this.pTopping = pTopping ;
  }

  @Override public String name(){
      return topping + super.name(); }

  @Override public int price() {
      return super.price() + pTopping; }

}

