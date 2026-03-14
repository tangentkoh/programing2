// 以下に必要な記述を追加せよ
// 他に必要に応じてクラス定義等を追加して課題を解くこと。
// また、make test でテストできるよう Makfile を書くこと。
import java.util.ArrayList;
public class Challenge {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("適性な入力をする");
            System.exit(0);
        }
        String filename = args[0];
        int start = 0; // 今回は固定
        int end = 2;
        Dijkstra2 d2 = new Dijkstra2(filename);
        d2.findShortestPaths(start);
        ArrayList<ArrayList<Integer>> shortestPaths = d2.getAllShortestPaths(end);
        System.out.println();
        System.out.println("(Cha)");
        System.out.println(start + " から " + end + " への最短パス");
        System.out.println("同一距離のものは " + shortestPaths.size() + " つ");
        for (ArrayList<Integer> path : shortestPaths) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i));
                if (i < path.size() - 1) {
                    System.out.print("->");
                }
            }
            System.out.println();
        }
    }
}