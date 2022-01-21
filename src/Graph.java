import java.util.*;

public class Graph {
    int no_nodes;
    ArrayList<Node> list;
    boolean undirected;
    boolean searchFlag;
    ArrayList<Node> solutionPath;
    Node solutionNode;
    Data goalNode;

    public Graph(int noNodes, boolean flag) {
        list = new ArrayList<Node>();
        undirected = flag;
        no_nodes = noNodes;
        solutionPath = new ArrayList<Node>();
        for (int i = 0; i < noNodes; i++) {
            list.add(new Node(i));
        }
    }

    public void reinitializeGraph() {
        solutionPath = new ArrayList<Node>();
        solutionNode = null;
        for(Node m: list) {
            m.colour = 0;
            m.start_time = m.end_time = -1;
            m.path_cost = m.goal_cost = Integer.MAX_VALUE;
        }
    }

    public void createGoalNode(int data) {
        goalNode = new Data(data);
    }

    public void enterData() {
        Scanner sc =new Scanner(System.in);
        for(Node i: list) {
            System.out.println("Enter the data for node "+i.index);
            i.data = new Data(sc.nextInt());
        }
    }

    public void displaySolutionPath() {
        Node m = solutionNode;
        while (m != null) {
            System.out.print(m.data + "<----");
            m = m.parentNode;
        }
        System.out.println("null");
    }

    public void addEdge(int u, int v) {
        Node m = list.get(u);
        m.adjNodes.add(v);
        m.edgeValues.add(1);
        if (undirected) {
            m = list.get(v);
            m.adjNodes.add(u);
            m.edgeValues.add(1);
        }
    }

    public void addEdge(int u, int v, int value) {
        Node m = list.get(u);
        m.adjNodes.add(v);
        m.edgeValues.add(value);
        if (undirected) {
            m = list.get(v);
            m.adjNodes.add(u);
            m.edgeValues.add(value);
        }
    }

    public int heuristicFunc(Node node) {
        return 0;
    }

    public void generateNodes(Node node) {
        return;
    }
}
