package com.bona.Controller;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

import com.bona.Model.Group;
import com.bona.Model.Node;

public class Driver {
	static ArrayList<Node> nodes = new ArrayList<Node>();
	static ArrayList<Group> groups = new ArrayList<Group>();
	public static void main(String args[]) throws IOException{
		 
		 BufferedReader in = new BufferedReader(new FileReader("00-chem_matter_source.map"));		 
		 String x;
		 boolean exists = false;
		 boolean adding = true;
		 
		 String label = null;
		 String type = "default";
		 String id = null;
		 Node n;
		 Group g;
		 
         while (true)
         {
        	 x= in.readLine();
        	// System.out.print(x + "\n");
        	 if (x == null )
 				break;
        	 if (x.contains("CMA") && adding){	
        		 id=getID(x);
        		 
        		 for (Node o: nodes){
        			 if (id.equals(o.getID()))
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
        			 n = new Node(id, type,label);
    	        	 nodes.add(n);
    	        	 
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
        				 for (Node node: nodes){
                			 if (id.equals(node.getID())){
                				 group.AddToGroup(node);	
                			 	System.out.println(node.getID() + " is in the group " + group.getLabel());
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
}
	 	

