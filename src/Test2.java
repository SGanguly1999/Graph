public class Test2 {
    public static void main(String args[]) {
        Graph graph = new Graph(4, true);
        graph.createGoalNode(10);
        graph.enterData();
        graph.addEdge(0, 1,4);
        graph.addEdge(0, 3,1);
        graph.addEdge(3, 2,1);
        graph.addEdge(2, 1, 1);
        Search.uniformCostSearch(graph, 0);
        graph.displaySolutionPath();

    }
}
