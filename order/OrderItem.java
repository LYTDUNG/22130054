package order;

public class OrderItem implements Comparable<OrderItem>{
	private Product p;
	private int quantily;
	public OrderItem(Product p, int quantily) {
		super();
		this.p = p;
		this.quantily = quantily;
	}
	
	 public Product getProduct() {
		    return p;
		  }

	@Override
	public String toString() {
		return p + ": " + quantily;
	}
	@Override
	public int compareTo(OrderItem o) {
	    return Double.compare(o.getProduct().getPrice(), p.getProduct().getPrice());
	}

}
