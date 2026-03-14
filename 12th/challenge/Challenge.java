// 以下に必要な記述を追加せよ
import java.util.*;
public class Challenge{
    public static void main(String[] args){
	    if (args.length != 3){
            System.out.println("適切な入力をする");
            System.exit(0);
        }
        String filename = args[0];
        String sStation = args[1];
        String eStation = args[2];
        StationGraph graph = new StationGraph();
        graph.loadStations(filename);
        int minTrans = graph.getMinTransfers(sStation, eStation);
        if (minTrans == -1) {
            System.out.println("到達不可");
        }
        else{
            System.out.println(sStation+"-"+eStation +":"+minTrans+"回");
        }
    }
}
class StationGraph{
    private Map<String, Integer> stationToId;
    private List<String> idToStation;         
    private List<List<Integer>> adjList;      
    private Map<Integer, String> stationLine;
    private int nodeCount = 0;
    public StationGraph() {
        stationToId = new HashMap<>();
        idToStation = new ArrayList<>();
        adjList = new ArrayList<>();
        stationLine = new HashMap<>();
    }
    public void loadStations(String filename){
        try (Scanner scanner = new Scanner(new java.io.File(filename),"UTF-8")){
            Map<String, List<Integer>> lineGroups = new HashMap<>();
            while(scanner.hasNextLine()){
                String line = scanner.nextLine().trim();
                if(line.isEmpty())continue;
                String[] tokens = line.split("\\s+");
                if(tokens.length < 2)continue;
                String lineName = tokens[0];
                String stationName = tokens[1];
                if(!stationToId.containsKey(stationName)){
                    stationToId.put(stationName, nodeCount);
                    idToStation.add(stationName);
                    adjList.add(new ArrayList<>());
                    nodeCount++;
                }
                int stationId = stationToId.get(stationName);
                stationLine.put(stationId, lineName);
                lineGroups.putIfAbsent(lineName, new ArrayList<>());
                lineGroups.get(lineName).add(stationId);
            }
            for(List<Integer> stations : lineGroups.values()){
                for(int i = 0; i<stations.size()-1; i++){
                    int a = stations.get(i);
                    int b = stations.get(i + 1);
                    adjList.get(a).add(b);
                    adjList.get(b).add(a);
                }
            }
        }
        catch (Exception e){
            System.out.println("ファイル読み込みエラー");
        }
    }
    public int getMinTransfers(String sSt, String eSt){
        if (!stationToId.containsKey(sSt)||!stationToId.containsKey(eSt)){
            System.out.println("駅名が見つからない");
            return -1;
        }
        int start = stationToId.get(sSt);
        int end = stationToId.get(eSt);
        Queue<Integer> queue = new LinkedList<>();
        Map<Integer, Integer> transfers = new HashMap<>(); 
        Map<Integer, String> currentLine = new HashMap<>(); 
        queue.add(start);
        transfers.put(start, 0);
        currentLine.put(start, stationLine.get(start));
        while (!queue.isEmpty()){
            int current = queue.poll();
            String lineName = currentLine.get(current);
            int transferCount = transfers.get(current);
            if (current == end){return transferCount;}
            for (int neighbor : adjList.get(current)){
                if (!transfers.containsKey(neighbor)){
                    String neighborLine = stationLine.get(neighbor);
                    int nextTransfers = transferCount;
                    if (!lineName.equals(neighborLine)){nextTransfers++;}
                    queue.add(neighbor);
                    transfers.put(neighbor, nextTransfers);
                    currentLine.put(neighbor, neighborLine);
                }
            }
        }
        return -1;
    }
}