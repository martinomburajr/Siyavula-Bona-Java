package com.bona.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.EdgeFactory;
import org.jgrapht.GraphPath;


public class Graph implements DirectedGraph<Vertex, Edge>{

	List<Vertex> vertices = new ArrayList<Vertex>();
	List<Edge> edges = new ArrayList<Edge>();
	
	
	public Vertex searchList(Vertex vertex)
	{		
		for(int i = 0; i < vertices.size(); i++)
		{
			if(vertices.get(i).getId().equals(vertex.getId()))
			{
				return vertices.get(i);
			}
		}
		return null;
	}
	
	
	public Vertex addVertex (String id, String type, String label)
	{
		Vertex vertex = new Vertex(id, type, label);
		vertices.add(vertex);
		return vertex;
	}

	
	/*
	 * Checks to see if it has an incoming edge
	 * 
	 */
	public boolean containsIncomingEdge(Vertex v)
	{
		if(v.getIncomingEdges().size() != 0)
		{
			return true;
		}
		return false;
	}
	
	/*
	 * Checks to see if it has an outgoing edge
	 * 
	 */
	public boolean containsOutgoingEdge(Vertex v)
	{
		if(v.getOutgoingEdges().size() != 0)
		{
			return true;
		}
		return false;
	}

	
	public List<Vertex> getVertices() {
		return vertices;
	}


	public void setVertices(List<Vertex> vertices) {
		this.vertices = vertices;
	}


	public List<Edge> getEdges() {
		return edges;
	}


	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}

	
	
	
	/*
	 * Implemented DirectedGraph<Methods>
	 */
	
	/*
	 * (non-Javadoc)
	 * @see org.jgrapht.Graph#getAllEdges(java.lang.Object, java.lang.Object)
	 */
	
	@Override
	public Set<Edge> getAllEdges(Vertex sourceVertex, Vertex targetVertex) {
		
		Set<Edge> edgeSet = new HashSet<Edge>();
		for(Edge e : edges)
		{
			if(e.getSourceVertex().equals(sourceVertex) && e.getTargetVertex().equals(targetVertex))
			{
				edgeSet.add(e);
			}
		}
		
		return edgeSet;		
	}

	@Override
	public Edge getEdge(Vertex sourceVertex, Vertex targetVertex) {
		
		for(Edge e : edges)
		{
			if(e.getSourceVertex().equals(sourceVertex) && e.getTargetVertex().equals(targetVertex))
			{
				return e;
			}
		}
		return null;
	}

	@Override
	public EdgeFactory<Vertex, Edge> getEdgeFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge addEdge(Vertex sourceVertex, Vertex targetVertex) {

		int i = 0;
		
		Vertex source = new Vertex();
		Vertex target = new Vertex();
		
		source = this.searchList((Vertex)sourceVertex);
		target = this.searchList((Vertex)targetVertex);
		
		Edge edge = new Edge(i ,source ,target);
		edge.setSourceVertex(sourceVertex);
		source.getOutgoingEdges().add(edge);
		
		edge.setTargetVertex(targetVertex);
		target.getIncomingEdges().add(edge);
		
		
		edges.add(edge);		
		i++;		
		return edge;
	}

	@Override
	public boolean addEdge(Vertex sourceVertex, Vertex targetVertex, Edge e) {
		// TODO Auto-generated method stub
		boolean hasWorked = false;
		
		try
		{
			e.setSourceVertex(sourceVertex);
			e.setTargetVertex(targetVertex);
			sourceVertex.getOutgoingEdges().add(e);
			targetVertex.getIncomingEdges().add(e);
			
			hasWorked = true;
		}
		catch(Exception ex)
		{
			hasWorked = false;
		}
		
		return hasWorked;
	}

	@Override
	public boolean addVertex(Vertex vertex) {
		vertices.add(vertex);
		return false;
	}

	@Override
	public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex) {
		
		for(int i = 0; i < sourceVertex.getOutgoingEdges().size(); i++)
		{
			for(int j = 0; j < targetVertex.getIncomingEdges().size(); j++)
			{
				if(sourceVertex.getOutgoingEdges().get(i).equals(targetVertex.getIncomingEdges().get(j)))
				{
					return true;
				}
			}			
		}
		return false;
	}

	@Override
	public boolean containsEdge(Edge e) 
	{
		for(int i = 0; i <  edges.size(); i++)
		{
			if(edges.get(i).equals(e))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Vertex v) {
		for(int i = 0; i <  vertices.size(); i++)
		{
			if(vertices.get(i).getId() == v.getId())
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public Set<Edge> edgeSet() 
	{
		Set<Edge> edgeSet = new HashSet<Edge>();
		
		for(int i = 0; i < edges.size(); i++){
			edgeSet.add(edges.get(i));
		}
		
		return edgeSet;
	}

	@Override
	public Set<Edge> edgesOf(Vertex vertex) 
	{
		Set<Edge> edgesOf = new HashSet<Edge>();
		for(int i = 0; i < vertex.getIncomingEdges().size(); i++)
		{
			edgesOf.add(vertex.getIncomingEdges().get(i));
		}
		for(int i = 0; i < vertex.getOutgoingEdges().size(); i++)
		{
			edgesOf.add(vertex.getIncomingEdges().get(i));
		}
		return edgesOf;
	}

	@Override
	public boolean removeAllEdges(Collection<? extends Edge> edges) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Edge> removeAllEdges(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAllVertices(Collection<? extends Vertex> vertices) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Edge removeEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeEdge(Edge e) {
		
		try
		{
			if(edges.contains(e))
			{
				edges.remove(e);
				return true;
			}else
			{
				return false;
			}
		}catch(Exception ex)
		{
			return false;
		}

	}

	@Override
	public boolean removeVertex(Vertex v) {

		try
		{
			if(vertices.contains(v))
			{
				vertices.remove(v);
				return true;
			}else
			{
				return false;
			}
		}
		catch(Exception ex)
		{
			return false;
		}
	}

	@Override
	public Set<Vertex> vertexSet() 
	{
		
		Set<Vertex> vertexSet = new HashSet<Vertex>(); 
		
		for(int i = 0; i < vertices.size(); i++)
		{
			vertexSet.add(vertices.get(i));
		}
		
		return vertexSet;
	}

	@Override
	public Vertex getEdgeSource(Edge e) {
		return e.getSourceVertex();
	}

	@Override
	public Vertex getEdgeTarget(Edge e) {
		return e.getTargetVertex();
	}

	@Override
	public double getEdgeWeight(Edge e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inDegreeOf(Vertex vertex) {
		// TODO Auto-generated method stub
		int inDegree = (vertex).getIncomingEdges().size();
		
		return inDegree;
	}

	@Override
	public Set<Edge> incomingEdgesOf(Vertex vertex) {
		
		Set<Edge> incomingEdges = new HashSet<Edge>();
		
		for(Edge edges : vertex.getIncomingEdges()){
			incomingEdges.add(edges);
		}
		
		return incomingEdges;
	}

	@Override
	public int outDegreeOf(Vertex vertex) 	
	{
		int outDegree = (vertex).getOutgoingEdges().size();		
		return outDegree;
	}

	@Override
	public Set<Edge> outgoingEdgesOf(Vertex vertex) {
		
		Set<Edge> outGoingEdges = new HashSet<Edge>();
		
		for(Edge edges : vertex.getOutgoingEdges()){
			outGoingEdges.add(edges);
		}
		
		return outGoingEdges;
	}

}
