package com.timboudreau.vl.jung.demo;


import java.util.ArrayList;
import java.util.List;


public class VertIndex 
{
	private String id;
	private String type;
	private String label;
	
	private List<EdgeMine> incomingEdges = new ArrayList<EdgeMine>();
	private List<EdgeMine> outgoingEdges = new ArrayList<EdgeMine>();
	
	public VertIndex(String id, String type, String label)
	{
		this.id = id;
		this.type = type;
		this.label = label;
	}
	
	public VertIndex()
	{
		
	}
	
	public VertIndex createVertex() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<EdgeMine> getIncomingEdges() {
		return incomingEdges;
	}

	public void setIncomingEdges(List<EdgeMine> incomingEdges) {
		this.incomingEdges = incomingEdges;
	}

	public List<EdgeMine> getOutgoingEdges() {
		return outgoingEdges;
	}

	public void setOutgoingEdges(List<EdgeMine> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}
	
	public boolean equals(VertIndex v1)
	{
		if(this.getId() == v1.getId())
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "Vertex Id: " + this.getId() + "\n" +
				"Type: " + this.getType() + "\n" +
				"Label: " + this.label+ "\n";				
	}
	
}
