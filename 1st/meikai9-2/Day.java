// Dayクラスを書く
public class Day {
    private int year = 1;
    private int month = 1;
    private int date = 1;

    public Day() {}
    public Day(int year) {if(year<=0)year=1;this.year = year;}
    public Day(int year, int month) {this(year);if(month<=0||month>=13)month=1;this.month = month;}
    public Day(int year, int month, int date) {this(year, month);if(date<=0||date>=32)date=1;this.date = date;}
    public Day(Day d) {this(d.year, d.month, d.date);}

    public int getYear() {return year;}
    public int getMonth() {return month;}
    public int getDate() {return date;}
}
