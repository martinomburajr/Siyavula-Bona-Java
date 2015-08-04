package com.bona.Model;
import java.util.ArrayList;


public class Group {
	private String id;
	private String label;
	ArrayList<Node> nodes = new ArrayList<Node>();

//
	public Group(String id, String label){
		this.id=id;
		this.label=label;
	}
	public void AddToGroup(Node n){
		nodes.add(n);
	}
	public String getID(){
		return this.id;
	}
	public String getLabel(){
		return this.label;
	}
	
}

