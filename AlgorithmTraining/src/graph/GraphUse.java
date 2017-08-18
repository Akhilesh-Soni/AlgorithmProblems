package graph;

import java.util.ArrayList;

import assignments.QueueEmptyException;

public class GraphUse {

	 public static void main(String []args)throws VertexNotFoundException,QueueEmptyException {
		Graph g = new Graph();
	
		//Add vertex in graph
		g.addVertex("a");
		g.addVertex("b");
		g.addVertex("c");
		g.addVertex("d");
		g.addVertex("e");
		g.addVertex("f");
		g.addVertex("g");
		g.addVertex("h");

		
		//Connect the vertices with edge
		g.addEdges("a", "b");
		g.addEdges("a", "c");
		g.addEdges("b", "d");
		g.addEdges("b", "e");
		g.addEdges("c", "h");
		g.addEdges("e", "f");
		g.addEdges("f", "g");
		g.addEdges("g", "h");
		
		//print the graph
		g.printVertexeandEdges();
		
		//System.out.println("\nIs the graph is BiPartite :- "+ g.isBiPartite());
		/*ArrayList<ArrayList<Vertex>>connectedComponent = g.getconnectedComponent();
		System.out.print("\nThe Connected Componenet of graph are:-\n");
		for (ArrayList<Vertex> connectedVertices : connectedComponent) {
			for (Vertex vertex : connectedVertices) {
				System.out.print(vertex.name+"-->");
			}
			System.out.print("\n");
		}*/
		
		//System.out.println("\nIs the graph is connected :- "+ g.isConected());
		System.out.println("\nIs there any path from A to H "+ g.hasPathDFS("a", "h"));
	
		//System.out.println("Are Vertices A and C Adjacent:- "+ g.areAdjacent("A", "C"));
		//System.out.println("Are Vertices A and D Adjacent:- "+g.areAdjacent("A", "D"));
		
//		g.removeEdge("A", "D");
//		System.out.println("Are Vertices A and D Adjacent:- "+g.areAdjacent("A", "D"));
//		System.out.println("After Removing edge between vertices A and D");
//		g.printVertexeandEdges();
//		
//		g.removeVertex("B");
//		System.out.println("After Removing Vertex B");
//		g.printVertexeandEdges();
	}
}
