// テキストファイルを1行ずつ、読みこんで大文字に変換して出力するクラス
import java.util.Scanner;
import java.io.*;

class TextToUpper {
    static void readAndConvert(String filename) throws IOException{
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            System.out.println(line.toUpperCase());
        }
        scanner.close();
    }
}
