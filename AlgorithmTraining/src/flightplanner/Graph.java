package flightplanner;

import java.util.ArrayList;

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
	
	
	//add the vertex in vertices list and create edge b/w them
	public void addVertexandEdge(String city1, String city2,int fileDepartureTime,int fileArrivalTime,int filePrice) {
		
		Vertex v1 = this.findVertex(city1);
		Vertex v2 = this.findVertex(city2);
		if(v1 == null){
			v1 = new Vertex(city1);
			this.vertices.add(v1);
		}
		if(v2 == null){
			v2 = new Vertex(city2);
			this.vertices.add(v2);
		}
		addEdges(v1, v2, fileDepartureTime,fileArrivalTime,filePrice );
	}
	
	
	//add edges between two vertices 
	private void addEdges(Vertex v1, Vertex v2,int fileDepartureTime,int fileArrivalTime,int filePrice) {
		// TODO Auto-generated method stub
		
		//check if there is already an edge present or not b/w v1 and v2
		for (Edge currentEdge : v1.edges) {
			if(currentEdge.destination.equals(v2)){
				return;
			}
		}
		Edge e = new Edge(v1, v2,fileDepartureTime,fileArrivalTime,filePrice);
		v1.addEdge(e);
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
	
	public Edge getEdgeBetween(Vertex source, Vertex destination) {
		// TODO Auto-generated method stub
		for (Edge currentEdge : source.edges) {
			if(currentEdge.destination.equals(destination)){
				return currentEdge;
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
	
	
	//Breadth First Search algorithm to find all path b/w source and destination
	public ArrayList<ArrayList<Vertex>> findAllPath(String sourceName,String destinationName){
		Vertex departureCity = findVertex(sourceName);
		Vertex arrivalCity = findVertex(destinationName);
		if(departureCity == null || arrivalCity == null){
			System.out.println("There is no route present between "+sourceName+" and "+destinationName);
			System.exit(0);
		}
		return hasPathBFS(departureCity,arrivalCity);
	}

	private ArrayList<ArrayList<Vertex>>  hasPathBFS(Vertex departureCity, Vertex arrivalCity) {
		// TODO Auto-generated method stub
		
		ArrayList<ArrayList<Vertex>> allPaths = new ArrayList<>();
		ArrayList<Vertex> tempPath = new ArrayList<>();
		QueueUsingLL<ArrayList<Vertex>> queue = new QueueUsingLL<>();
		Vertex lastCity = new Vertex(null);
		tempPath.add(departureCity);
		queue.enqueue(tempPath);
		while (!queue.isEmpty()) {
			try {
				tempPath = queue.dequeue();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lastCity = tempPath.get(tempPath.size()-1);
			
			if(lastCity.equals(arrivalCity)){
				allPaths.add(tempPath);
			}
			
			for (Vertex currentCity : lastCity.getAdjacentVertices()) {
				ArrayList<Vertex>newPath = new ArrayList<>();
				for (Vertex vertex : tempPath) {
					newPath.add(vertex);
				}
				newPath.add(currentCity);
				queue.enqueue(newPath);
			}
		}
		return allPaths;
	}

	
}

