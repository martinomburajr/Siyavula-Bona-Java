package com.bona.Entity;
import java.util.ArrayList;


public class Group {
	private String id;
	private String label;
	ArrayList<Vertex> vertices = new ArrayList<Vertex>();

//
	public Group(String id, String label){
		this.id=id;
		this.label=label;
	}
	public void AddToGroup(Vertex n){
		vertices.add(n);
	}
	public String getId(){
		return this.id;
	}
	public String getLabel(){
		return this.label;
	}
	
}

