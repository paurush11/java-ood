package partC;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import partC.Item.AbstractFactoryAPI;

public class Cart {

	private double myTotal = 0;

	private List<Item> items = new ArrayList<>();

	public Cart() {
	}

	public Cart(int myCash, int myTotal, int myChange) {
		super();
		this.myTotal = myTotal;
	}

	public void add(Item item) {
		this.items.add(item);
	}

	public void remove(Item item) {
		this.items.remove(item);
	}

	public double checkOut(Cart myCart) {

		this.myTotal = 0;

		for (Item it : items) {

			this.myTotal += it.getItemPrice();

			DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/YYYY");

			Date date = new Date();

			System.out.println("Transaction Timestamp : " + dateFormat.format(date));

			System.out.println("Name: " + it.getItemName() + "   " + "Price: $" + it.getItemPrice() + " " + "Total: $"
					+ myCart.toString());
		}

		return this.myTotal;
	}

	public static void demo() {

		Cart cart = new Cart();

		AbstractFactoryAPI itemFactory = Item.AbstractItemFactory.getInstance();

		Item one = itemFactory.getFactoryItem("#2", 2.49, "Milk");

		Item two = itemFactory.getFactoryItem("#4", 1.49, "Bread");
		Item three = itemFactory.getFactoryItem("#3", 3.49, "OJ");
		Item four = itemFactory.getFactoryItem("#1", 0.99, "Candy");

		cart.add(one);
		cart.add(two);
		cart.add(three);
		cart.add(four);

		cart.sortTwo("Item_Name");

		cart.checkOut(cart);

		cart.sortTwo("Item_ID");

		cart.checkOut(cart);

		cart.sortTwo("Item_Price");

		cart.checkOut(cart);

		System.out.println("\nAfter removing one item\n");

		cart.remove(one);

		cart.checkOut(cart);

		System.out.println("\nAfter removing two items\n");

		cart.remove(two);

		cart.checkOut(cart);
	}

	public void sortOne(String param) {

		if (param.equalsIgnoreCase("Item_Name")) {

			this.items = items.stream().sorted((a, b) -> a.getItemName().compareTo(b.getItemName()))
					.collect(Collectors.toList());

		} else if (param.equalsIgnoreCase("Item_ID")) {

			this.items = items.stream().sorted((a, b) -> a.getItemID().compareTo(b.getItemID()))
					.collect(Collectors.toList());

		} else {

			this.items = this.items.stream().sorted((a, b) -> {
				return Double.compare(a.getItemPrice(), b.getItemPrice());
			}).collect(Collectors.toList());
		}

		System.out.println("\nSorted Items on " + param + "\n");

		this.items.forEach(a -> System.out.println(a.toString()));
	}
	
	public void sortTwo(String param) {

		if (param.equalsIgnoreCase("Item_Name")) {

			this.items.sort(Comparator.comparing(Item::getItemName));

		} else if (param.equalsIgnoreCase("Item_ID")) {

			this.items.sort(Comparator.comparing(Item::getItemID));

		} else {

			this.items.sort(Comparator.comparing(Item::getItemPrice));
		}

		System.out.println("\nSorted Items on " + param + "\n");
		
		this.items.forEach(a -> System.out.println(
				"Item Name: " + a.getItemName() + " Item ID " + a.getItemID() + " Item Price " + a.getItemPrice()));
	}

	@Override
	public String toString() {
		return "Total: $" + myTotal;
	}

	public static void main(String args[]) {

		demo(); // just create demo() and demo2() with different sorts
	}
}
