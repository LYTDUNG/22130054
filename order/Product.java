package order;

public class Product {
	private String id;
	private String name;
	private double price;
	private String type;
	public Product(String id, String name, double price, String type) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.type = type;
	}
	public String getId() {
		return id;
}
	public double getPrice() {
		return 0;
	}
	public Product getProduct() {
		return null;
	}
	@Override
    public String toString() {
        return name + " (" + type + "): $" + price;
    }
}