// mainメソッドを含むPetTesterEx142クラスを書く
class PetTesterEx142{
    public static void main(String[] args){
        System.out.println("着せ替えOKロボット");
        SkinnableRobotPet a = new SkinnableRobotPet("R2D2X2");
        a.introduce();
        a.changeSkin(Skinnable.RED);
        a.changeSkin(Skinnable.BLUE);
        a.changeSkin(Skinnable.LEOPARD);
        System.out.println("終わり");
    }
}