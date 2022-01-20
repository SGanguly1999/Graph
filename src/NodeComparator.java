import java.util.Comparator;

public class NodeComparator implements Comparator<Node> {
    public int compare(Node o1,Node o2) {
        return -(o1.path_cost - o2.path_cost);
    }
}
