package com.bona.Entity.Search;

import java.util.ArrayList;
import java.util.List;

/*
 * This class sequenctially searches a list for an object - Martin-omburajr.
 */
public class SequentialSearch<V> extends SearchAlgorithm {
	
	List<V> vList = new ArrayList<V>();
	V v;
	
	public SequentialSearch(List<V> vList, V v)
	{
		this.vList = vList;
		this.v = v;
	}
	
	public V sequentialSearch()
	{
		for(int i = 0; i < this.vList.size(); i++)
		{
			if(this.vList.get(i).equals(this.v))
			{
				return this.vList.get(i);
			}
		}
		return null;
	}
	
	public Object[] sequentialSearchIndex()
	{
		Object [] array = new Object[2];
		for(int i = 0; i < this.vList.size(); i++)
		{
			if(this.vList.get(i).equals(this.v))
			{
				array[0] = i;
				array[1] = this.vList.get(i);
				return array;
			}
		}
		return null;
	}
	
	
}
