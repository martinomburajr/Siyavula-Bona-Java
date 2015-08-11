package com.bona.Entity;

import java.util.List;

public class Vertex implements com.bona.Model.VertexFactory 
{
	private String id;
	private String type;
	private String label;
	
	private List<Edge> incomingEdges;
	private List<Edge> outgoingEdges;
	
	public Vertex(String id, String type, String label)
	{
		this.id = id;
		this.type = type;
		this.label = label;
	}
	
	@Override
	public Object createVertex() {
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
	
	

}
