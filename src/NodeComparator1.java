import java.util.Comparator;

public class NodeComparator1 implements Comparator<Node> {
    @Override
    public int compare(Node o1, Node o2) {
        return -(o1.total_cost - o2.total_cost);
    }
}
