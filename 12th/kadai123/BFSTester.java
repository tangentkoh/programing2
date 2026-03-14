// BFSTree をテストする
// 課題2
public class BFSTester{
    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("適切な入力をする");
            System.exit(0);
        }
        String filename = args[0];
        int start = Integer.parseInt(args[1]);
        int end = Integer.parseInt(args[2]);
        BFSTree bfs = new BFSTree();
        bfs.loadGraph(filename);
        int[] tree = bfs.getBFSTree(start);
        System.out.println("BFS Tree: root = "+start);
        for (int i=0; i<tree.length; i++){
            System.out.print(tree[i]);
            if (i!=tree.length-1){
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("DFS Tree: root = 0");
        int[] path = bfs.getShortestPath(start, end);
        System.out.print("Shortest Path "+start+" -> "+end+"\n");
        if (path.length == 0){
            System.out.println("間違いが発生した");
        } 
        else{
            for (int i=0; i<path.length; i++){
                System.out.print(path[i]);
                if (i!=path.length-1){
                    System.out.print("->");
                }
            }
            System.out.println();
            System.out.println("Path Length "+(path.length-1));
        }
    }
}
