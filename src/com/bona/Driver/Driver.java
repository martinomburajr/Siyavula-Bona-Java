package com.bona.Driver;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jgrapht.DirectedGraph;

import com.bona.Entity.Edge;
import com.bona.Entity.Graph;
import com.bona.Entity.Group;
import com.bona.Entity.Parser;
import com.bona.Entity.Vertex;
import com.bona.Entity.Cycle.TarjanCycle;
import com.bona.Entity.ShortestPathAlgorithm.BellmanFord;

public class Driver {

	final static String FILEPATH = "00-chem_matter_source.map";

	/*
	 * The bellmanFord shortest path algorithm will locate the shortest paths between nodes
	 */
	public static List<Edge> bellmanFordTest()
	{		
		Graph graph = (Graph) Driver.generateTestGraph();
		
		BellmanFord bf = new BellmanFord(graph,graph.getVertices().get(3));
		List<Edge>shortestPath = new ArrayList<Edge>();
				shortestPath = bf.getPathEdgeList(graph.getVertices().get(17));
				//shortestPath = BellmanFord.findPathBetween(graph, v1, v4);
		return shortestPath;
	}	
	/*
	 * The TarjanCycle Class is responsible for identifying simple cycles within the graph
	 */
	public static List<List<Vertex>> tarjanCycleTest()
	{
		Graph graph = (Graph) Driver.generateTestGraph();
		
		TarjanCycle tc = new TarjanCycle(graph);
		return tc.findSimpleCycles();
	}
	
	public static DirectedGraph<Vertex,Edge> generateTestGraph()
	{
		DirectedGraph<Vertex,Edge> graph = (DirectedGraph<Vertex, Edge>) new Graph();
		
		Vertex v1 = new Vertex("v1","CapeTown","CT");
		Vertex v2 = new Vertex("v2","Joburg","JNB");
		Vertex v3 = new Vertex("v3","Lilongwe","LNG");
		Vertex v4 = new Vertex("v4","Vancouver","VNC");
		Vertex v5 = new Vertex("v5","London","LND");
		Vertex v6 = new Vertex("v6","Anchorage","ANC");
		Vertex v7 = new Vertex("v7","Karachi","KCH");
		Vertex v8 = new Vertex("v8","Nairobi","NBO");
		Vertex v9 = new Vertex("v9","Casablanca","CSB");
		Vertex v10 = new Vertex("v10","La Paz","LPZ");
		Vertex v11 = new Vertex("v11","Bordeaux","BDX");
		Vertex v12 = new Vertex("v12","Canberra","CNB");
		Vertex v13 = new Vertex("v13","Porto Alegre","PAL");
		Vertex v14 = new Vertex("v14","Napoli","NPL");
		Vertex v15 = new Vertex("v15","Ulan Batur","ULB");
		Vertex v16 = new Vertex("v16","Nagasaki","NGS");
		Vertex v17 = new Vertex("v17","Alexandria","ALX");
		Vertex v18 = new Vertex("v18","Abu Dhabi","ABD");
		Vertex v19 = new Vertex("v19","Muscat","MSC");
		Vertex v20 = new Vertex("v20","Kashmir","KSM");

		/*
		 * Adding Vertices/Nodes
		 */
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		graph.addVertex(v7);
		graph.addVertex(v8);
		graph.addVertex(v9);
		graph.addVertex(v10);
		graph.addVertex(v11);
		graph.addVertex(v12);
		graph.addVertex(v13);
		graph.addVertex(v14);
		graph.addVertex(v15);
		graph.addVertex(v16);
		graph.addVertex(v17);
		graph.addVertex(v18);
		graph.addVertex(v19);
		graph.addVertex(v20);
		
		/*
		 * Adding Edges/Dependencies between vertices
		 */
		
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v2, v1);
		graph.addEdge(v2, v4);
		graph.addEdge(v3, v1);
		graph.addEdge(v3, v2);
		graph.addEdge(v3, v1);
		graph.addEdge(v4, v9);
		graph.addEdge(v10, v12);
		graph.addEdge(v5, v15);
		graph.addEdge(v11, v14);
		graph.addEdge(v12, v1);
		graph.addEdge(v16, v3);
		graph.addEdge(v17, v7);
		graph.addEdge(v20, v6);
		graph.addEdge(v11, v9);
		graph.addEdge(v12, v5);
		graph.addEdge(v14, v20);
		graph.addEdge(v7, v20);
		graph.addEdge(v8, v19);
		graph.addEdge(v5, v19);
		graph.addEdge(v1, v19);
		graph.addEdge(v3, v11);
		graph.addEdge(v2, v13);
		graph.addEdge(v2, v14);
		graph.addEdge(v10, v15);
		graph.addEdge(v12, v16);
		graph.addEdge(v15, v17);
		graph.addEdge(v20, v4);
		graph.addEdge(v9, v2);
		graph.addEdge(v8, v1);
		graph.addEdge(v5, v8);		
		
		return graph;
	}
	
	public static void main(String args[]) throws IOException{
		Parser.parseFile(FILEPATH);
		
		System.out.println("Groups Size: " + Parser.getGroups().size());
		System.out.println("Vertices Size: " + Parser.getVertices().size());	
	}
}
	 	

