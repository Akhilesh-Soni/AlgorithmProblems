package l8;

import java.util.ArrayList;

class Vertex {
	String name;
	ArrayList<Edge> edges;
	
	public Vertex(String name) {
		this.name = name;
		edges = new ArrayList<>();
	}

	public int numberEdge() {
		return edges.size();
	}

	public void addEdge(Edge e) {
		edges.add(e);
	}

	public void print() {
		String toBePrinted = this.name + " : ";
		for (Edge e: edges) {
			if (e.v1 == this) {
				toBePrinted += e.v2.name + ",";
			} else {
				toBePrinted += e.v1.name + ",";
			}
		}
		System.out.println(toBePrinted);
	}

	public void removeEdgeWith(Vertex v2) {
		for (Edge e: edges) {
			if (e.v1 == v2 || e.v2 == v2) {
				edges.remove(e);
				return;
			}
		}
	}

	public ArrayList<Vertex> getAdjacentVertices() {
		ArrayList<Vertex> adjacent = new ArrayList<>();
		for (Edge e: edges) {
			if (e.v1 != this) {
				adjacent.add(e.v1);
			} else {
				adjacent.add(e.v2);
			}
		}
		return adjacent;
	}

	public boolean isAdjacent(Vertex v2) {
		for (Edge e: edges) {
			if (e.v1 == v2 || e.v2 == v2) {
				return true;
			}
		}
		return false;
	}
}
