// LunchCクラスを書く(???を適切に直す)
public class LunchC extends LunchB{
  private String salad; // サラダの名前
  private int pSalad ; // サラダの価格

  public LunchC(String curry , int pCurry,
        String topping, int pTopping,
        String salad, int pSalad){
     super(curry,pCurry,topping,pTopping);
     this.salad = salad ;
     this.pSalad = pSalad ;
  }

  @Override public String name(){
      return super.name() + salad + "セット"; }

  @Override public int price() {
      return super.price() + pSalad; }

}

