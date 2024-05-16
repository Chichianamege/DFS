// Name: Chidera Anamege


import java.util.Arrays;
import java.util.Stack;

class UnweightedGraph {
    private int[][] edges;
    private int numberOfVertices;

    // constructor to initialize the graph with given edges and number of vertices
    public UnweightedGraph(int[][] edges, int numberOfVertices) {
        this.numberOfVertices = numberOfVertices;
        this.edges = new int[numberOfVertices][];
        for (int i = 0; i < numberOfVertices; i++) {
            this.edges[i] = Arrays.copyOf(edges[i], edges[i].length);
        }
    }

    // method to return the number of vertices in the graph
    public int getNumOfVertices() {
        return numberOfVertices;
    }

    // method to return the neighbors of a given vertex
    public int[] getNeighbors(int vertex) {
        return edges[vertex];
    }

    // depth-first search (DFS) method using a stack for traversal
    public void dfs(int v) {
        boolean[] visited = new boolean[getNumOfVertices()];
        Stack<Integer> stack = new Stack<>();

        // initialize an empty stack and push the starting vertex onto the stack
        stack.push(v);

        // perform DFS traversal using the stack
        while (!stack.isEmpty()) {
            // pop the top item from the stack
            int u = stack.pop();

            // if 'u' is not visited, mark it as visited
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " "); // process current node here

                // get neighbors of u
                int[] neighbors = getNeighbors(u);
                for (int w : neighbors) {
                    // if w is not visited, push w onto the stack
                    if (!visited[w]) {
                        stack.push(w);
                    }
                }
            }
        }
    }
}

class UnweightedGraphWithNonrecursiveDFS extends UnweightedGraph {

    // constructor to initialize the extended graph with given edges and number of vertices
    public UnweightedGraphWithNonrecursiveDFS(int[][] edges, int numberOfVertices) {
        super(edges, numberOfVertices);
    }

    // override the dfs method to implement non-recursive DFS traversal
    @Override
    public void dfs(int v) {
        boolean[] visited = new boolean[getNumOfVertices()];
        Stack<Integer> stack = new Stack<>();

        // initialize an empty stack and push the starting vertex onto the stack
        stack.push(v);

        // perform non-recursive DFS traversal using the stack
        while (!stack.isEmpty()) {
            // pop the top item from the stack
            int u = stack.pop();

            // if 'u' is not visited, mark it as visited
            if (!visited[u]) {
                visited[u] = true;
                System.out.print(u + " "); // process current node here

                // get neighbors of u
                int[] neighbors = getNeighbors(u);
                for (int w : neighbors) {
                    // if w is not visited, push w onto the stack
                    if (!visited[w]) {
                        stack.push(w);
                    }
                }
            }
        }
    }
}

public class dsassignment11 {
    public static void main(String[] args) {
        // define the adjacency list representation of the graph
        int[][] edges = {
                {1, 2},
                {0, 3},
                {0, 3, 4},
                {1, 2, 5},
                {2, 6},
                {3},
                {4}
        };
        int numberOfVertices = 7;

        // create an instance of the extended graph class
        UnweightedGraphWithNonrecursiveDFS graph = new UnweightedGraphWithNonrecursiveDFS(edges, numberOfVertices);

        // perform DFS traversal starting from vertex 0
        System.out.println("The DFS traversal starting from vertex 0:");
        graph.dfs(0);
        System.out.println();
    }
}
