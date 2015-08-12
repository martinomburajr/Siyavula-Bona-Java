package com.bona.Controller;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.bona.Entity.Graph;
import com.bona.Entity.Group;
import com.bona.Entity.Vertex;
import com.jgraph.algebra.JGraphFibonacciHeap.Node;

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
	
	public static void main(String args[]) throws IOException{
		Driver.parseFile(FILEPATH);
	}

	public static String getID(String x){
		 String id = x.substring(x.indexOf("CMA"));
		 if (id.contains(" ")){
			 id = ( id.substring(0, id.indexOf(" ")));
		 }
		return id;
		 
	 }
}
	 	

