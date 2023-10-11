package order;

public class OrderItem implements Comparable<OrderItem>{
	private Product p;
	private int quantily;
	public OrderItem(Product p, int quantily) {
		super();
		this.p = p;
		this.quantily = quantily;
	}
	@Override
	public int compareTo(OrderItem o) {
		
		return p.getId().compareTo(o.p.getId());
	}
	@Override
	public String toString() {
		return p + ": " + quantily;
	}
}
