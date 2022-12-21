package partC;

public class AbstractItemAPI {
	
	private String itemID;

	private Double itemPrice;

	private String itemName;
	
	
	public AbstractItemAPI() {
		super();
	}

	public AbstractItemAPI(String itemID, Double itemPrice, String itemName) {
		super();
		this.itemID = itemID;
		this.itemPrice = itemPrice;
		this.itemName = itemName;
	}

	public String getItemID() {
		return itemID;
	}

	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public Double getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(Double itemPrice) {
		this.itemPrice = itemPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
}
