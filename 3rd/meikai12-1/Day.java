// 日付クラスDay【第３版】を書く
public class Day {
    private int year = 1;
    private int month = 1;
    private int date = 1;

    public Day() {}
    public Day(int year) {this.year = year;}
    public Day(int year, int month) {this(year); this.month = month;}
    public Day(int year, int month, int date) {this(year,month); this.date = date;}
    public Day(Day d) {this(d.year, d.month, d.date);}

    public int getYear() {return year;}
    public int getMonth() {return month;}
    public int getDate() {return date;}
    
    public void setYear(int year) {this.year = year;}
    public void setMonth(int month) {this.month = month;}
    public void setDate(int date) {this.date = date;}

    public void set(int year, int month, int date) {
        this.year = year;
        this.month = month;
        this.date = date;
    }
}