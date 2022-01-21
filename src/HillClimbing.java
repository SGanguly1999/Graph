import java.util.ArrayList;

import java.util.Random;
public class HillClimbing {

    static ArrayList<StateNode> list = new ArrayList<StateNode>();
    static CompareStateNode compare = new CompareStateNode();
    static StateNode prevNode = null;

    public static void generateStates(StateNode obj) {
        Random rand = new Random();
        int d = rand.nextInt(1,1000);
        double delta = d/1000.0;
        System.out.println("Delta--->"+delta);
        double x1 = obj.x + delta;
        double x2 = obj.x - delta;
        StateNode node1 = new StateNode(x1);
        StateNode node2 = new StateNode(x2);
        list.add(node1);
        list.add(node2);
    }
    public static void hillclimbing(StateNode node) {
        while(true) {
            list.add(node);
            generateStates(node);
            list.sort(compare);
            StateNode newNode = list.get(0);
            System.out.println(list);
            list = new ArrayList<StateNode>();
            if (prevNode.y == newNode.y)
                return;
            node = newNode;
            prevNode = newNode;
        }
    }
    public static void main(String args[]) {
        StateNode node = new StateNode(21);
        prevNode = node;
        hillclimbing(node);
        System.out.println("Minimum value of the function x2--->"+prevNode.y);
    }
}
