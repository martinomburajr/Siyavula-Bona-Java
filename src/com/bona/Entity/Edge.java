package com.bona.Entity;

public class Edge implements com.bona.Model.EdgeFactory {

	private int id;
	private Vertex sourceVertex;
	private Vertex targetVertex;
	
	public Edge(int id, Vertex sourceVertex, Vertex targetVertex)
	{
		this.id = id;
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
	}
	
	@Override
	public Object createEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Edge createEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String toString()
	{
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
	
}
