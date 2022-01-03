package com.example.graph.sorting;

import com.example.graph.bfs.BFSByLinkedList;
import com.example.graph.node.GraphNode;

import java.util.ArrayList;

public class TopologicalSortMain {

    public static void main(String[] args) {
        ArrayList<GraphNode> nodeList = new ArrayList<>();


        //create 10 nodes: v1-v10
        for(int i=1;i<6; i++) {
            nodeList.add(new GraphNode("V"+i));
        }


        //Constructor
        TopologicalSort graph = new TopologicalSort(nodeList);


        //add edges
        graph.addDirectedEdge(1,2);
        graph.addDirectedEdge(1,4);
        graph.addDirectedEdge(2,3);
        graph.addDirectedEdge(2,4);
        graph.addDirectedEdge(4,5);

        //bfs from v1
        System.out.println("Printing Topological Sort");
        graph.topologicalSort();
    }
}
