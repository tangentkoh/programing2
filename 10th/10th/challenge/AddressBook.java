// アドレス帳（複数のアドレス情報）を保持するAddressBookクラスを作成
import java.io.*;
import java.util.*;
public class AddressBook{ // アドレス帳から読込
    List<Address> list = new LinkedList<>();
    public void loadFile(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            while((line = br.readLine()) != null){
                String[] data = line.split(",");
                if(data.length == 3){list.add(new Address(data[0],data[1],data[2]));}
            }
            System.out.println("データ読み込み完了");
        } 
        catch(IOException e){System.out.println("ファイル読み込みエラー");}
    }
    public void saveFile(String filename){ // アドレス帳に保存
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            for(Address w:list){
                bw.write(w.toString());
                bw.newLine();
            }
            System.out.println("データ保存完了");
        } 
        catch(IOException g){System.out.println("ファイル書き込みエラー");}
    }
    public void addAddress(String name, String num, String mail){ // 追加
        list.add(new Address(name, num, mail));
        System.out.println("データ追加完了");
    }
    public void search(String kword){ // サーチ
        boolean f = false;
        for(Address x:list){
            if(x.getName().contains(kword)||x.getNum().contains(kword)||x.getMail().contains(kword)){
                System.out.println(x); f = true;
            }
        }
        if(!f){System.out.println("該当データなし");}
    }
    public void delete(String dword){ // 削除
        Iterator<Address> it = list.iterator();
        boolean f2 = false;
        while(it.hasNext()){
            Address y=it.next();
            if(y.getName().contains(dword)||y.getNum().contains(dword)||y.getMail().contains(dword)){
                System.out.println("削除:"+y);
                it.remove(); f2 = true;
            }
        }
        if(!f2){System.out.println("該当データなし");}
    }
}