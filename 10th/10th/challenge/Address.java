// 単一のアドレス情報を保持するAddressクラスを作成
public class Address {
    private String name;
    private String num;
    private String mail;
    public Address(String name, String num, String mail){
        this.name=name;
        this.num=num;
        this.mail=mail;
    }
    public String getName(){return name;}
    public String getNum(){return num;}
    public String getMail(){return mail;}
    @Override public String toString(){return name+","+num+","+mail;}
}