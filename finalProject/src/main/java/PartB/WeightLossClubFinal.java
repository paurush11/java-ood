package PartB;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;

public class WeightLossClubFinal extends AbstractClub {

	private static List<String> personCSVList = new ArrayList<>(Arrays.asList("1,25,Jim,311,11", "2,21,Sam,315,15",
		"3,17,Dan,314,14", "4,19,Bob,312,12", "5,16,Ann,310,10", "6,23,Eve,313,13"));

	private List<AbstractPerson> personList = new ArrayList<AbstractPerson>();

	List<Integer> getWeightStatus = new ArrayList<Integer>();

	private static Comparator<AbstractPerson> nameComparator = (a, b) -> a.getName().compareTo(b.getName());

	private static Comparator<AbstractPerson> weightLossComparator = (a, b) -> a.getWeightLossLbs()
		- (b.getWeightLossLbs());

	private static Consumer<AbstractPerson> action = a -> System.out.println(a.toString());

	@Override
	public void sortAndShow(Comparator<? super AbstractPerson> compare, Consumer<AbstractPerson> action) {

		this.personList.stream().sorted(compare).forEach(action);
		System.out.println("\n");
	}

	@Override
	public void add(AbstractPerson p) {

		personList.add(p);
	}

	@Override
	public List<Integer> getWeightLossStats() {

		for (AbstractPerson person : personList) {
			this.getWeightStatus.add(person.getWeightLossLbs());
		}
		return this.getWeightStatus;
	}

	public static String graphToString(int weightLoss) {

		String[] graph = new String[weightLoss];

		Arrays.fill(graph, "*");

		return Arrays.toString(graph);
	}

	public Person parseCSV(String csv) {

		String[] arr = csv.split(",");

		Person person = new Person(Integer.parseInt(arr[1]), arr[2]);

		person.setId(Integer.parseInt(arr[0]));

		person.setWeightLbs(Integer.parseInt(arr[3]));

		person.setWeightLossLbs(Integer.parseInt(arr[4]));

		return person;
	}

	public static void createGraph(int xAxis, String yAxis, HashMap<String, String> map) {

		map.put(String.valueOf(xAxis), yAxis);
	}

	public void demo() {

		for (String person : personCSVList) {

			this.add(parseCSV(person));
		}

		this.sortAndShow(nameComparator, action);

		this.sortAndShow(weightLossComparator, action);

		// Create the graph

		HashMap<String, String> currentGraphMap = new HashMap<String, String>();

		for (AbstractPerson person : personList) {

			createGraph(person.getWeightLossLbs(), graphToString(person.getWeightLossLbs()), currentGraphMap);

		}

		System.out.println("\nDislay current weight loss graph in ascending order\n");

		/*
		 * Dislay graph in ascending order
		 */
		currentGraphMap.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()))
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		System.out.println("\nDislay current weight loss graph in descending order\n");
		/*
		 * Dislay graph in descending order
		 */

		currentGraphMap.entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey()))
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		HashMap<String, String> oneMonthGraphMap = new HashMap<String, String>();

		for (AbstractPerson person : personList) {

			createGraph(person.getWeightLossLbs() + 10, graphToString(person.getWeightLossLbs() + 10),
					oneMonthGraphMap);

		}

		System.out.println("\nDislay one month weight loss graph in ascending order\n");

		/*
		 * Dislay graph in ascending order
		 */
		oneMonthGraphMap.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()))
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		System.out.println("\nDislay one month weight loss graph in descending order\n");
		/*
		 * Dislay graph in descending order
		 */

		oneMonthGraphMap.entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey()))
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		HashMap<String, String> oneYearGraphMap = new HashMap<String, String>();

		for (AbstractPerson person : personList) {

			createGraph(person.getWeightLossLbs() + 20, graphToString(person.getWeightLossLbs() + 20), oneYearGraphMap);

		}

		System.out.println("\nDislay one year weight loss graph in ascending order\n");

		/*
		 * Dislay graph in ascending order
		 */
		oneYearGraphMap.entrySet().stream().sorted((a, b) -> a.getKey().compareTo(b.getKey()))
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));

		System.out.println("\nDislay one year weight loss graph in descending order\n");
		/*
		 * Display graph in descending order
		 */

		oneYearGraphMap.entrySet().stream().sorted((a, b) -> b.getKey().compareTo(a.getKey()))
				.forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
	}

	public static void main(String args[]) {

		WeightLossClubFinal club = new WeightLossClubFinal();

		club.demo();
	}
}
