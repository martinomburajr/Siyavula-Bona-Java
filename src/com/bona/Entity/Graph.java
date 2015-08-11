package com.bona.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.jgrapht.DirectedGraph;
import org.jgrapht.EdgeFactory;
import org.jgrapht.GraphPath;


public class Graph implements DirectedGraph<Vertex, Edge>, GraphPath {

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


	/*
	 * Implemented from the Graph Path section
	 */
	@Override
	public Graph getGraph() {
		// TODO Auto-generated method stub
		return this;
	}


	@Override
	public Object getStartVertex() {
		// TODO Auto-generated method stub
		
		
		return null;
	}


	@Override
	public Object getEndVertex() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List getEdgeList() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return 0;
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

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Override
	public Set<Edge> getAllEdges(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Edge getEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
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
		source.getOutgoingEdges().add(edge);
		
		target.getIncomingEdges().add(edge);
		edges.add(edge);
		
		i++;		
		return edge;
	}

	@Override
	public boolean addEdge(Vertex sourceVertex, Vertex targetVertex, Edge e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVertex(Vertex vertex) {
		vertices.add(vertex);
		return false;
	}

	@Override
	public boolean containsEdge(Vertex sourceVertex, Vertex targetVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Edge e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsVertex(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Edge> edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Edge> edgesOf(Vertex vertex) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVertex(Vertex v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<Vertex> vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex getEdgeSource(Edge e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vertex getEdgeTarget(Edge e) {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outDegreeOf(Vertex vertex) 	
	{
		int outDegree = (vertex).getOutgoingEdges().size();		
		return outDegree;
	}

	@Override
	public Set<Edge> outgoingEdgesOf(Vertex vertex) {
		// TODO Auto-generated method stub
		return null;
	}




	
	


}
