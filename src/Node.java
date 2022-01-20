import java.util.*;

public class Node {
    Data data;
    int index;
    int colour;
    int start_time;
    int end_time;
    int path_cost;
    int goal_cost;
    int total_cost;
    Node parentNode;
    ArrayList<Integer> adjNodes;
    ArrayList<Integer> edgeValues;

    public Node(int index) {
        this.index = index;
        colour = 0;
        start_time = end_time = -1;
        parentNode = null;
        path_cost = Integer.MAX_VALUE;
        goal_cost = total_cost = Integer.MAX_VALUE;
        adjNodes = new ArrayList<Integer>();
        edgeValues = new ArrayList<Integer>();
    }
    public String toString() {
        return ""+data;
    }
}
