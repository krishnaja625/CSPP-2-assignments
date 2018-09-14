import java.util.Arrays;
import java.util.Scanner;
class Item {
    private String name;
    private int quantity;
    private double unitPrice;
    Item(String itemName, int itemQuantity, double itemPrice) {
        name = itemName;
        quantity = itemQuantity;
        unitPrice = itemPrice;
    }
    Item(String itemName, int itemQuantity) {
        name = itemName;
        quantity = itemQuantity;
        unitPrice = 0;
    }
    public String getcartdetails() {
        return name + " " + quantity;
    }
    public String getdetails() {
        return name + " " + quantity + " " + unitPrice;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String itemName() {
        return this.name;
    }
    public int quantity() {
        return this.quantity;
    }
    public double itemPrice() {
        return this.unitPrice;
    }

}

class ShoppingCart {
    public int count = 0;
    private Item[] catalog;
    public int cartcount = 0;
    private Item[] cart;
    private double disc;
    ShoppingCart() {
        catalog = new Item[10];
        count = 0;
        disc = 0;
        cart = new Item[10];
        cartcount = 0;
    }
    public void addToCatalog(Item item) {
        catalog[count++] = item;

    }
    public void addToCart(Item item) {
        int flag = 0;
        double total = 0;
        for (int i = 0; i < cartcount; i++) {
            for (int j = 0; j < count; j++) {
                if (catalog[j].itemName().equals(item.itemName()) && cart[i].itemName().equals(item.itemName())) {
                    cart[i].setQuantity(cart[i].quantity() + item.quantity());
                    flag = 1;
                }
            }
        }
            if (flag != 1) {
                for (int j = 0; j < count; j++) {
                    if (catalog[j].itemName().equals(item.itemName())) {
                        cart[cartcount++] = item;
                    }
                }
        }
    }
    public void removeFromCart(Item item) {
        int position = 0, flag = 0;
        for (int i = 0; i < cartcount; i++) {
            if (cart[i].itemName().equals(item.itemName())) {
                cart[i].setQuantity(cart[i].quantity() - item.quantity());
                if (cart[i].quantity() == 0) {

                position = i;
                flag = 1;
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
            System.out.println(cart[i].getcartdetails());
        }

    }
    public double getTotalAmount() {
        double total = 0;
        for (int i = 0; i < cartcount; i++) {
            for (int j = 0; j < count; j++) {
                if (catalog[j].itemName().equals(cart[i].itemName())) {
                    total += cart[i].quantity() * catalog[j].itemPrice();
                }
            }   
        }
        return total;


    }
    public double getPayableAmount() {
        double amount = (getTotalAmount()/100) * disc;
        amount += amount*0.15;
        return amount;

    }
    public void applyCoupon(String coupon) {
        if (this.disc == 0.0) {

        if (coupon.equals("IND50") || coupon.equals("IND10") || coupon.equals("IND20") || coupon.equals("IND30")){
            this.disc = Double.parseDouble(coupon.substring(3, coupon.length()));
    } else {
        System.out.println("Invalid coupon");
    }
}
}

    public void printInvoice() {
        double total = 0.0;
        System.out.println("Name   quantity   price");
        for (int i = 0; i < cartcount; i++) {
            for (int j = 0; j < count; j++) {
                if (catalog[j].itemName().equals(cart[i].itemName())) {
                    System.out.println(cart[i].itemName() + " " + cart[i].quantity() + " " + catalog[j].itemPrice());

                }
            }   
        }
System.out.println("Total:" + getTotalAmount());
System.out.println("Disc%:" + (getTotalAmount()/100)* disc);
System.out.println("Tax:" + (getTotalAmount() - ((getTotalAmount()/100)* disc)) * 0.15);
System.out.println("Payable amount:" + getPayableAmount());
    }

    public void catalog() {
        for (int i = 0; i < count; i++) {
            System.out.println(catalog[i].getdetails());
        }

    }
}



/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    protected Solution() {

    }
    /**
     * main method to drive program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        ShoppingCart scart = new ShoppingCart();
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String[] token = scan.nextLine().split(" ");
            switch (token[0]) {
                case "Item":
                String[] data = token[1].split(",");
                scart.addToCatalog(new Item(data[0], Integer.parseInt(data[1]), Double.parseDouble(data[2])));
                break;
                case "catalog":
                scart.catalog();
                break;
                case "add":
                String[] data1 = token[1].split(",");
                scart.addToCart(new Item(data1[0], Integer.parseInt(data1[1])));
                break;
                case "remove":
                String[] data2 = token[1].split(",");
                scart.addToCart(new Item(data2[0], Integer.parseInt(data2[1])));
                break;
                case "show":
                scart.showCart();
                break;
                case "totalAmount":
                System.out.println("totalAmount:" + scart.getTotalAmount());
                break;
                case "payableAmount":
                System.out.println("Payable amount:" + scart.getPayableAmount());
                break;
                case "print":
                scart.printInvoice();
                case "coupon":
                scart.applyCoupon(token[1]);
                break;
                default:
            }
        }
    }
}
