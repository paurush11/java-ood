package partC;

public class Item extends AbstractItemAPI {

	private Item() {

	}

	private Item(String itemID, Double itemPrice, String itemName) {
		super(itemID, itemPrice, itemName);
	}

	static abstract class AbstractFactoryAPI {

		public abstract Item getFactoryItem(String data, double d, String string);

	}

	public static class AbstractItemFactory extends AbstractFactoryAPI {

		private static AbstractItemFactory instance;

		private AbstractItemFactory() {

			instance = null;
		}

		public static AbstractItemFactory getInstance() {

			if (instance == null) {
				instance = new AbstractItemFactory();
			}

			return instance;
		}

		@Override
		public Item getFactoryItem(String data, double d, String string) {

			return new Item(data, d, string);
		}
	}

	@Override
	public String toString() {
		return "Item [itemID=" + getItemID() + ", itemPrice=" + getItemPrice() + ", itemName=" + getItemName() + "]";
	}
}
