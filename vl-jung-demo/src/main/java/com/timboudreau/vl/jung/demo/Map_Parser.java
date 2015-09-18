/* 
 * Copyright (c) 2013, Tim Boudreau
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package com.timboudreau.vl.jung.demo;

import edu.uci.ics.jung.graph.Forest;
import edu.uci.ics.jung.graph.event.GraphEvent.Edge;
import edu.uci.ics.jung.graph.event.GraphEvent.Vertex;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.collections15.Factory;

/**
 * Demonstrates the visualization of a Tree using TreeLayout and BalloonLayout.
 * An examiner lens performing a hyperbolic transformation of the view is also
 * included.
 *
 * @author Tom Nelson
 */
@SuppressWarnings("serial")
public class Map_Parser {

    private static ArrayList<VertIndex> vertices = new ArrayList<VertIndex>();
    private static ArrayList<GroupMine> groups = new ArrayList<GroupMine>();
    private static ArrayList<EdgeMine> edges = new ArrayList<EdgeMine>();
    
// Code borrowed from JUNG's demos

    Factory<Integer> edgeFactory = new Factory<Integer>() {
        int i = 0;
        public Integer create() {
            return i++;
        }
    };

 /*   Forest<String, Integer> createTree(Forest<String, Integer> graph) {
       
        
        
        
        graph.addVertex("A0");
         return null;
        /*
        graph.addEdge(edgeFactory.create(), "A0", "B0");
        graph.addEdge(edgeFactory.create(), "A0", "B1");
        graph.addEdge(edgeFactory.create(), "A0", "B2");

        graph.addEdge(edgeFactory.create(), "B0", "C0");
        graph.addEdge(edgeFactory.create(), "B0", "C1");
        graph.addEdge(edgeFactory.create(), "B0", "C2");
        graph.addEdge(edgeFactory.create(), "B0", "C3");

        graph.addEdge(edgeFactory.create(), "C2", "H0");
        graph.addEdge(edgeFactory.create(), "C2", "H1");

        graph.addEdge(edgeFactory.create(), "B1", "D0");
        graph.addEdge(edgeFactory.create(), "B1", "D1");
        graph.addEdge(edgeFactory.create(), "B1", "D2");

        graph.addEdge(edgeFactory.create(), "B2", "E0");
        graph.addEdge(edgeFactory.create(), "B2", "E1");
        graph.addEdge(edgeFactory.create(), "B2", "E2");

        graph.addEdge(edgeFactory.create(), "D0", "F0");
        graph.addEdge(edgeFactory.create(), "D0", "F1");
        graph.addEdge(edgeFactory.create(), "D0", "F2");

        graph.addEdge(edgeFactory.create(), "D1", "G0");
        graph.addEdge(edgeFactory.create(), "D1", "G1");
        graph.addEdge(edgeFactory.create(), "D1", "G2");
        graph.addEdge(edgeFactory.create(), "D1", "G3");
        graph.addEdge(edgeFactory.create(), "D1", "G4");
        graph.addEdge(edgeFactory.create(), "D1", "G5");
        graph.addEdge(edgeFactory.create(), "D1", "G6");
        graph.addEdge(edgeFactory.create(), "D1", "G7");

        graph.addEdge(edgeFactory.create(), "A0", "HA1");
        graph.addEdge(edgeFactory.create(), "A0", "HA2");
        graph.addEdge(edgeFactory.create(), "A0", "HA3");
       	graph.addEdge(edgeFactory.create(), "HA3", "I1");
       	graph.addEdge(edgeFactory.create(), "HA3", "I2");
        
       	graph.addEdge(edgeFactory.create(), "I2", "J1");
       	graph.addVertex("K0");
       	graph.addEdge(edgeFactory.create(), "K0", "K1");
       	graph.addEdge(edgeFactory.create(), "K0", "K2");
       	graph.addEdge(edgeFactory.create(), "K0", "K3");
       	
       	graph.addVertex("J0");
    	graph.addEdge(edgeFactory.create(), "J0", "J1");
    	graph.addEdge(edgeFactory.create(), "J0", "J2");
    	graph.addEdge(edgeFactory.create(), "J1", "J4");
    	graph.addEdge(edgeFactory.create(), "J2", "J3");
        
    	graph.addEdge(edgeFactory.create(), "J2", "J5");
    	graph.addEdge(edgeFactory.create(), "J4", "J6");
    	graph.addEdge(edgeFactory.create(), "J4", "J7");
    	graph.addEdge(edgeFactory.create(), "J3", "J8");
    	graph.addEdge(edgeFactory.create(), "J6", "B9");
        return graph;
                
    }*/
    
    
    Forest<String, Integer> createTree(Forest<String, Integer> graph)throws IOException
{
            String textFile = "01-chem_matter_source.map";
            BufferedReader in = new BufferedReader(new FileReader(textFile));		 
            boolean exists = false,adding = true, grouping = true,first=true;
            String x,label = null,type = "default",id = null,dep,cat;
            VertIndex n= null,source = null,dest = null;
            GroupMine g;
            EdgeMine e;

            int edgeID=0;
		 
		 
        while (true)
        {
        	exists = false;
       	 	x= in.readLine();
               
       	
       	 if (x == null ||x.contains("External nodes") )
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
                               
                                 
                                 graph.addVertex(id);

                                 n = new VertIndex(id, type,label);
	   	        	 vertices.add(n);
	   	        	 
	   	        	 if (type.equals("group")){    // if a group create new group
	   	        		 g = new GroupMine(id,label);
	   	        		 groups.add(g);
	   	        	 }
	           	 } 

	       		else if (x.contains("{")){  		// make the group recursively
	          		 makeGroup(x,in); 
	          	 }
	       		else if (x.contains("->")  && !(x.contains("<->"))){    // create edge
                                
                            
	           		e = new EdgeMine(edgeID);
	           		edgeID++;
	           		
	           		id=getSource(x);									// get source node ID
	           		dep=getTarget(x);									// get target node ID
                                
	           		
                                if (exist(id)==false || exist(dep)==false)
	           				continue;	
                                
                                graph.addEdge(edgeFactory.create(), id, dep);
                                
	           		for (VertIndex o: vertices){
	         			 if (id.equals(o.getId())){
	         				// e.setSourceVertex(o);
	         				 break;
	         			 }
	           		}
	           		for (VertIndex o: vertices){
	         			 if (dep.equals(o.getId())){
	         				// e.setTargetVertex(o);
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
        return graph;
       	 }
       	      
	 private static boolean exist(String id) {
		for (VertIndex o: vertices){
  			 if (id.equals(o.getId()))
  				 return true;	 
  		 }
		return false;
	}


	private static void makeGroup(String x, BufferedReader in) throws IOException {
		
		 String id = getID(x);
		 for (GroupMine group: groups){
			 if (id.equals(group.getId())){
				 while (true){
   				 x= in.readLine();
   				 if (x.contains("{"))
   					 makeGroup(x,in);
   				 else if (hasCode(x)){
       				 id=getID(x);
       				 for (VertIndex node: vertices){
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

        public static void main(String [] args)
        {
            
            Map_Parser.createTree()
            
            System.out.println("Vertices " + vertices.size());
            System.out.println("Edges " + edges.size());
        }
}
