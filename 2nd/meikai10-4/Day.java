// Dayクラスを書く
import java.time.LocalDate;
public class Day{
    LocalDate now = LocalDate.now();
    private int year = now.getYear();; // 今の日付で初期化
    private int month = now.getMonthValue();
    private int date = now.getDayOfMonth();

    public static boolean isLeap(int y){return y % 4 == 0 && y % 100 != 0 || y % 400 == 0;} // 第四版ズ
    public boolean isLeap(){return isLeap(year);}

    public Day(){} // 第三版ズ
    public Day(int year){this.year = year;}
    public Day(int year, int month){this(year); this.month = month;}
    public Day(int year, int month, int date){set(year, month, date);}
    public Day(Day d){this(d.year, d.month, d.date);}

    public int getYear(){return year;} // 第二版ズ
    public int getMonth(){return month;}
    public int getDate(){return date;}
    public void setYear(int year){this.year = year;}
    public void setMonth(int month){this.month = month;}
    public void setdate(int date){this.date = date;}
    public void set(int year, int month, int date){
        this.year = year;
        this.month = month;
        this.date = date;
        if(this.year < 1){this.year = 1;}
        if(this.month < 1){this.month = 1;}
        if(this.month > 12){this.month = 12;}
        if(this.date < 1){this.date = 1;}
        int maxdate = 31; // 判定用int
        switch (this.month){
            case 2:
                maxdate = isLeap(this.year) ? 29 : 28;
                break;
            case 4: case 6: case 9: case 11:
                maxdate = 30;
                break;
            default:
                maxdate = 31;
        }
        if (this.date>maxdate){this.date = maxdate;}
    }
    public Day Next(){ // 次の日メソッド(ローカルデイト利用)
        LocalDate current = LocalDate.of(year, month, date);
        LocalDate next = current.plusDays(1);
        return new Day(next.getYear(), next.getMonthValue(), next.getDayOfMonth());
    }
    public Day Prev(){ // 前の日メソッド(ローカルデイト使用)
        LocalDate current = LocalDate.of(year, month, date);
        LocalDate prev = current.minusDays(1);
        return new Day(prev.getYear(), prev.getMonthValue(), prev.getDayOfMonth());
    }
    @Override // ボケ防止
    public String toString(){return year+"年"+month+"月"+date+"日";}
}