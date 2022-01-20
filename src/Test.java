public class Test {
    public static void main(String args[]) {
        Graph graph = new Graph(5, true);
        graph.createGoalNode(10);
        graph.enterData();
        graph.addEdge(0, 1,1);
        graph.addEdge(2, 3,2);
        graph.addEdge(1, 3,1);
        graph.addEdge(0, 4, 2);
        Search.dfs(graph, 0);
        graph.displaySolutionPath();

    }
}
