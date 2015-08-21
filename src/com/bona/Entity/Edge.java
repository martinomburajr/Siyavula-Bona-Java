package com.bona.Entity;

import org.jgrapht.EdgeFactory;

public class Edge implements EdgeFactory<Vertex,Edge> {

	private int id;
	private Vertex sourceVertex;
	private Vertex targetVertex;
	
	public Edge(int id)
	{
		this.id = id;
	}
	public Edge(int id, Vertex sourceVertex, Vertex targetVertex)
	{
		this.id = id;
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
	}
	
	
	public Edge createEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public Vertex getSourceVertex() {
		return sourceVertex;
	}

	public void setSourceVertex(Vertex sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	public Vertex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(Vertex targetVertex) {
		this.targetVertex = targetVertex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public boolean equals(Edge e)
	{
		if(this.getId() == e.getId())
		{
			return true;
		}
		return false;
	}
	
	public String toString()
	{
		return "Edge Id: " + this.getId() + "\n" +
				"SourceVertexId: " + this.getSourceVertex().getId() + "\n" +
				"TargetVertexId: " + this.getTargetVertex().getId()+ "\n";
	}
	
}
