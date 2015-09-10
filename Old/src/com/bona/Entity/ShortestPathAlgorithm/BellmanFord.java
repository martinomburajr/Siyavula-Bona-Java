package com.bona.Entity.ShortestPathAlgorithm;

import org.jgrapht.Graph;
import org.jgrapht.alg.BellmanFordShortestPath;

import com.bona.Entity.Edge;
import com.bona.Entity.Vertex;

public class BellmanFord extends BellmanFordShortestPath<Vertex, Edge> {

	public BellmanFord(Graph graph, Vertex startVertex) {
		super(graph, startVertex);
		// TODO Auto-generated constructor stub
	}

}
