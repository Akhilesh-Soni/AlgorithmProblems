package flightplanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightPlanner {

	public static void createFlightsAvailable(String inputDepartureCity,
			String inputArrivalCity, int inputDepartureTime,
			int inputArrivalTime, Graph makeCityNetwork) throws Exception {
		String tempLine, fileDepartureCity, fileArrivalCity;
		int fileDepartureTime, fileArrivalTime, filePrice;

		// read the data from file
		File file = new File(
				"E:\\Android Project\\AlgorithmTraining\\src\\flightplanner\\FlightDatabase.txt");
		Scanner readFile = new Scanner(file);

		QueueUsingLL<String> pendingCities = new QueueUsingLL<>();
		pendingCities.enqueue(inputDepartureCity);

		while (!pendingCities.isEmpty()) {

			inputDepartureCity = pendingCities.dequeue();
			while (readFile.hasNext()) {
				ArrayList<String> stringArray = new ArrayList<>();
				tempLine = readFile.nextLine();

				for (String string : tempLine.split("\\s+")) {
					stringArray.add(string);
				}

				fileDepartureCity = stringArray.get(0);
				fileArrivalCity = stringArray.get(1);
				fileDepartureTime = Integer.parseInt(stringArray.get(2));
				fileArrivalTime = Integer.parseInt(stringArray.get(3));
				filePrice = Integer.parseInt(stringArray.get(5));

				// check if there is departure city present in database
				if (inputDepartureCity.equals(fileDepartureCity)) {

					// check if departure time and arrival time is match or not
					if (inputDepartureTime <= fileDepartureTime
							&& inputArrivalTime >= fileArrivalTime) {
						
						// we create a two vertex represent two different city
						makeCityNetwork.addVertexandEdge(fileDepartureCity,
								fileArrivalCity, fileDepartureTime,
								fileArrivalTime, filePrice);
						

						if (!inputArrivalCity.equals(fileArrivalCity)) {
							pendingCities.enqueue(fileArrivalCity);
						}
					}
				}

			}
			readFile = new Scanner(file);
		}
		// makeCityNetwork.printVertexeandEdges();
		readFile.close();
	}

	/* find all paths from source to destination */
	public static ArrayList<ArrayList<Vertex>> findRoute(String departureCity,
			String ArrivalCity, Graph cityNetwork)
			throws VertexNotFoundException {
		return cityNetwork.findAllPath(departureCity, ArrivalCity);
	}

	private static void findMostPromisingPath(
			ArrayList<ArrayList<Vertex>> allPaths, String departureTimeString,
			Graph cityNetwork) {
		// TODO Auto-generated method stub
		int mostPromisingPrice = Integer.MAX_VALUE;
		ArrayList<Vertex> mostPromisingPath = new ArrayList<>();
		for (ArrayList<Vertex> arrayList : allPaths) {
			int index = 0;
			int size = arrayList.size();
			int parentDepartureTime = 0, parentPrice = 0;
			while (index < size - 1) {
				Edge currentEdge = cityNetwork.getEdgeBetween(
						arrayList.get(index), arrayList.get(index + 1));
				if (parentDepartureTime <= currentEdge.departureTime) {
					parentDepartureTime = currentEdge.arrivalTime + 30;
					parentPrice += currentEdge.price;
					// System.out.println("Source = "+currentEdge.source.name+" Destination = "+currentEdge.destination.name+" Departure Time = "+currentEdge.departureTime+" Arrival Time = "+currentEdge.arrivalTime+" Price = "+currentEdge.price);
				} else {
					parentPrice = Integer.MAX_VALUE;
				}
				index++;
			}
			// System.out.println(parentPrice);
			if (mostPromisingPrice > parentPrice) {
				mostPromisingPrice = parentPrice;
				mostPromisingPath = arrayList;
			}
		}
		if (mostPromisingPrice != Integer.MAX_VALUE) {
			for (Vertex vertex : mostPromisingPath) {
				System.out.print(vertex.name + "-->");
			}
			System.out.println("\nTotal amount is :- " + mostPromisingPrice);
		} else {
			System.out.println("There is no route present for given departure time "
					+ departureTimeString);
		}
	}

	public static void main(String[] args) throws Exception {

		String departureCity, arrivalCity, departureTimeString, arrivalTimeString;
		int departureTimeInt, arrivalTimeInt;
		Graph cityNetwork = new Graph();
		ArrayList<ArrayList<Vertex>> allPaths = null;
		Scanner readInput = new Scanner(System.in);
		System.out.print("Enter The Departure City :- ");
		departureCity = readInput.nextLine();
		System.out.print("\nEnter The Arrival City :- ");
		arrivalCity = readInput.nextLine();
		System.out.print("\nEnter The Departure Time :- ");
		departureTimeString = readInput.nextLine();
		System.out.print("\nEnter The Arrival Time :- ");
		arrivalTimeString = readInput.nextLine();

		departureTimeInt = Integer.parseInt(departureTimeString);
		arrivalTimeInt = Integer.parseInt(arrivalTimeString);

		// Create city network which contain departure city and arrival city as
		// well as other city
		createFlightsAvailable(departureCity, arrivalCity, departureTimeInt,
				arrivalTimeInt, cityNetwork);

		// find all possible route in that city network which contain city
		// network
		allPaths = findRoute(departureCity, arrivalCity, cityNetwork);
		System.out.println("All possible path from " + departureCity + " to "
				+ arrivalCity + ":- ");
		for (ArrayList<Vertex> arrayList : allPaths) {
			for (Vertex vertex : arrayList) {
				System.out.print(vertex.name + "->");
			}
			System.out.println();
		}

		// find most promising path in city network
		System.out.println("The most promissing path from " + departureCity
				+ " to " + arrivalCity + " at departure time " + departureTimeString + " :- ");
		findMostPromisingPath(allPaths, departureTimeString, cityNetwork);

		readInput.close();
	}

}
