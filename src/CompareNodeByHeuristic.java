import java.util.Comparator;

public class CompareNodeByHeuristic implements Comparator<Node> {
    public int compare(Node o1,Node o2) {
        return (o1.goal_cost - o2.goal_cost);
    }
}
