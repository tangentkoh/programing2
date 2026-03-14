// 以下に必要な記述を追加せよ
import java.util.Calendar;
public class MyCalender{
    public static int dayOfWeek(int y, int m, int d){ // ツェラーの公式
        if(m == 1 || m == 2){y--; m += 12;}
        return(y + y / 4 - y / 100 + y / 400 + (13 * m + 8) / 5 + d) % 7;
    }
    public static int getDIM(int year, int month){ // 日数の計算
        int[] days = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        if (month == 2 && isUYear(year)){return 29;}
        return days[month - 1];
    }
    public static boolean isUYear(int year){ // 閏年の計算
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
    public static void printCalenderMonth(int year, int month){ // 実行
        System.out.printf("      %d. %d\n", year, month);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int fDay = dayOfWeek(year, month, 1); // 曜日
        int dIM = getDIM(year, month);
        for(int i = 0; i < fDay; i++){System.out.print("   ");}
        for(int day = 1; day <= dIM; day++){
            System.out.printf("%2d ", day);
            if((fDay + day) % 7 == 0){System.out.println();}
        }
        System.out.println("");
    }
    public static void main(String[] args){
        if (args.length == 0){ // 現在の年月を取得
            Calendar cal = Calendar.getInstance();
            int y = cal.get(Calendar.YEAR);
            int m = cal.get(Calendar.MONTH) + 1;
            printCalenderMonth(y,m);
        } 
		else if(args.length == 1){ // 年だけ指定された場合
            int y = Integer.parseInt(args[0]);
            for(int m=1;m<=12;m++){printCalenderMonth(y,m);}
        }
		else if(args.length >= 2){ // 年月指定
            int y = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);
            if(m>=1&&m<=12){printCalenderMonth(y,m);}
			else{System.out.println("月がレンジアウトです");}
        }
    }
}