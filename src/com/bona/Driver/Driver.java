package com.bona.Driver;

import java.util.List;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.cycle.JohnsonSimpleCycles;
import org.jgrapht.alg.cycle.TarjanSimpleCycles;

import com.bona.Entity.Edge;
import com.bona.Entity.Graph;
import com.bona.Entity.Vertex;

public class Driver {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		DirectedGraph<Vertex,Edge> graph = (DirectedGraph<Vertex, Edge>) new Graph();
		Vertex v1 = new Vertex("v1","Beast 1", "Introduction to beasts");
		Vertex v2 = new Vertex("v2","Beast 2", "Introduction to beasts of air");
		Vertex v3 = new Vertex("v3","Beast 3", "Introduction to beasts of water");
		Vertex v4 = new Vertex("v4","Beast 4", "Introduction to beasts of land");
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);

		
		System.out.println(((Graph) graph).getVertices().size());
		
		
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v1, v4);
		graph.addEdge(v2, v3);
		graph.addEdge(v3, v1);
		graph.addEdge(v3, v2);
		graph.addEdge(v2, v4);
		graph.addEdge(v4, v2);
		
		System.out.println(v1.getOutgoingEdges().size());
		
		JohnsonSimpleCycles<Vertex, Edge> jsc = new JohnsonSimpleCycles<Vertex, Edge>();
		jsc.setGraph((DirectedGraph<Vertex, Edge>)graph);
		//List<List<Vertex>> simpleCycles = jsc.findSimpleCycles();
		//System.out.println(simpleCycles);
		
		TarjanSimpleCycles<Vertex, Edge> tarjanCycles = new TarjanSimpleCycles<Vertex,Edge>();
		tarjanCycles.setGraph((DirectedGraph<Vertex, Edge>)graph);
		List<List<Vertex>> tarjanSimpleCycle = tarjanCycles.findSimpleCycles();
		
		for(List<Vertex> vList : tarjanSimpleCycle)
		{
			System.out.println("\nNew List:");
			for(int i = 0; i < vList.size(); i++)
			{
				System.out.println(vList.get(i).getId());
			}		
		}
		
		
	}

}
