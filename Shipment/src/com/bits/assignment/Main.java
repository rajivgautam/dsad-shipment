package com.bits.assignment;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        File f = new File("src/resources/inputPS3.txt");
        BufferedReader br = new BufferedReader(new FileReader(f));
        Graph g = new Graph();
        List<String> lines = new ArrayList<>();
        String s;
        while(null != (s = br.readLine())){
            lines.add(s);
        }
        for(String line:lines){
            String[] words = line.split("/");
            char source = words[0].charAt(0);
            char destination = words[1].charAt(0);
            g.addVertices(source,destination);
        }
        for(String line:lines){
            String[] words = line.split("/");
            char source = words[0].charAt(0);
            char destination = words[1].charAt(0);
            g.addEdge(source,destination,Integer.parseInt(words[2]));
        }
 //      System.out.println("Matrix with Edge Weights:");
 //      g.printEdgeMatrix();
        g.fillEdgeMatrix();
        int distance = new GraphUtils().findMinimumDistance(g,'a','j');
        System.out.print("  ||  ");
        System.out.println("Minimum distance from DC to warehouse is: " + distance +"Km");
        System.out.print("Expected time of arrival of the shipment at the warehouse if the truck speed is 60 km/hr is: ");
        double time = (double)distance/60;
        //System.out.println("t = d/s ===>" + time + "hr.");
        System.out.println(time + "hr.");
        System.out.println("After converting into minutes : "+time*60+"min.");



    }



}
