package flightplanner;

import java.util.ArrayList;

public class Vertex {

	String name;
	ArrayList<Edge>edges;
	public Vertex(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.edges = new ArrayList<>();
	}
	
	//count total number of edges
	public int countEdges() {
		// TODO Auto-generated method stub
		return edges.size();
	}
	
	//add the edge to called vertex
	public void addEdge(Edge e) {
		// TODO Auto-generated method stub
		this.edges.add(e);
	}
	
	//print the vertex and its adjacent
	public void print() {
		// TODO Auto-generated method stub
		String tobePrinted = this.name+" : ";
		for (Edge currentEdge : this.edges) {
			if(currentEdge.source == this){
				tobePrinted += currentEdge.destination.name+" , ";
			}
			else {
				tobePrinted += currentEdge.source.name+" , ";
			}
		}
		System.out.println(tobePrinted);
	}

	//Remove the edge between two nodes
	public void removeEdgeWith(Vertex v2) {
		// TODO Auto-generated method stub
		for (Edge e : this.edges) {
			if(e.source == v2 || e.destination == v2 ){
				this.edges.remove(e);
				return;
			}
		}
	}

	//Get Adjacent vertices of called vertex
	public ArrayList<Vertex> getAdjacentVertices() {
		// TODO Auto-generated method stub
		ArrayList<Vertex> adjacent = new ArrayList<>();
		for (Edge e : this.edges) {
			if(e.source != this){
				adjacent.add(e.source);
			}
			else {
				adjacent.add(e.destination);
			}
		}
		return adjacent;
	}

	//Check if two vertices are adjacent or not
	public boolean isAdjacentTO(Vertex v2) {
		// TODO Auto-generated method stub
		for (Edge e : this.edges) {
			if(e.source == v2 || e.destination == v2){
				return true;
			}
		}
		return false;
	}

	
}
