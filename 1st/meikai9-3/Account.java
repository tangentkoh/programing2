// accountクラス
class Account{
    private String name;
    private String nomber;
    private long balance;
    private Day day;
    Account(String na, String no, long z, Day day){
        name = na;
        nomber = no;
        balance = z;
        this.day = new Day(day);
    }
    public String getNa() {return name;}
    public String getNo() {return nomber;}
    public long getZ() {return balance;}
    void deposit(long k){balance += k;}
    void withdraw(long k){balance -= k;}
    public Day getday() {
        return new Day(day);
    }
    public String toString() {
        return String.format("open: %d年%d月%d日", // フォーマット指定
            day.getYear(), day.getMonth(), day.getDate());
    }
}