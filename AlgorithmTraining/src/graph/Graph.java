package graph;

import java.util.ArrayList;
import java.util.HashMap;

import assignments.QueueEmptyException;
import assignments.QueueUsingLL;

public class Graph {

	ArrayList<Vertex>vertices;
	public Graph() {
		// TODO Auto-generated constructor stub
		vertices = new ArrayList<>();
	}
	
	
	//return total number of vertices
	public int numberofVertices() {
		return vertices.size();
	}
	
	//return total number of edges
	public int numberofEdges() {
		int counedge = 0;
		for (Vertex currentVertex : vertices) {
			counedge += currentVertex.countEdges();
		}
		return (counedge/2);
	}
	
	//add the vertex in vertices list
	public void addVertex(String name) {
		Vertex v = new Vertex(name);
		vertices.add(v);
	}
	
	//This will find the vertex and then call add(v1,v2) to add edge b/w v1,v2
	public void addEdges(String name1, String name2)throws VertexNotFoundException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if(v1 == null || v2 == null){
			throw new VertexNotFoundException();
		}
		addEdges(v1,v2);
	}
	
	//add edges between two vertices 
	private void addEdges(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		Edge e = new Edge(v1, v2);
		v1.addEdge(e);
		v2.addEdge(e);
	}

	// return vertex if it present in vertices list
	private Vertex findVertex(String name1) {
		// TODO Auto-generated method stub
		if (vertices.size() == 0) {
			return null;
		} else {
			for (Vertex currentVertex : vertices) {
				if (currentVertex.name.equals(name1))
					return currentVertex;
			}
		}
		return null;
	}
	
	//print vertex and its corresponding nodes
	public void printVertexeandEdges() {
		for (Vertex currentVertex : vertices) {
			currentVertex.print();
		}
	}
	
	//return name of adjacent vertex of given vertex
	public ArrayList<String> adjacentVertices(String name)throws VertexNotFoundException {
		Vertex v = findVertex(name);
		if(v == null){
			throw new VertexNotFoundException();
		}
		ArrayList<String>adjacentVetexName = new ArrayList<>();
		
		ArrayList<Vertex>adjacentVertices = v.getAdjacentVertices();
		for (Vertex vertex : adjacentVertices) {
			adjacentVetexName.add(vertex.name);
		}
		return adjacentVetexName;
	}
	
	//remove edge between two nodes if it present
	public void removeEdge(String name1,String name2)throws VertexNotFoundException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if(v1 == null || v2 == null){
			throw new VertexNotFoundException();
		}
		v1.removeEdgeWith(v2);
		v2.removeEdgeWith(v1);
	}
	
	//remove a vertex if it present in vertices list
	public void removeVertex(String name)throws VertexNotFoundException {
		
		Vertex removeVertex = findVertex(name);
		if(removeVertex == null){
			throw new VertexNotFoundException();
		}
	
		ArrayList<Vertex> adjacentVertices = removeVertex.getAdjacentVertices();
		for (Vertex vertex : adjacentVertices) {
			vertex.removeEdgeWith(removeVertex);
		}
		vertices.remove(removeVertex);	
	}
	
	//check if two vertex are adjacent or not 
	public boolean areAdjacent(String name1, String name2)throws VertexNotFoundException {
		
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if(v1 == null || v2 == null){
			throw new VertexNotFoundException();
		}	
		return v1.isAdjacentTO(v2);
	}
	
	//Depth First Search algorithm to find a connection b/w given two vertex
	public boolean hasPathDFS(String name1,String name2)throws VertexNotFoundException{
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if(v1 == null || v2 == null){
			throw new VertexNotFoundException();
		}
		HashMap<Vertex, Boolean>visited = new HashMap<>();
		ArrayList<Vertex> path = new ArrayList<>();
		path.add(v1);
		return hasPathDFS(v1,v2,visited,path);
	}

	private boolean hasPathDFS(Vertex v1, Vertex v2,HashMap<Vertex, Boolean>visited,ArrayList<Vertex>path) {
		// TODO Auto-generated method stub
		
		if(v1.isAdjacentTO(v2)){
			path.add(v2);
			for (Vertex vertex : path) {
				System.out.print(vertex.name+"--->");
			}
			return true;
		}
		visited.put(v1, true);
		ArrayList<Vertex> adjacentVertex = v1.getAdjacentVertices(); 
		
		for (Vertex vertex : adjacentVertex) {
			if(visited.containsKey(vertex)){
				continue;
			}
			path.add(vertex);
			if(hasPathDFS(vertex, v2, visited,path)){
				return true;
			}
			else {
				path.remove(path.size()-1);
			}
		}
		return false;
	}
		
	//Breadth First Search algorithm to find a connection b/w given two vertex 
	public boolean hasPathBFS(String name1, String name2)throws VertexNotFoundException,QueueEmptyException {
		Vertex v1 = findVertex(name1);
		Vertex v2 = findVertex(name2);
		if(v1 == null || v2 == null){
			throw new VertexNotFoundException();
		}
		return hasPathBFS(v1,v2);
	}


	private boolean hasPathBFS(Vertex v1, Vertex v2) {
		// TODO Auto-generated method stub
		HashMap<Vertex, Boolean>visited = new HashMap<>();
		HashMap<Vertex, Vertex>parent = new HashMap<>();
		QueueUsingLL<Vertex> pendingVertex = new QueueUsingLL<>();
		visited.put(v1, true);
		parent.put(v1, null);
		pendingVertex.enqueue(v1);
		while (!pendingVertex.isEmpty()) {
			Vertex currentVertex = null;
			try {
				currentVertex = pendingVertex.dequeue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ArrayList<Vertex> adjacentVertices = currentVertex.getAdjacentVertices();
			for (Vertex adjacentVertex : adjacentVertices) {
				if(!visited.containsKey(adjacentVertex)){
					parent.put(adjacentVertex, currentVertex);
					visited.put(adjacentVertex, true);
					pendingVertex.enqueue(adjacentVertex);
					if(adjacentVertex.isAdjacentTO(v2)){
						parent.put(v2, adjacentVertex);
						System.out.print(v2.name+"--->");
						while(parent.get(v2) != null){
							v2 = parent.get(v2);
							System.out.print(v2.name+"--->");
						}
						return true;
					}
				}
				
			}
		}
		
		return false;
	}
	
	//check if the graph is connected or not
	public boolean isConected() {
		QueueUsingLL<Vertex> pendindVertex = new QueueUsingLL<>();
		HashMap<Vertex, Boolean>alreadyVisited = new HashMap<>();
		ArrayList<Vertex>visitedVertex = new ArrayList<>();
		alreadyVisited.put(this.vertices.get(0), true);
		pendindVertex.enqueue(this.vertices.get(0));
		visitedVertex.add(this.vertices.get(0));
		while (!pendindVertex.isEmpty()) {
			Vertex currentVertex = null;
			try {
					currentVertex = pendindVertex.dequeue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ArrayList<Vertex>adjacentVertices = currentVertex.getAdjacentVertices();
			for (Vertex adjacentVertex : adjacentVertices) {
				if (alreadyVisited.containsKey(adjacentVertex)){
					continue;
				}else {
					pendindVertex.enqueue(adjacentVertex);
					visitedVertex.add(adjacentVertex);
					alreadyVisited.put(adjacentVertex, true);
				}
			}
		}
		
		for (Vertex currentVertex : this.vertices) {
			if(!visitedVertex.contains(currentVertex)){
				return false;
			}
		}
		return true;
	}
		
	
	//return connected component of the graph
	public ArrayList<ArrayList<Vertex>> getconnectedComponent() {
	
		HashMap<Vertex, Boolean> alreadyVisited = new HashMap<>();
		ArrayList<ArrayList<Vertex>>connectedComponent = new ArrayList<>();
		for (Vertex currentVertex : this.vertices) {
			if(alreadyVisited.containsKey(currentVertex)){
				continue;
			}
			else{
				connectedComponent.add(BFS(currentVertex,alreadyVisited));
			}
		}	
		
		return connectedComponent;
	}

	
	private ArrayList<Vertex> BFS(Vertex currentVertex,
			HashMap<Vertex, Boolean> alreadyVisited) {
		// TODO Auto-generated method stub

		QueueUsingLL<Vertex> pendingVertex = new QueueUsingLL<>();
		ArrayList<Vertex> connectedVertices = new ArrayList<>();

		connectedVertices.add(currentVertex);
		alreadyVisited.put(currentVertex, true);
		pendingVertex.enqueue(currentVertex);
		while (!pendingVertex.isEmpty()) {
			Vertex v1 = null;
			try {
				v1 = pendingVertex.dequeue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			ArrayList<Vertex> adjacentVertices = v1.getAdjacentVertices();
			for (Vertex adjacentVertex : adjacentVertices) {
				if (!alreadyVisited.containsKey(adjacentVertex)) {
					alreadyVisited.put(adjacentVertex, true);
					connectedVertices.add(adjacentVertex);
					pendingVertex.enqueue(adjacentVertex);
				}
			}
		}
		return connectedVertices;
	}

	// check if graph is Bipartite or not
	public boolean isBiPartite() {

		HashMap<Vertex, Boolean> alreadyVisited = new HashMap<>();
		HashMap<Vertex, Boolean> setV1 = new HashMap<>();
		HashMap<Vertex, Boolean> setV2 = new HashMap<>();
		QueueUsingLL<Vertex> pendingVertex = new QueueUsingLL<>();
		
		for (Vertex currentVertex : this.vertices) {
			if (!alreadyVisited.containsKey(currentVertex)) {

				//put the current vertex into already visited list
				alreadyVisited.put(currentVertex, true);
				setV1.put(currentVertex, true);
				pendingVertex.enqueue(currentVertex);
				
				while (!pendingVertex.isEmpty()) {
					Vertex v1 = null;
					try {
						v1 = pendingVertex.dequeue();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					/*
					 * check if current vertex is in setV1 or setV2 than add its
					 * adjacent vertices to other set
					 */
					
					ArrayList<Vertex> adjacentVertices = v1.getAdjacentVertices();
					if (setV1.containsKey(v1)) {
						for (Vertex adjacentVertex : adjacentVertices) {
							if(!setV2.containsKey(adjacentVertex)){
								alreadyVisited.put(adjacentVertex, true);
								pendingVertex.enqueue(adjacentVertex);
								setV2.put(adjacentVertex, true);
							}
						}
					}
					else {
						for (Vertex adjacentVertex : adjacentVertices) {
							if(!setV1.containsKey(adjacentVertex)){
								alreadyVisited.put(adjacentVertex, true);
								pendingVertex.enqueue(adjacentVertex);
								setV1.put(adjacentVertex, true);
							}
						}
					}
				} 
			}
		}
		/*
		 * now we will check for every vertex in graph that is it present in
		 * both set (setV1 and setV2) or not, if present than the graph is not
		 * bipartite graph
		 */
		for (Vertex currentVertex : this.vertices) {
			if(setV1.containsKey(currentVertex)&&setV2.containsKey(currentVertex)){
				return false;
			}
		}
		return true;
	}
}

