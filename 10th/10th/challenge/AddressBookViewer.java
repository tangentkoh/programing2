// アドレス帳を表示・管理するためのAddressBookViewerクラスを作成
import java.util.Scanner;
public class AddressBookViewer {
    public static void main(String[] args) {
        AddressBook bk = new AddressBook();
        Scanner stdIn = new Scanner(System.in);
        String filename = "address.csv";
        while(true) {
            System.out.println("☆アドレス帳アプリ☆");
            System.out.println("1:アドレス帳読み込み");
            System.out.println("2:アドレス帳保存");
            System.out.println("3:アドレス検索");
            System.out.println("4:アドレス追加");
            System.out.println("5:アドレス削除");
            System.out.println("0:終了");
            System.out.print("選択する:");
            int choice = stdIn.nextInt();
            stdIn.nextLine();
            if(choice==0){System.out.println("アプリ終了"); break;}
            switch(choice){
                case 1:
                    bk.loadFile(filename); break;
                case 2:
                    bk.saveFile(filename); break;
                case 3:
                    System.out.print("検索キーワード入力:");
                    String keyword = stdIn.nextLine();
                    bk.search(keyword); break;
                case 4:
                    System.out.print("名前:");
                    String name = stdIn.nextLine();
                    System.out.print("電話番号:");
                    String num = stdIn.nextLine();
                    System.out.print("メールアドレス:");
                    String mail = stdIn.nextLine();
                    bk.addAddress(name, num, mail); break;
                case 5:
                    System.out.print("削除キーワードを入力:");
                    String delword = stdIn.nextLine();
                    bk.delete(delword); break;
                default:
                    System.out.println("無効");
            }
        }
        stdIn.close();
    }
}
