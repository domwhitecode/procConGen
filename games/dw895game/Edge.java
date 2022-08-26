package games.dw895game;

public class Edge {
    Vertex v1;
    Vertex v2;
    int cost;

    public Edge(Vertex v1, Vertex v2, int cost){
        this.v1 = v1;
        this.v2 = v2;
        this.cost = cost;
    }

    public void printEdge(){
        System.out.println("vertex 1: "  + v1.getValue());
        System.out.println("Vertex 2: " + v2.getValue());
        System.out.println("Cost : " + cost);
        System.out.println("\n");
    }

}
