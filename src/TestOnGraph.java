public class TestOnGraph {
    public static void main(String args[]) {
        Graph graph = new Graph(5, true);
        graph.createGoalNode(10);
        graph.enterData();
        graph.addEdge(0, 1);
        graph.addEdge(2, 3);
        graph.addEdge(1, 3);
        graph.addEdge(0, 4);
        System.out.println("Starting BFS");
        Search.bfs(graph, 0);
        graph.displaySolutionPath();
        graph.reinitializeGraph();

        System.out.println("Starting DFS");
        Search.dfs(graph, 0);
        graph.displaySolutionPath();
        graph.reinitializeGraph();

        System.out.println("Starting DLS with depth limit 5");
        Search.dls(graph, 5,0);
        graph.displaySolutionPath();
        graph.reinitializeGraph();

        System.out.println("Starting IDS ");
        Search.ids(graph, 0);
        graph.displaySolutionPath();
        graph.reinitializeGraph();

        System.out.println("Starting IBS");
        Search.ibs(graph, 0);
        graph.displaySolutionPath();


    }
}
