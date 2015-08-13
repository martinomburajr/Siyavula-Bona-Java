package com.bona.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jgrapht.DirectedGraph;

import com.bona.Entity.Group;
import com.bona.Entity.Vertex;

public class Parser implements Runnable {
	private static ArrayList<Vertex> vertices = new ArrayList<Vertex>();
	private static ArrayList<Group> groups = new ArrayList<Group>();
	private static ArrayList<Edge> edges = new ArrayList<Edge>();
	
	
	public static void parseFile(String textFile) throws IOException
	{
		 //textFile = "00-chem_matter_source.map";
		 BufferedReader in = new BufferedReader(new FileReader(textFile));		 
		 boolean exists = false,adding = true, grouping = true;
		 String x,label = null,type = "default",id = null,dep;
		 Vertex n= null,source = null,dest = null;
		 Group g;
		 Edge e;
		 int edgeID=0;
		 
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

       	 else if (x.contains("->")  && !(x.contains("<->"))){
       		e = new Edge(edgeID);
       		edgeID++;
       		id=getID(x);
       		dep=getDep(x);
       		
       		for (Vertex o: vertices){
     			 if (id.equals(o.getId())){
     				 e.setSourceVertex(o);
     				 break;
     			 }
       		}
       		for (Vertex o: vertices){
     			 if (dep.equals(o.getId())){
     				 e.setTargetVertex(o);
     				 break;
     			 }
      		}
       		edges.add(e);
       		System.out.print(e);
       	 }
       	 
        }
	 in.close();
	 }
	 
	private static void makeGroup(String x, BufferedReader in) throws IOException {
		
		 String id = getID(x);
		 for (Group group: groups){
			 if (id.equals(group.getId())){
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
	
	
	/*
	 * Creates the graph
	 */
	public static DirectedGraph<Vertex,Edge> addVerticesToGraph()
	{
		DirectedGraph<Vertex,Edge> graph = (DirectedGraph<Vertex,Edge>) new Graph();
		
		for(int i = 0; i < Parser.getVertices().size(); i++)
		{
			graph.addVertex(Parser.getVertices().get(i));
		}
		
		for(int i = 0; i < Parser.getEdges().size(); i++)
		{
			//graph.addEdge(sourceVertex, targetVertex)
		}
		
		return graph;
	}
	
	public static String getID(String x){
		 String id = x.substring(x.indexOf("CMA"));
		 if (id.contains(" ")){
			 id = ( id.substring(0, id.indexOf(" ")));
		 }
		return id;	 
	 }
	public static String getDep(String x){
		 String id = x.substring(x.lastIndexOf("CMA"));
		 if (id.contains(" ")){
			 id = ( id.substring(0, id.indexOf(" ")));
		 }
		return id;	 
	 }

	
	public static ArrayList<Vertex> getVertices() {
		return vertices;
	}

	public static void setVertices(ArrayList<Vertex> vertices) {
		Parser.vertices = vertices;
	}

	public static ArrayList<Group> getGroups() {
		return groups;
	}

	public static void setGroups(ArrayList<Group> groups) {
		Parser.groups = groups;
	}

	
	public static ArrayList<Edge> getEdges() {
		return edges;
	}

	public static void setEdges(ArrayList<Edge> edges) {
		Parser.edges = edges;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	



}
	 	

