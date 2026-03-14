// 以下に必要な記述を追加せよ
import java.io.*;
public class FileCopy{
    public static void main(String[] args){
	    if(args.length != 2){
            System.out.println("使用法:java FileCopy コピー元 コピー先");
            System.out.println("例:java FileCopy srcfile dstfile");
            System.exit(0);
        }
        String srcfilename = args[0];
        String dstfilename = args[1];
        File dstFile = new File(dstfilename); // 警告用の判定
        if (dstFile.exists()) {
            System.out.println("警告:コピー先ファイルは既に存在する為、中止する");
            System.exit(1);
        }
        try{
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(srcfilename)));
            DataOutputStream out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(dstfilename)));
            try{
                while (true) {
                    byte b = in.readByte();
                    out.writeByte(b);
                }
            }
            catch(EOFException e){System.out.println(e);} // 離脱用
            in.close();
            out.close();
        }
        catch(IOException e){System.out.println(e);}
    }
}
