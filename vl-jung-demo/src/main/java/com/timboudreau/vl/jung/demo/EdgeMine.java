package com.timboudreau.vl.jung.demo;


public class EdgeMine <VertIndex,EdgeMine> {

	private int id;
	private VertIndex sourceVertex;
	private VertIndex targetVertex;
	
	public EdgeMine(int id)
	{
		this.id = id;
	}
	public EdgeMine(int id, VertIndex sourceVertex, VertIndex targetVertex)
	{
		this.id = id;
		this.sourceVertex = sourceVertex;
		this.targetVertex = targetVertex;
	}
	
	
	public EdgeMine createEdge(VertIndex sourceVertex, VertIndex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	

	public VertIndex getSourceVertex() {
		return sourceVertex;
	}

	public void setSourceVertex(VertIndex sourceVertex) {
		this.sourceVertex = sourceVertex;
	}

	public VertIndex getTargetVertex() {
		return targetVertex;
	}

	public void setTargetVertex(VertIndex targetVertex) {
		this.targetVertex = targetVertex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String toString()
	{
		return "Edge Id: " + this.getId() + "\n" ;
		//		"SourceVertexId: " + this.getSourceVertex().getId() + "\n" +
		//		"TargetVertexId: " + this.getTargetVertex().getId()+ "\n" + "\n";
	}
	
}
