// DFSTree をテストする
// 課題3
public class DFSTester{
    public static void main(String[] args){
        if (args.length != 3){
            System.out.println("適切な入力をする");
            System.exit(0);
        }
        String filename = args[0];
        int start = Integer.parseInt(args[1]);
        int end = Integer.parseInt(args[2]);
        DFSTree dfs = new DFSTree();
        dfs.loadGraph(filename);
        int[] tree = dfs.getDFSTree(start);
        System.out.println("BFS Tree: root = 0");
        for(int i = 0; i < tree.length; i++){
            System.out.print(tree[i]);
            if (i != tree.length - 1){
                System.out.print(",");
            }
        }
        System.out.println();
        System.out.println("DFS Tree: root = "+start);
        int[] path = dfs.getPath(start, end);
        System.out.print("Shortest Path "+start+" -> "+end+"\n");
        if(path.length == 0){
            System.out.println("失敗");
        }
        else{
            for (int i=0; i<path.length; i++){
                System.out.print(path[i]);
                if(i != path.length - 1){
                    System.out.print("->");
                }
            }
            System.out.println();
            System.out.println("Path Length:"+(path.length-1));
        }
    }
}
