package com.bona.Driver;

import com.bona.Entity.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph graph = new Graph();
		Vertex v1 = graph.addVertex("food","Beast 1", "Introduction to beasts");
		Vertex v2 = graph.addVertex("food2","Beast 2", "Introduction to beasts of air");
		Vertex v3 = graph.addVertex("food3","Beast 3", "Introduction to beasts of water");
		Vertex v4 = graph.addVertex("food4","Beast 4", "Introduction to beasts of land");
		
		System.out.println(graph.getVertices().size());
		
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v1, v4);
		graph.addEdge(v2, v3);
		
		System.out.println(v1.getOutgoingEdges().size());

	}

}
