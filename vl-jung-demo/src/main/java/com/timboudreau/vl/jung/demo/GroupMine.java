package com.timboudreau.vl.jung.demo;

import com.timboudreau.vl.jung.demo.VertIndex;
import java.util.ArrayList;


public class GroupMine {
	private String id;
	private String label;
	ArrayList<VertIndex> vertices = new ArrayList<VertIndex>();

//
	public GroupMine(String id, String label){
		this.id=id;
		this.label=label;
	}
	public void AddToGroup(VertIndex n){
		vertices.add(n);
	}
	public String getId(){
		return this.id;
	}
	public String getLabel(){
		return this.label;
	}
	
}

