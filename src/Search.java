import java.util.*;

public class Search {


    static int globalTime = 0;
    static boolean solutionFlag = false;
    private static Stack<Node> stack;

    public static void dfs(Graph graph,int index) {
        globalTime = 0;
        solutionFlag = false;
        ArrayList<Node> list = graph.list;
        Node m = list.get(index);
        stack = new Stack<Node>();
        if (m.colour == 0)
               dfs(m, list, graph);

    }

    private static void dfs(Node m, ArrayList<Node> list, Graph graph) {
        if (m.colour != 0)
            return;
        stack.add(m);
        System.out.println(stack);
        m.start_time = ++globalTime;
        m.colour = 1;
        graph.generateNodes(m);
        if(m.data.validate(graph.goalNode)) {
            solutionFlag = true;
            m.end_time = ++globalTime;
            m.colour = 2;
            graph.solutionNode = m;
            return;
        }
        for (int i : m.adjNodes) {
            Node ind = list.get(i);
            if(ind.colour == 0) {
                ind.parentNode = m;
                dfs(ind, list, graph);
            }
            if(solutionFlag) {
                return;
            }
        }
        m.end_time = ++globalTime;
        m.colour = 2;
        stack.pop();
        System.out.println(stack);
    }



    public static void bfs(Graph graph, int index) {
        globalTime = 0;
        solutionFlag = false;
        ArrayList<Node> list = graph.list;
        Queue<Node> queue = new LinkedList<>();
        Node m = list.get(index);
        queue.add(m);
        System.out.println(queue);
        m.colour = 1;
        m.start_time = ++globalTime;
        if(m.data.validate(graph.goalNode)) {
            System.out.println("Goal Found");
            solutionFlag = true;
            m.end_time = ++globalTime;
            m.colour = 2;
            graph.solutionNode = m;
            return;
        }
        while (!queue.isEmpty()) {
            Node i = queue.poll();
            Node node = i;
            System.out.println(queue);
            graph.generateNodes(node);
            for (int p : node.adjNodes) {
                if( list.get(p).colour == 0) {
                    list.get(p).colour = 1;
                    list.get(p).start_time = ++globalTime;
                    list.get(p).parentNode = node;
                    queue.add(list.get(p));
                    System.out.println(queue);
                    if(list.get(p).data.validate(graph.goalNode)) {
                        solutionFlag = true;
                        list.get(p).end_time = ++globalTime;
                        list.get(p).colour = 2;
                        graph.solutionNode = list.get(p);
                        return;
                    }
                }
            }
            node.end_time = ++globalTime;
            node.colour = 2;
        }
    }



    public static void dls(Graph graph, int depth, int index) {
        globalTime = 0;
        solutionFlag = false;
        ArrayList<Node> list = graph.list;
        Node m = list.get(index);
        if (m.colour == 0)
            dls(m, list,graph, 0, depth);
    }

    private static void dls(Node m, ArrayList<Node> list, Graph graph, int currentDepth, int depthLimit) {
        currentDepth++;
        if (m.colour != 0)
            return;
        if (currentDepth > depthLimit) {
            m.colour = 2;
            return;
        }
        m.start_time = ++globalTime;
        m.colour = 1;
        if(m.data.validate(graph.goalNode)) {
            solutionFlag = true;
            m.end_time = ++globalTime;
            m.colour = 2;
            graph.solutionNode = m;
            return;
        }
        for (int i : m.adjNodes) {
            Node ind = list.get(i);
            if(ind.colour == 0) {
                ind.parentNode = m;
                dls(ind, list, graph,currentDepth, depthLimit);
            }
            if(solutionFlag) {
                return;
            }
        }
        m.end_time = ++globalTime;
        m.colour = 2;
    }


    public static void ids(Graph graph,int index) {
        globalTime = 0;
        solutionFlag = false;
        ArrayList<Node> list = graph.list;
        for(int i=1;i<11;i++) {
            Search.dls(graph, i, index);
            if(graph.solutionNode == null) {
                graph.reinitializeGraph();
            }
            else
                return;
        }
    }

