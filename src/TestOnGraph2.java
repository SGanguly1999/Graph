public class TestOnGraph2 extends Graph {
    public TestOnGraph2(int noNodes, boolean flag) {
        super(noNodes, flag);
    }
    public static void main(String args[]) {
        TestOnGraph2 graph = new TestOnGraph2(9, true);
        graph.createGoalNode(10);
        graph.enterData();
        graph.addEdge(0, 1);
        graph.addEdge(0, 7);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(7, 8);
        graph.addEdge(8, 6);
        System.out.println("Starting Best First Greedy Search");
        Search.bfgs(graph,0);
        graph.displaySolutionPath();
        graph.reinitializeGraph();
        System.out.println("Starting A* Search");
        Search.aStar(graph,0);
        graph.displaySolutionPath();
    }
    @Override
    public int heuristicFunc(Node node) {
        int index = node.index;
        if(index == 0)
            return 3;
        else if(index == 1)
            return 2;
        else if(index == 2 || index == 3 || index == 4 || index == 5 || index == 8)
            return 1;
        else if(index == 7)
            return 4;
        else if(index == 6 || index == 9)
            return 0;
        else
            return 1000;
    }
}
