package com.bona.Entity.Cycle;

import java.util.ArrayList;
import java.util.List;

import org.jgrapht.DirectedGraph;
import org.jgrapht.alg.cycle.TarjanSimpleCycles;

import com.bona.Entity.Edge;
import com.bona.Entity.Vertex;

public class TarjanCycle extends TarjanSimpleCycles<Vertex, Edge> {

	public TarjanCycle() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TarjanCycle(DirectedGraph<Vertex, Edge> graph) {
		super(graph);
		// TODO Auto-generated constructor stub
	}
	
	/*public String toString()
	{
		ArrayList<ArrayList<Vertex>> simpleCycles = new ArrayList<ArrayList<Vertex>>();
				simpleCycles = (ArrayList)this.findSimpleCycles();
		return "";
	}*/

}
