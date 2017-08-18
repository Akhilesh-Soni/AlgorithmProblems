package flightplanner;

public class Edge {

	Vertex source;
	Vertex destination;
	int departureTime;
	int arrivalTime;
	int price;
	public Edge(Vertex v1, Vertex v2,int departureTime,int arrivalTime,int price) {
		this.source = v1;
		this.destination = v2;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
	}	
}
