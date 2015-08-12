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
import com.bona.Entity.Vertex;
import com.bona.Entity.ShortestPathAlgorithm.BellmanFord;

public class Driver {
	static ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	static ArrayList<Group> groups = new ArrayList<Group>();
	final static String FILEPATH = "00-chem_matter_source.map";
	
	public static void parseFile(String textFile) throws IOException
	{
		 //textFile = "00-chem_matter_source.map";
		 BufferedReader in = new BufferedReader(new FileReader(FILEPATH));		 
		 String x;
		 boolean exists = false;
		 boolean adding = true;
		 
		 String label = null;
		 String type = "default";
		 String id = null;
		 Vertex n;
		 Group g;
		 
        while (true)
        {
       	 x= in.readLine();
       	// System.out.print(x + "\n");
       	 if (x == null )
				break;
       	 if (x.contains("CMA") && adding){	
       		 id=getID(x);
       		 
       		 for (Vertex o: vertices){
       			 if (id.equals(o.getId()))
       				 exists = true;	 
       		 }
       		 
       		 if (exists==false){
       			 System.out.println(id);
       			 if (x.contains("type"))
       				 type = x.substring(x.indexOf("type") + 6, x.indexOf(",")-1);
       			 System.out.println(type);
       			 if (x.contains("label"))
       				 label = x.substring(x.indexOf("label") + 7, x.indexOf("]")-1);
       			 System.out.println(label + "\n");
       			 n = new Vertex(id, type,label);
   	        	 vertices.add(n);
   	        	 
   	        	 if (type.equals("group")){
   	        		 g = new Group(id,label);
   	        		 groups.add(g);
   	        	 }
           	 } 
       	 }
       	 else if (x.contains("GROUPINGS")){
       		 adding=false;
       	 }
       	 else if (x.contains("{")){
       		 makeGroup(x,in);
       		 
       	 }
       	 
        }
	 in.close();
	 }
	 
	private static void makeGroup(String x, BufferedReader in) throws IOException {
		
		 String id = getID(x);
		 for (Group group: groups){
			 if (id.equals(group.getID())){
				 while (true){
   				 x= in.readLine();
   				 if (x.contains("{"))
   					 makeGroup(x,in);
   				 else if (x.contains("CMA")){
       				 id=getID(x);
       				 for (Vertex node: vertices){
               			 if (id.equals(node.getId())){
               				 group.AddToGroup(node);	
               			 	System.out.println(node.getId() + " is in the group " + group.getLabel());
               			 }
               		 }
   				 }
   				 else if(x.contains("}")){
       				 System.out.println(x);
   					 break;
   				 }
				 }
			 }	 	 
		 }
	}
	
	public static String getID(String x){
		 String id = x.substring(x.indexOf("CMA"));
		 if (id.contains(" ")){
			 id = ( id.substring(0, id.indexOf(" ")));
		 }
		return id;	 
	 }
	
	public static List<Edge> shortestPathTest()
	{
		DirectedGraph<Vertex,Edge> graph = (DirectedGraph<Vertex, Edge>) new Graph();
		Vertex v1 = new Vertex("v1","CapeTown","CT");
		Vertex v2 = new Vertex("v2","Joburg","JNB");
		Vertex v3 = new Vertex("v3","Lilongwe","LNG");
		Vertex v4 = new Vertex("v4","Ho Chin Minh City","HCM");
		
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		
		graph.addEdge(v1, v2);
		graph.addEdge(v1, v3);
		graph.addEdge(v2, v1);
		graph.addEdge(v2, v4);
		graph.addEdge(v3, v1);
		graph.addEdge(v3, v2);
		graph.addEdge(v3, v1);
		graph.addEdge(v4, v2);
		graph.addEdge(v4, v1);
		
		
		BellmanFord bf = new BellmanFord(graph,v1);
		List<Edge>shortestPath = new ArrayList<Edge>();
				shortestPath = bf.getPathEdgeList(v4);
				//shortestPath = BellmanFord.findPathBetween(graph, v1, v4);
		return shortestPath;
	}
	
	public static void main(String args[]) throws IOException{
		//Driver.parseFile(FILEPATH);
		for(Edge e : Driver.shortestPathTest())
		{
			System.out.println(e);
		}
	}


}
	 	

