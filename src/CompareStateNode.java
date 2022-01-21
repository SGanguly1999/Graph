import java.util.Comparator;

public class CompareStateNode implements Comparator<StateNode> {
    @Override
    public int compare(StateNode o1, StateNode o2) {
        if(o1.y > o2.y)
        return 1;
        else if(o1.y == o2.y)
            return 0;
        else
            return -1;
    }
}
