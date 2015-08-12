package com.bona.Model;
import java.util.ArrayList;

import com.bona.Entity.Vertex;


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
	public String getID(){
		return this.id;
	}
	public String getLabel(){
		return this.label;
	}
	
}

