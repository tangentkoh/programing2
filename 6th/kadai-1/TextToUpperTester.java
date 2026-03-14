import java.io.IOException;

public class TextToUpperTester {
    public static void main(String[] args) {
        try{
            TextToUpper.readAndConvert("foobar.txt");
        }
        catch(IOException e){
            System.out.println("ファイルが見つかりません");
        }
    }
}