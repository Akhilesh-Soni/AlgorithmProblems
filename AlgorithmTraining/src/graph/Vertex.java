package graph;

import java.util.ArrayList;

public class Vertex {

	String name;
	ArrayList<Edge>edges;
	public Vertex(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
		edges = new ArrayList<>();
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
			if(currentEdge.v1 == this){
				tobePrinted += currentEdge.v2.name+" , ";
			}
			else {
				tobePrinted += currentEdge.v1.name+" , ";
			}
		}
		System.out.println(tobePrinted);
	}

	//Remove the edge between two nodes
	public void removeEdgeWith(Vertex v2) {
		// TODO Auto-generated method stub
		for (Edge e : this.edges) {
			if(e.v1 == v2 || e.v2 == v2 ){
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
			if(e.v1 != this){
				adjacent.add(e.v1);
			}
			else {
				adjacent.add(e.v2);
			}
		}
		return adjacent;
	}

	//Check if two vertices are adjacent or not
	public boolean isAdjacentTO(Vertex v2) {
		// TODO Auto-generated method stub
		for (Edge e : this.edges) {
			if(e.v1 == v2 || e.v2 == v2){
				return true;
			}
		}
		return false;
	}

	
}
