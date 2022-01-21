import java.util.HashMap;

public class MazeProblem extends Graph {
    static HashMap<String,Integer> map = new HashMap<String,Integer>();
    static MazeProblemData goalData;
    static int matrix[][] ={{1, 0, 0, 0},
                            {1, 1, 0, 1},
                            {0, 1, 0, 0},
                            {1, 1, 1, 1}};

    public MazeProblem(int noNodes, boolean flag) {
        super(noNodes, flag);
    }
    public static void main(String args[]) {
        MazeProblem graph = new MazeProblem(1,false);
        graph.list.get(0).data = new MazeProblemData(0,0);
        map.put("0 0",1);
        goalData = new MazeProblemData(matrix.length-1, matrix.length-1);
       // System.out.println(goalData);
        graph.goalNode = goalData;
        Search.aStar(graph,0);
        graph.displaySolutionPath();
    }

    @Override
    public int heuristicFunc(Node node) {
        MazeProblemData data = (MazeProblemData) node.data;
        return (Math.abs(goalData.x-data.x)+Math.abs(goalData.y-data.y));
    }

    @Override
    public void generateNodes(Node node) {
        MazeProblemData data = (MazeProblemData) node.data;
        int x = data.x;
        int y = data.y;
        if(validateCoordinate(x-1,y)) {
            addToList(new MazeProblemData(x-1,y),node);
        }
        if(validateCoordinate(x+1,y)) {
            addToList(new MazeProblemData(x+1,y),node);
        }
        if(validateCoordinate(x,y+1)) {
            addToList(new MazeProblemData(x,y+1),node);
        }
        if(validateCoordinate(x,y-1)) {
            addToList(new MazeProblemData(x,y-1),node);
        }
    }

    public boolean validateCoordinate(int x, int y) {
        if((x>=0 && x<matrix.length) && (y>=0 && y<matrix.length)  && matrix[x][y] == 1)
            return true;
        else
            return false;
    }
    public void addToList(MazeProblemData data,Node node){
        if(data.x == 0 && data.y == 0)
            return;
        if(!map.containsKey(data.x+" "+data.y)) {
            //System.out.println(data);
            Node node1 = new Node(no_nodes);
            no_nodes++;
            node1.data = (Data)data;
            list.add(node1);
            addEdge(node.index,no_nodes-1);
            map.put(data.x+" "+data.y,no_nodes-1);
        }
        else
            addEdge(node.index,map.get(data.x+" "+data.y));

    }
}
