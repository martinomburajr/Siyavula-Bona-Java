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
       	// System.out.print(x + "\n");
       	 if (x == null )
				break;
      // 	else if (x.contains("GROUPINGS")){
      	//	 adding=false;
     // 	 }
       	else if (hasCode(x)){	
	       		        		 
	       			id=getID(x);
	       		
	       		 exists=exist(id);
	       		 
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
	       		else if (x.contains("{")){
	          		 makeGroup(x,in); 
	          	 }
	       		else if (x.contains("->")  && !(x.contains("<->"))){
	           		e = new Edge(edgeID);
	           		edgeID++;
	           		
	           		id=getSource(x);
	           		dep=getTarget(x);
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
	           		if (edgeID>=896){
	           			System.out.print("");
	           		}
	           		edges.add(e);
	           		System.out.print(e);
	           	 }
	           	 else if (x.contains("CHEMISTRY merge dependencies"))
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
		if(x.contains("CMA") || x.contains("PEE") || x.contains("CMA") || x.contains("CPR") 
	       			 || x.contains("CAC") || x.contains("CBO") || x.contains("COR") 
	       			 || x.contains("PEM") || x.contains("CRX") || x.contains("CTD")
	       			 || x.contains("PTE") || x.contains("PTTE") || x.contains("PUN")
	       			 || x.contains("MALG") || x.contains("MCP") || x.contains("MCG")
	       			 || x.contains("MNUMS") || x.contains("MOPS") || x.contains("MPROB") 
	       			 || x.contains("PM") || x.contains("POGO"))
			return true;
		else
			return false;
	}

	/*
	 * Creates the graph
	 */
	public static DirectedGraph<Vertex,Edge> populateGraph()
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
		
		String code = getCode(x); 
   		String id = x.substring(x.indexOf(code));
		 if (id.contains(" ")){
			 id = ( id.substring(0, id.indexOf(" ")));
		 }
		return id;	 
	 }
	public static String getTarget(String x){
		 x = ( x.substring(x.indexOf("->")));
		 String code = getCode(x);
		 String id = x.substring(x.lastIndexOf(code));
		 if (id.contains(" ")){
			 id = ( id.substring(0, id.indexOf(" ")));
		 }
		return id;	 
	 }
	
	public static String getSource(String x){
		 x = ( x.substring(0,x.indexOf("->")));
		
		 String code = getCode(x);
		 String id = x.substring(x.lastIndexOf(code));
		 if (id.contains(" ")){
			 id = ( id.substring(0, id.indexOf(" ")));
		 }
		return id;	 
	 }
	
	
	private static String getCode(String x) {
		String code = null;
		if (x.contains("CMA"))
   			code="CMA";
   		else if (x.contains("PEE"))
   			code="PEE";
   		else if (x.contains("CMA"))
   			code="CMA";
   		else if (x.contains("CPR"))
   			code="CPR";
   		else if (x.contains("CAC"))
   			code="CAC";
   		else if (x.contains("CBO"))
   			code="CBO";
   		else if (x.contains("COR"))
   			code="COR";
   		else if (x.contains("PEM"))
   			code="PEM";
   		else if (x.contains("CRX"))
   			code="CRX";
   		else if (x.contains("CTD"))
   			code="CTD";
   		else if (x.contains("PTE"))
   			code="PTE";
   		else if (x.contains("PTTE"))
   			code="PTTE";
   		else if (x.contains("PUN"))
   			code="PUN";
   		else if (x.contains("MALG"))
   			code="MALG";
   		else if (x.contains("MCP"))
   			code="MCP";
   		else if (x.contains("MCG"))
   			code="MCG";
   		else if (x.contains("MNUMS"))
   			code="MNUMS";
   		else if (x.contains("MOPS"))
   			code="MOPS";
   		else if (x.contains("MPROB"))
   			code="MPROB";
   		else if (x.contains("PM"))
   			code="PM";
   		else if (x.contains("POGO"))
   			code="POGO";
		return code;
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
	 	

