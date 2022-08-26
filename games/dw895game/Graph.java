package games.dw895game;

import java.lang.reflect.Array;
import java.util.*;

public class Graph {

    ArrayList<ArrayList<Vertex>> vertices;
    ArrayList<Edge> edges;
    int n;

    //Given n, Graph will build an NxN graph (there will be nxn vertices)
    Graph(int n){
        this.n = n;
        buildVertices(n);
        buildEdges();
    }

    private void buildVertices(int n) {
        this.vertices = new ArrayList<ArrayList<Vertex>>();
        int value = 0;

        for(int i = 0; i < n; i++){
            ArrayList<Vertex> row = new ArrayList<Vertex>();
            for(int j = 0; j < n; j++){
                row.add(new Vertex(value));
                value++;
            }
            vertices.add(row);
        }
    }

    private void buildEdges(){
        this.edges = new ArrayList<Edge>();
        Random rand = new Random();
        int max = 6; // for random number generation

        for(int i = 0; i < this.n; i++){
            ArrayList<Vertex> row = vertices.get(i);
            for(int j = 0; j < this.n ; j++){
                //if we're all the way to the right do not add another right edge
                if(j != n-1){
                    edges.add(new Edge(row.get(j), row.get(j+1), rand.nextInt(max)));
                }
                //if we're in the top row dont check for above adjacency
                if(i != 0){
                    edges.add(new Edge(row.get(j), vertices.get(i-1).get(j), rand.nextInt(max)));
                }
            }
        }
    }

    //To sort im just going to use something like bubble sort, I really don't feel like implementing merge or quick
    public void sortEdgesByWeight(){
        ArrayList<Edge> temp = new ArrayList<>();
        for(int i = 0; i < edges.size(); i++){
            int min_index = i;
            for(int j = i + 1; j < edges.size(); j++){
                if(edges.get(min_index).cost > edges.get(j).cost){
                    min_index = j;
                }
            }
            Collections.swap(edges,i, min_index);
        }
    }


    public void printVertices(){
        for(ArrayList<Vertex> row : vertices){
            for(Vertex v : row){
                System.out.println(v.getValue());
            }
        }
    }

    public void printEdges(){
        for(Edge edge : edges){
            edge.printEdge();
        }
    }

    //this will utilize kruskals algorithm and return a list of the edges that build the tree
    public ArrayList<Edge> getMST(){
        ArrayList<Edge> MST = new ArrayList<Edge>();
        Set<Integer> u = new HashSet<Integer>();
        sortEdgesByWeight();
        for(Edge edge : edges){
            if(!u.contains(edge.v1.getValue())){
                MST.add(edge);
                u.add(edge.v1.getValue());
            }
        }

        return MST;
    }

    public void printMST(ArrayList<Edge> MST){
        for(Edge edge : MST){
            edge.printEdge();
        }
    }



    public static void main(String[] args){
        Graph g = new Graph(4);

        g.printVertices();
        g.printEdges();
        System.out.println("SORTING EDGES \n\n");

        g.sortEdgesByWeight();
        g.printEdges();

        System.out.println("Printing MST");
        ArrayList<Edge> mst = g.getMST();
        g.printMST(mst);



    }

}
