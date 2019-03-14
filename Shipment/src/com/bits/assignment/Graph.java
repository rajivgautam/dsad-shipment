package com.bits.assignment;

import java.util.HashSet;
import java.util.Set;

class Graph {

    private HashSet<Character> vertices;
    int[][] edgeMatrix;

    Graph(){
        vertices = new HashSet<>();
    }

    void addVertices(char s,char d){
        vertices.add(s);
        vertices.add(d);
    }

    void addEdge(char s,char d,int w){
        if(null == edgeMatrix){
            edgeMatrix = new int[vertices.size()][vertices.size()];
        }
        edgeMatrix[s-'a'][d-'a'] = w;
        edgeMatrix[d-'a'][s-'a'] = w;
    }

    Set<Character> getVertices(){
        return vertices;
    }

    void fillEdgeMatrix(){
        for(int i=0;i<vertices.size();i++){
            for(int j=0;j<vertices.size();j++){
                int MAX_VALUE = 100;
                if(i != j && edgeMatrix[i][j] == 0) edgeMatrix[i][j] = MAX_VALUE;
            }
        }

    }

    void printEdgeMatrix(){
        for(int i=0;i<vertices.size();i++) {
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(edgeMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }


}