    public static void ibs(Graph graph,int index) {
        globalTime = 0;
        solutionFlag = false;
        ArrayList<Node> list = graph.list;
        for (int i = 1; i <= 1; i++) {
            Node m = list.get(index);
            if (m.colour == 0)
                ibs(m, list, graph,i);
        }
    }
    private static void ibs(Node m, ArrayList<Node> list, Graph graph,int breadthLimit) {
        if (m.colour != 0)
            return;
        m.start_time = ++globalTime;
        m.colour = 1;
        if(m.data.validate(graph.goalNode)) {
            solutionFlag = true;
            m.end_time = ++globalTime;
            m.colour = 2;
            graph.solutionNode = m;
            return;
        }
        int c=0;
        for (int i : m.adjNodes) {
            c++;
            if(c>breadthLimit)
                break;
            Node ind = list.get(i);
            if(ind.colour == 0) {
                ind.parentNode = m;
                dfs(ind, list, graph);
            }
            if(solutionFlag) {
                return;
            }
        }
        m.end_time = ++globalTime;
        m.colour = 2;
    }

    public static void uniformCostSearch(Graph graph, int index) {
        globalTime = 0;
        solutionFlag = false;
        ArrayList<Node> list = graph.list;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new NodeComparator());
        Node m = list.get(index);
        m.path_cost=0;
        queue.add(m);
        m.colour = 1;
        m.start_time = ++globalTime;
        if(m.data.validate(graph.goalNode)) {
            solutionFlag = true;
            m.end_time = ++globalTime;
            m.colour = 2;
            graph.solutionNode = m;
            return;
        }
        while (!queue.isEmpty()) {
            Node i= queue.poll();
            System.out.println( queue);
            if(i.data.validate(graph.goalNode)) {
                solutionFlag = true;
                i.end_time = ++globalTime;
                i.colour = 2;
                graph.solutionNode = i;
                return;
            }
            int count = -1;
            for (int p : i.adjNodes) {
                count++;
                Node node = list.get(p);
                int edgeValue = i.edgeValues.get(count);
                int pathCost = i.path_cost+ edgeValue;
                if( node.colour == 0) {
                    node.colour = 1;
                    node.start_time = ++globalTime;
                    node.parentNode = i;
                    queue.add(node);
                    System.out.println(queue);

                }
                if(node.path_cost > pathCost) {
                    //System.out.println(node +" "+node.path_cost+" "+pathCost);
                    node.path_cost = pathCost;
                    node.parentNode = i;
                }

            }
            i.end_time = ++globalTime;
            i.colour = 2;
        }
    }
    public static void aStar(Graph graph,int index) {
        globalTime = 0;
        solutionFlag = false;
        ArrayList<Node> list = graph.list;
        PriorityQueue<Node> queue = new PriorityQueue<Node>(new NodeComparator1());
        Node m = list.get(index);
        m.path_cost = 0;
        m.goal_cost = graph.heuristicFunc(m);
        m.total_cost = m.path_cost + m.goal_cost;
        queue.add(m);
        m.colour = 1;
        m.start_time = ++globalTime;
        if(m.data.validate(graph.goalNode)) {
            solutionFlag = true;
            m.end_time = ++globalTime;
            m.colour = 2;
            graph.solutionNode = m;
            return;
        }
        while (!queue.isEmpty()) {
            Node i= queue.poll();
            System.out.println( queue);
            if(i.data.validate(graph.goalNode)) {
                solutionFlag = true;
                i.end_time = ++globalTime;
                i.colour = 2;
                graph.solutionNode = i;
                return;
            }
            int count = -1;
            for (int p : i.adjNodes) {
                count++;
                Node node = list.get(p);
                int edgeValue = i.edgeValues.get(count);
                int pathCost = i.path_cost+ edgeValue;
                int totalCost = pathCost + graph.heuristicFunc(node);
                if( node.colour == 0) {
                    node.colour = 1;
                    node.start_time = ++globalTime;
                    node.parentNode = i;
                    queue.add(node);
                    System.out.println(queue);

                }
                if(node.total_cost > totalCost) {
                    //System.out.println(node +" "+node.path_cost+" "+pathCost);
                    node.path_cost = pathCost;
                    node.total_cost = totalCost;
                    node.parentNode = i;
                }

            }
            i.end_time = ++globalTime;
            i.colour = 2;
        }
    }
    public static void bfgs(Graph graph) {

    }
}
