package l8;

import java.util.ArrayList;
import java.util.HashMap;

import l4.QueueUsingLL;

public class Graph {
	ArrayList<Vertex> vertices;
	
	public Graph() {
		vertices = new ArrayList<>();
	}
	
	public int numberVertices() {
		return vertices.size();
	}
	
	public int numberEdges() {
		int count = 0;
		for (Vertex v: vertices) {
			count += v.numberEdge();
		}
		return count/2;
	}
	
	private Vertex findVertex(String v1) {
		for (Vertex v: vertices) {
			if (v.name.equals(v1)) 
				return v;
		}
		return null;
	}
	
	public void addVertex(String name) {
		Vertex v = new Vertex(name);
		vertices.add(v);
	}
	
	private void addEdge(Vertex v1, Vertex v2) {
		Edge e = new Edge(v1, v2);
		v1.addEdge(e);
		v2.addEdge(e);
	}
	
	public void addEdge(String name1, String name2) throws VertexNotFoundException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if (v1 == null || v2 == null) {
			VertexNotFoundException e = new VertexNotFoundException();
			throw e;
		}
		addEdge(v1, v2);
	}
	
	public void removeEdge(String name1, String name2) throws VertexNotFoundException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if (v1 == null || v2 == null) {
			VertexNotFoundException e = new VertexNotFoundException();
			throw e;
		}
		
		v1.removeEdgeWith(v2);
		v2.removeEdgeWith(v1);
	}
	
	public void removeVertex(String name) throws VertexNotFoundException {
		Vertex v1 = findVertex(name);
		if (v1 == null) {
			VertexNotFoundException e = new VertexNotFoundException();
			throw e;
		}
		
		ArrayList<Vertex> adjacentVertices = v1.getAdjacentVertices();
		for (Vertex v: adjacentVertices) {
			v.removeEdgeWith(v1);
		}
		
		vertices.remove(v1);
	}
	
	private ArrayList<Vertex> hasPathBFS(Vertex v1, Vertex v2) {
		QueueUsingLL<Vertex> pendingVertices  = new QueueUsingLL<>();
		pendingVertices.enqueue(v1);
		
		HashMap<Vertex, Boolean> alreadyAdded = new HashMap<>();
		alreadyAdded.put(v1, true);
		
		HashMap<Vertex, Vertex> parent = new HashMap<>();
		parent.put(v1, null);
		
		while (!pendingVertices.isEmpty()) {
			Vertex current;
			try {
				current = pendingVertices.dequeue();
			} catch (Exception e) {
				return null;
			}
			if (current.isAdjacent(v2)) {
				parent.put(v2, current);
				break;
			}
			ArrayList<Vertex> adjacentVertices = current.getAdjacentVertices();
			for (Vertex v: adjacentVertices) {
				if (alreadyAdded.containsKey(v))
					continue;
				
				pendingVertices.enqueue(v);
				alreadyAdded.put(v, true);
				parent.put(v, current);
			}
		}
		if (!parent.containsKey(v2))
			return null;
		Vertex current = v2;
		ArrayList<Vertex> path = new ArrayList<>();
		while (current != null) {
			path.add(current);
			current = parent.get(current);
		}
		return path;
	}
	
	public boolean hasPathBFS(String name1, String name2) throws VertexNotFoundException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if (v1 == null || v2 == null) {
			VertexNotFoundException e = new VertexNotFoundException();
			throw e;
		}
		ArrayList<Vertex> path = hasPathBFS(v1, v2);
		if (path == null)
			return false;
		System.out.println("printing path");
		for (Vertex v: path)
			System.out.println(v.name);
		System.out.println("Done printing");
		return true;
	}
	
	private boolean hasPath(Vertex v1, Vertex v2, HashMap<Vertex, Boolean> visited, ArrayList<Vertex> path) {
		if (v1.isAdjacent(v2)) {
			System.out.println("Printing path");
			for (Vertex v: path) {
				System.out.println(v.name);
			}
			System.out.println(v1.name);
			System.out.println(v2.name);
			System.out.println("Done printing");
			return true;
		}
		
		visited.put(v1, true);
		
		ArrayList<Vertex> adjacentVertices = v1.getAdjacentVertices();
		path.add(v1);
		for (Vertex v: adjacentVertices) {
			if (visited.containsKey(v))
				continue;
			
			if (hasPath(v, v2, visited, path))
				return true;
		}
		path.remove(v1);
		return false;
	}
	
	public boolean hasPath(String name1, String name2) throws VertexNotFoundException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if (v1 == null || v2 == null) {
			VertexNotFoundException e = new VertexNotFoundException();
			throw e;
		}
		HashMap<Vertex, Boolean> visited = new HashMap<>();
		ArrayList<Vertex> path = new ArrayList<>();
 		return hasPath(v1, v2, visited, path);
	}
	
	public ArrayList<String> adjacentVertices(String name) throws VertexNotFoundException {
		Vertex v1 = findVertex(name);
		if (v1 == null) {
			VertexNotFoundException e = new VertexNotFoundException();
			throw e;
		}
		
		ArrayList<String> output = new ArrayList<>();
		ArrayList<Vertex> adjacentVertices = v1.getAdjacentVertices();
		for (Vertex v: adjacentVertices) {
			output.add(v.name);
		}
		return output;
	}
	
	public boolean areAdjacent(String name1, String name2) throws VertexNotFoundException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if (v1 == null || v2 == null) {
			VertexNotFoundException e = new VertexNotFoundException();
			throw e;
		}
		return v1.isAdjacent(v2);
	}
	
	public void print() {
		for (Vertex v: vertices) {
			v.print();
		}
	}
	
}
