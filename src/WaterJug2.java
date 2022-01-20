import java.util.HashMap;

public class WaterJug2 extends Graph{
    static boolean baseFlag = true;
    static HashMap<String,Integer> map = new HashMap<String,Integer>();
    public WaterJug2(int noNodes, boolean flag) {
        super(noNodes, flag);
    }
    public static void main(String args[]) {
        WaterJug2 graph = new WaterJug2(1,false);
        graph.list.get(0).data = new WaterJugData(0,0);
        map.put("00",0);
        graph.goalNode = new WaterJugData(0,4);
        Search.dfs(graph,0);
        graph.displaySolutionPath();
    }

    // Fill a jar from tap

    // Empty a jar

    // Fill a jar from another jar until it gets filled or other one gets empty

    @Override
    public void generateNodes(Node node) {
        final int JAR1 = 3;
        final int JAR2 = 5;
        final int MEASURE = 4;
        WaterJugData data = (WaterJugData) node.data;
        int jar1 = data.x;
        int jar2 = data.y;
        WaterJugData data1,data2;
        if(jar1 == 0 && jar2 == 0) {
            if(!baseFlag) {
                baseFlag = false;
                return;
            }
            data1 = new WaterJugData(JAR1,0);
            addToList(data1,node);
            data1 = new WaterJugData(0, JAR2);
            addToList(data1,node);
            return;
        }
        if(jar1 == JAR1 && jar2 == JAR2)
            return;
        int rem_jar1 = JAR1 - jar1;
        int rem_jar2 = JAR2 - jar2;
        if(rem_jar1 != 0) {
            data1 = new WaterJugData(JAR1,jar2);
            addToList(data1,node);
            int fill = Math.min(jar1+jar2,JAR1);
            int updateJar2 = Math.max(jar2-fill+jar1,0);
            data1 = new WaterJugData(fill,updateJar2);
            addToList(data1,node);
        }
        if(rem_jar2 != 0){
            data1 = new WaterJugData(jar1,JAR2);
            addToList(data1,node);
            int fill = Math.min(JAR2,jar1+jar2);
            int updateJar1 = Math.max(jar2-fill+jar1,0);
            data1 = new WaterJugData(updateJar1,fill);
            addToList(data1,node);
        }
        if(jar1 != 0) {
            data1 = new WaterJugData(0,jar2);
            addToList(data1,node);
        }
        if(jar2 != 0) {
            data1 = new WaterJugData(jar1,0);
            addToList(data1,node);
        }
    }

    public void addToList(WaterJugData data,Node node){
        if(data.x == 0 && data.y == 0)
            return;
        //System.out.println(data);
        if(!map.containsKey(data.x+""+data.y)) {
            //System.out.println(data);
            Node node1 = new Node(no_nodes);
            no_nodes++;
            node1.data = (Data)data;
            list.add(node1);
            addEdge(node.index,no_nodes-1);
            map.put(data.x+""+data.y,no_nodes-1);
        }
        else
            addEdge(node.index,map.get(data.x+""+data.y));

    }

}
