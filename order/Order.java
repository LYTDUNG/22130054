package order;

public class Order {
	private OrderItem[] items;
	public Order(OrderItem[] items) {
		super();
		this.items = items;
	}
	public double cost() {
		return 0.0;
	}
	public boolean contains(Product p) {
		return false;
	}
	public Product[] filter(String type) {
		return null;
	}
}
