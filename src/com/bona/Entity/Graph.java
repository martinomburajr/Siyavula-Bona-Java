package com.bona.Entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import com.bona.Model.*;
import com.bona.Model.DirectedGraph;
import com.bona.Model.EdgeFactory;

public class Graph implements DirectedGraph, GraphPath {

	List<Vertex> vertices = new ArrayList<Vertex>();
	List<Edge> edges = new ArrayList<Edge>();

	@Override
	public Set getAllEdges(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public Object getEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EdgeFactory getEdgeFactory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object addEdge(Object sourceVertex, Object targetVertex) {

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
	
	
	

	@Override
	public boolean addEdge(Object sourceVertex, Object targetVertex, Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addVertex(Object v) {
		Vertex vertex = (Vertex)v;
		return false;
	}
	
	public Vertex addVertex (String id, String type, String label)
	{
		Vertex vertex = new Vertex(id, type, label);
		vertices.add(vertex);
		return vertex;
	}

	@Override
	public boolean containsEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsEdge(Object e) {
		// TODO Auto-generated method stub
		return false;
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

	@Override
	public boolean containsVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set edgeSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set edgesOf(Object vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAllEdges(Collection edges) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set removeAllEdges(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeAllVertices(Collection vertices) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object removeEdge(Object sourceVertex, Object targetVertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean removeEdge(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeVertex(Object v) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set vertexSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEdgeSource(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getEdgeTarget(Object e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getEdgeWeight(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int inDegreeOf(Object vertex) {
		// TODO Auto-generated method stub
		
		int inDegree = ((Vertex)vertex).getIncomingEdges().size();
		
		return inDegree;
	}

	@Override
	public Set incomingEdgesOf(Object vertex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int outDegreeOf(Object vertex) {
		// TODO Auto-generated method stub
		
		int outDegree = ((Vertex)vertex).getOutgoingEdges().size();
		
		return outDegree;
	}

	@Override
	public Set outgoingEdgesOf(Object vertex) {
		// TODO Auto-generated method stub
		return null;
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
	
	


}
