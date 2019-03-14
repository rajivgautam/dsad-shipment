package com.bits.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


class GraphUtils {

    int findMinimumDistance(Graph g,char s,char d){
    	HashMap<Integer,Integer[]> codMap = new HashMap<Integer,Integer[]>();
        Set<Character> pathSet = new HashSet<>();
        int[][] matrix = g.edgeMatrix;
        Set<Character> vertices = g.getVertices();
        
        
        List<Character> ver = new ArrayList<Character>(); 
        ver.addAll(vertices);
        
        
        int[] minDistanceArray = initMinArray(s,vertices.size());
        while(!pathSet.contains(d)){
            char tempDest = getVerticeWithMinDistance(minDistanceArray, pathSet);
            pathSet.add(tempDest);
            for(char v:vertices){
                if(!pathSet.contains(v)){
                    if(matrix[tempDest - 'a'][v - 'a'] != 0 && minDistanceArray[tempDest - 'a'] + matrix[tempDest - 'a'][v - 'a'] < minDistanceArray[v - 'a']){
                        minDistanceArray[v - 'a'] = minDistanceArray[tempDest - 'a'] + matrix[tempDest - 'a'][v - 'a'];
//                        System.out.println((tempDest - 'a')+"," + (v - 'a') +"...." +minDistanceArray[v - 'a'] +"-->");
                        Integer[] cods = new Integer[2];
                        cods[0] = (tempDest - 'a');
                        cods[1] = (v - 'a');
                        codMap.put(minDistanceArray[v - 'a'], cods);
                    }
                }
            }
            
        }
        Integer[] traverse =  new Integer[2]; 
        traverse = (Integer[]) codMap.get(minDistanceArray[d - 'a']);
        
        System.out.print("Shortest path traversed from DC to Warehouse : " +ver.get(traverse[1]));
        int totest = traverse[0];
        for(int i=0;i<vertices.size();i++) {
        	Iterator<Map.Entry<Integer,Integer[]>> itr =  codMap.entrySet().iterator();
        	while(itr.hasNext()) {
            	Map.Entry<Integer,Integer[]> entry = itr.next();
            	Integer[] tr =  entry.getValue();
            	if(totest==tr[1]) {
            		System.out.print("<--" + ver.get(tr[1]));
            		totest = tr[0];
            		break;
            	}	
            }
        }
        System.out.print("<--" + ver.get(minDistanceArray[s - 'a']));
        return minDistanceArray[d - 'a'];
    }

    private int[] initMinArray(char s, int n) {
        int[] minDistanceArray = new int[n];
        for(int i=0;i<n;i++){
            int MAX_VALUE = 100;
            minDistanceArray[i] = MAX_VALUE;
        }
        minDistanceArray[s - 'a'] = 0;        
        return minDistanceArray;
    }

    private char getVerticeWithMinDistance(int[] arr,Set set){
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] < min && !set.contains((char)('a'+i))){
                minIndex = i;
                min = arr[i];
            }
        }
        return (char) (minIndex + 'a');
    }

}
