package com.bona.Model;

public class Node {
	
	private String id;
	private String type;
	private String label;
//
	public Node(String id,String type, String label){
		this.id=id;
		this.type=type;
		this.label=label;
	}
	public String getID(){
		return this.id;
	}
	public String getType(){
		return this.type;
	}
	public String getlabel(){
		return this.label;
	}
}
