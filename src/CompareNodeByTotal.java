import java.util.Comparator;

public class CompareNodeByTotal implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return (o1.total_cost - o2.total_cost);
    }
}
