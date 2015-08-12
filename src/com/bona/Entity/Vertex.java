package com.bona.Entity;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.VertexFactory;

public class Vertex implements VertexFactory<Vertex>
{
	private String id;
	private String type;
	private String label;
	
	private List<Edge> incomingEdges = new ArrayList<Edge>();
	private List<Edge> outgoingEdges = new ArrayList<Edge>();
	
	public Vertex(String id, String type, String label)
	{
		this.id = id;
		this.type = type;
		this.label = label;
	}
	
	public Vertex()
	{
		
	}
	
	@Override
	public Vertex createVertex() {
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

	public List<Edge> getIncomingEdges() {
		return incomingEdges;
	}

	public void setIncomingEdges(List<Edge> incomingEdges) {
		this.incomingEdges = incomingEdges;
	}

	public List<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}

	public void setOutgoingEdges(List<Edge> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}
	
	public boolean equals(Vertex v1, Vertex v2)
	{
		if(v1.getId() == v2.getId())
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
