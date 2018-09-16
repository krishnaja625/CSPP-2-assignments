class Item {
	private String productName;
	private int quantity;
	private Double unitPrice;

	public Item(String productName, int quantity, Double unitPrice) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}
	public Item (String productName, int quantity) {
		this.productName = productName;
		this.quantity = quantity;
		this.unitPrice = 0.0;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getProductName() {
		return this.productName;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public Double getUnitPrice() {
		return this.unitPrice;
	}
}

public class ShoppingCart {
	private Item[] catalog;
	private int catalogcount;
	private Item[] cart;
	private int cartcount;
	private Double discount;
	public ShoppingCart() {
		catalog = new Item[10];
		catalogcount = 0;
		cart = new Item[10];
		cartcount = 0;
		discount = 0.0;
	}

	public void addToCatalog(Item item) {
		catalog[catalogcount++] = item;
	}
	public void addToCart(Item item) {
		int flag = 0;
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < catalogcount; j++) {
				if (item.getProductName().equals(catalog[j].getProductName()) && item.getProductName().equals(cart[i].getProductName())) {
					cart[i].setQuantity(cart[i].getQuantity() + item.getQuantity());
					flag = 1;
				}
			}
		}
		if (flag != 1) {
			for (int i = 0; i < catalogcount; i++) {
				if (catalog[i].getProductName().equals(item.getProductName())) {
					cart[cartcount++] = item;
				}
			}
		}
	}
	public void removeFromCart(Item item) {
		int flag = 0;
		int position = 0;
		for (int i = 0; i < cartcount; i++) {
			if (item.getProductName().equals(cart[i].getProductName())) {
				cart[i].setQuantity(cart[i].getQuantity() - item.getQuantity());
				if (cart[i].getQuantity() == 0) {
                	flag = 1;
                	position = i;
                	break;
				}
			}
		}
		if (flag == 1) {
			for (int i = position; i < cartcount; i++) {
				cart[i] = cart[i + 1];
			}
			cart[cartcount - 1] = null;
			cartcount--;
		}
	}

	public void showCart() {
		for (int i = 0; i < cartcount; i++) {
			System.out.println(cart[i].getProductName() + " " + cart[i].getQuantity());
		}
	}

	public void showCatalog() {
		for (int i = 0; i < catalogcount; i++) {
			System.out.println(catalog[i].getProductName() + " " + catalog[i].getQuantity() + " " + catalog[i].getUnitPrice());
		}

	}
	public Double getTotalAmount() {
		Double amount = 0.0;
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < catalogcount; j++) {
				if (cart[i].getProductName().equals(catalog[j].getProductName())) {
					amount += catalog[j].getUnitPrice() * cart[i].getQuantity();
				}
			}
		}
		return amount;
	}
	public Double getPayableAmount() {
		Double amount = getTotalAmount();
		amount -= (amount / 100) * discount;
		amount += (amount / 100) * 15;
		return amount;
	}

	public void applyCoupon(String coupon) {
		if (this.discount == 0.0) {
			if ((coupon.equals("IND10")) || (coupon.equals("IND20")) || (coupon.equals("IND30")) || (coupon.equals("IND50"))) {
			this.discount = Double.parseDouble(coupon.substring(3, coupon.length()));
			} else {
				System.out.println("Invalid coupon");
			}
		}
	}
	public void printInvoice() {
		System.out.println("Name   quantity   Price");
		for (int i = 0; i < cartcount; i++) {
			for (int j = 0; j < catalogcount; j++) {
				if (cart[i].getProductName().equals(catalog[j].getProductName())) {
					System.out.println(cart[i].getProductName() + " " + cart[i].getQuantity() + " " + catalog[j].getUnitPrice());
				}
			}
		}
		System.out.println("Total:" + getTotalAmount());
		System.out.println("Disc%:" + (getTotalAmount() / 100) * discount);
		System.out.println("Tax:" + (getTotalAmount() - (getTotalAmount() / 100) * discount) * 0.15);
		System.out.println("Payable amount:" + " " + getPayableAmount());
	}
}