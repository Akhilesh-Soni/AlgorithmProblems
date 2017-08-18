package l8;

public class GraphUse {
	public static void main(String args[]) {
		Graph g = new Graph();
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		try {
			g.addEdge("A", "B");
			g.addEdge("B", "C");
			g.addEdge("B", "D");
			g.addEdge("C", "E");
			g.addEdge("D", "E");
			g.addEdge("E", "F");
			g.addEdge("D", "E");
			
			g.print();
			
			//System.out.println(g.hasPathBFS("A", "E"));
			System.out.println(g.hasPath("A", "C"));
			
			/*System.out.println();
			System.out.println(g.areAdjacent("A", "C"));
			System.out.println(g.areAdjacent("A", "B"));
			g.removeEdge("A", "D");
			System.out.println(g.areAdjacent("A", "D"));
			g.print();
			System.out.println();
			g.removeVertex("B");
			System.out.println(g.areAdjacent("A", "B"));
			g.print();
*/			
		} catch (VertexNotFoundException e) {
			System.out.println("Shouldn't come here");
		}
	}
}
