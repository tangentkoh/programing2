// Dijkstra をテストする
public class DijkstraTester{
    public static void main(String[] args) {
        if (args.length != 1){
            System.out.println("適切な入力をする");
            System.exit(0);
        }
        String filename = args[0];
        int start = 0; // 今回は06で固定
        Dijkstra d = new Dijkstra();
        d.loadGraph(filename);
        int[] tree = d.doDijkstra(start);
        System.out.println();
        System.out.println("(DTe)");
        System.out.println("start = "+start+" のとき");
        for (int i=0; i<tree.length; i++){
            System.out.print(tree[i]);
            if (i!=tree.length-1){
                System.out.print(",");
            }
        }
        System.out.println();
        for(int k=0; k<=6; k++){ // 0から6まで
            int end = k;
            int[] path = d.getShortestPath(start, end);
            System.out.println("最短経路 "+start+" から "+end);
            for (int i=0; i<path.length; i++){
                System.out.print(path[i]);
                if (i!=path.length-1){
                    System.out.print("->");
                }
            }
            System.out.println(" 長さは "+(path.length-1));
        }
        System.out.println();
    }
}
