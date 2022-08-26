package games.dw895game;

import java.util.ArrayList;



public class generateMapString{

    Graph g;
    ArrayList<Edge> MST;
    int n;
    int m;
    char[][] mapRepresentation;
    Vertex[][] vertexArray;

    generateMapString(int n){
        this.g = new Graph(n);
        MST = g.getMST();
        this.n = n;
        this.m = n + (n-1);
        this.mapRepresentation = new char[m][m];
        this.vertexArray = new Vertex[m][m];
        buildMapArray();
    }

    public void printMST(){
        for(Edge e : MST){
            e.printEdge();
        }
    }

    public void  buildMapArray(){

        //prefill with 0's and v's for verteces
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                //every other row/col is a vertex
                if(j%2 == 0 && i % 2 ==0){
                    mapRepresentation[i][j] = 'v';
                }
                else{
                    mapRepresentation[i][j] = '0';
                }
            }
        }

        //build vertex array, so we can check its value against the MST's set of edges
        buildVertexArray();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                //check each vertex to see if it has an edge that exists in the mst
                //only need to check right vertex and down vertex
                if(j%2 == 0 && i % 2 ==0){
                    //check for adjacent right vertex edge
                    if(j != (m-1)){
                        if(edgeExistsInMST(vertexArray[i][j].getValue(), vertexArray[i][j+2].getValue())){
                            mapRepresentation[i][j+1] = 'e';
                        }
                    }
                    //check for adjacent above vertex
                    if(i > 1){
                        if(edgeExistsInMST(vertexArray[i][j].getValue(), vertexArray[i-2][j].getValue())){
                            mapRepresentation[i-1][j] = 'e';
                        }
                    }
                }
            }
        }
    }

    private boolean edgeExistsInMST(int v1, int v2) {
        for(Edge e : MST){
            if(e.v1.getValue() == v1 && e.v2.getValue() == v2){
                return true;
            }
        }
        return false;
    }

    public void buildVertexArray(){
        int value = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                //every other row/col is a vertex
                if(j%2 == 0 && i % 2 ==0){
                    vertexArray[i][j] = new Vertex(value);
                    value++;
                }
                else{
                    vertexArray[i][j] = new Vertex(-1);
                }
            }
        }
    }

    public String buildMapString(){
        String returnString = "";
        for(int i = 0; i < m; i++){
            for(int j = 0; j < m; j++){
                if(mapRepresentation[i][j] == 'v' || mapRepresentation[i][j] == 'e'){
                    returnString += "<tile gid=\"57\"/>\n";
                }
                else{
                    returnString += "<tile gid=\"67\"/>\n";
                }
            }
        }
        return returnString;
    }

    public void printArray(){
        for(char[] row : mapRepresentation){
            for(char element : row){
                System.out.println(element);
            }
        }
    }

    public void printVertexArray(){
        for(Vertex[] va : vertexArray){
            for(Vertex v : va){
                System.out.println(v.getValue());
            }
        }
    }



    public static void main(String[] args){

        generateMapString ms = new generateMapString(3);
        ms.printMST();
        ms.buildMapArray();
        ms.printArray();
        //ms.buildVertexArray();
        //ms.printVertexArray();
        System.out.println(ms.buildMapString());


        //TODO: create an (N+(N-1)) x (N+(n-1)) array fill it with "O"'s
        //TODO: sift through the MST and then add to the two d array either with E for edge or V for vertex
        //TODO: Once array fully populated build the string to be passed to main so that main can add the string to the .tmx file

    }
}