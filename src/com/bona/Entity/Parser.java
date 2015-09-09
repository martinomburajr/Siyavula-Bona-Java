package com.bona.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

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
		 String x,label = null,type = "default",id = null,dep,cat;
		 Vertex n= null,source = null,dest = null;
		 Group g;
		 Edge e;
		 int edgeID=0;
		 
		 
        while (true)
        {
        	exists = false;
       	 	x= in.readLine();
       	
       	 if (x == null )
				break;
      // 	else if (x.contains("GROUPINGS")){
      	//	 adding=false;
     // 	 }
       	else if (hasCode(x)){	   // Check is the line has an ID code.
	       		        		 
	       		id=getID(x);   // Extract the ID.
	       		
	       		 exists=exist(id);  // Check if the node exists.

	       		 if (exists==false){				// if new node add it and reap type, label.
	       			 System.out.println(id);
	       			 if (x.contains("type"))
	       				 type = x.substring(x.indexOf("type") + 6, x.indexOf(",")-1);
	       			 System.out.println(type);
	       			 if (x.contains("label"))
	       				 label = x.substring(x.indexOf("label") + 7, x.indexOf("]")-1);
	       			 System.out.println(label + "\n");
	       			 n = new Vertex(id, type,label);
	   	        	 vertices.add(n);
	   	        	 
	   	        	 if (type.equals("group")){    // if a group create new group
	   	        		 g = new Group(id,label);
	   	        		 groups.add(g);
	   	        	 }
	           	 } 

	       		else if (x.contains("{")){  		// make the group recursively
	          		 makeGroup(x,in); 
	          	 }
	       		else if (x.contains("->")  && !(x.contains("<->"))){    // create edge
	           		e = new Edge(edgeID);
	           		edgeID++;
	           		
	           		id=getSource(x);									// get source node ID
	           		dep=getTarget(x);									// get target node ID
	           		if (exist(id)==false || exist(dep)==false)
	           				continue;									
	           	
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
	           	 else if (x.contains("CHEMISTRY merge dependencies"))		// TODO
	           		 break;
	            }
       	
	       		 
	       	 }
       	 }
       	      
	 
	private static boolean exist(String id) {
		for (Vertex o: vertices){
  			 if (id.equals(o.getId()))
  				 return true;	 
  		 }
		return false;
	}


	private static void makeGroup(String x, BufferedReader in) throws IOException {
		
		 String id = getID(x);
		 for (Group group: groups){
			 if (id.equals(group.getId())){
				 while (true){
   				 x= in.readLine();
   				 if (x.contains("{"))
   					 makeGroup(x,in);
   				 else if (hasCode(x)){
       				 id=getID(x);
       				 for (Vertex node: vertices){
               			 if (id.equals(node.getId())){
               				 group.AddToGroup(node);	
               			 	System.out.println(node.getId() + " is in the group " + group.getLabel());
               			 }
               		 }
   				 }
   				 else if(x.contains("}")){
   					 break;
   				 }
				 }
			 }	 	 
		 }
	}
	
	
	private static boolean hasCode(String x) {
		x=x.trim();
		if (x.length()<1 || !Character.isUpperCase(x.charAt(0))) return false;
		
		for (int p=0; p < x.length(); p++){
			if (Character.isUpperCase(x.charAt(p)))
				if (Character.isDigit(x.charAt(p+1))) return true;
			else continue;				
		}
		return false;
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
		
		String code= getCode(x); 
		return code;
  
	 }
	public static String getTarget(String x){
		 x = ( x.substring(x.indexOf("->")+2));
		 String id = getCode(x);
		 return id;
	
	 }
	
	public static String getSource(String x){
		 x = ( x.substring(0,x.indexOf("->")));
		
		 String id = getCode(x);
		 return id;

	 }
	
	
	private static String getCode(String x) {
		String id = x.trim();
		while (id.contains(" "))
			id= ( id.substring(0,id.length()-1));
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
	 	

